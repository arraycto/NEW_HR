package com.ln.hr.controller.salary;

import com.ln.hr.model.RespBean;
import com.ln.hr.model.RespPageBean;
import com.ln.hr.model.Salary;
import com.ln.hr.service.EmpService;
import com.ln.hr.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salary/sobcfg")
public class SobConfigController {

    @Autowired
    EmpService empService;
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public RespPageBean getEmpByPageWithSalary(@RequestParam(defaultValue = "1") Integer page,
                                               @RequestParam(defaultValue = "10") Integer size){
        return empService.getEmpByPageWithSalary(page, size);
    }

    @GetMapping("/salary")
    public List<Salary> getAllSalary(){
        return salaryService.getAllSalary();
    }

    @PutMapping("/")
    public RespBean updateEmpSalaryById(Integer eid, Integer sid){
        Integer result = empService.updateEmpSalaryById(eid, sid);
        if (result == 1 || result == 2){
            return RespBean.ok("更新员工工资账套成功!");
        }
        return RespBean.error("更新员工工资账套失败");
    }
}
