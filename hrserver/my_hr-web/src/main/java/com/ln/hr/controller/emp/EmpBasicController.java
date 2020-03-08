package com.ln.hr.controller.emp;

import com.ln.hr.model.*;
import com.ln.hr.service.*;
import com.ln.hr.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {

    @Autowired
    EmpService empService;
    @Autowired
    NationService nationService;
    @Autowired
    PoliticsStatusService politicsStatusService;
    @Autowired
    JobLevelService jobLevelService;
    @Autowired
    PositionService positionService;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public RespPageBean getEmpByPage(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "10") Integer size,
                                     Employee employee, Date[] beginDateScope){
        return empService.getEmpByPage(page, size, employee, beginDateScope);
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee){
        if (empService.addEmp(employee) == 1){
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpById(@PathVariable Integer id){
        if (empService.deleteEmpById(id) == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.ok("删除失败");
    }

    @PutMapping("/")
    public RespBean updateEmpById(@RequestBody Employee employee){
        if (empService.updateEmpById(employee) == 1){
            return RespBean.ok("更新成功!");
        }
        return RespBean.ok("更新失败");
    }

    @GetMapping("/nations")
    public List<Nation> getAllNations(){
        return nationService.getAllNations();
    }

    @GetMapping("/politicsStatus")
    public List<Politicsstatus> getAllPoliticsStatus(){
        return politicsStatusService.getAllPoliticsStatus();
    }

    @GetMapping("/jobLevels")
    public List<JobLevel> getAllJobLevel(){
        return jobLevelService.getAllJobLevel();
    }

    @GetMapping("/positions")
    public List<Position> getAllPosition(){
        return positionService.getAllPosition();
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/maxWorkID")                            //rerturn数据库的最大的工号
    public RespBean maxWorkID(){
        RespBean respBean = RespBean.build().setStatus(200).setObj(String.format("%08d", empService.maxWorkID() + 1));
        return respBean;
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData(){
        List<Employee> list = (List<Employee>) empService.getEmpByPage(null, null, null, null).getData();
        return POIUtils.employee2Excel(list);
    }
}
