package com.ln.hr.service;

import com.alibaba.druid.sql.dialect.odps.ast.OdpsAnalyzeTableStatement;
import com.ln.hr.mapper.EmployeeMapper;
import com.ln.hr.model.Employee;
import com.ln.hr.model.RespPageBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmpService {

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    RabbitTemplate rabbitTemplate;
    public final static Logger logger = LoggerFactory.getLogger(EmpService.class);

    public RespPageBean getEmpByPage(Integer page, Integer size, Employee employee, Date[] beginDateScope){
        if (page != null && size != null){
            page = (page-1)*size;
        }
        List<Employee> data = employeeMapper.getEmpByPage(page, size, employee, beginDateScope);
        Long total = employeeMapper.getToltal(employee, beginDateScope);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmp(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        //算出月份数
        double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 +
                Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month/12)));
        int result = employeeMapper.insertSelective(employee);
        if (result == 1){
            Employee newAddedEmp = employeeMapper.getEmpById(employee.getId());
            logger.info(newAddedEmp.toString());                                 //日志
            rabbitTemplate.convertAndSend("sansa.mail.welcome", newAddedEmp);
            System.out.println("发送成功！！！");
        }
        return result;
    }

    public Integer maxWorkID() {
        return employeeMapper.maxWorkID();
    }

    public Integer deleteEmpById(Integer id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }

    public Integer updateEmpById(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public RespPageBean getEmpByPageWithSalary(Integer page, Integer size) {
        if (page != null && size != null){
            page = (page-1) * size;
        }
        List<Employee> list = employeeMapper.getEmpByPageWithSalary(page, size);
        RespPageBean bean = new RespPageBean();
        bean.setData(list);
        bean.setTotal(employeeMapper.getToltal(null, null));
        return bean;
    }

    public Integer updateEmpSalaryById(Integer eid, Integer sid) {
        return employeeMapper.updateEmpSalaryById(eid, sid);
    }
}
