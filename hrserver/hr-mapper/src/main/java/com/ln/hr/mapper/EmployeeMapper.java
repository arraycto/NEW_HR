package com.ln.hr.mapper;

import com.ln.hr.model.Employee;
import com.ln.hr.model.RespPageBean;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getEmpByPage(@Param("page") Integer page, @Param("size") Integer size,
                                @Param("emp") Employee emp, @Param("beginDateScope")Date[] beginDateScope);

    Long getToltal(@Param("emp") Employee emp, @Param("beginDateScope")Date[] beginDateScope);

    Integer maxWorkID();

    Employee getEmpById(Integer id);

    List<Employee> getEmpByPageWithSalary(@Param("page") Integer page, @Param("size") Integer size);

    Integer updateEmpSalaryById(@Param("eid") Integer eid, @Param("sid") Integer sid);
}