package com.ln.hr.controller.system.basic;

import com.ln.hr.model.JobLevel;
import com.ln.hr.model.RespBean;
import com.ln.hr.service.JobLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {
    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    public List<JobLevel> getAllJobLevel(){
        return jobLevelService.getAllJobLevel();
    }

    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel){
        if (jobLevelService.addJobLevel(jobLevel) == 1){
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("失败");
    }

    @PutMapping("/")
    public RespBean updateJobLevelById(@RequestBody JobLevel jobLevel){
        if (jobLevelService.updateJobLevelById(jobLevel) == 1){
            return RespBean.ok("更改成功!");
        }
        return RespBean.error("失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJobLevelById(@PathVariable Integer id){
        if (jobLevelService.deleteJobLevelById(id) == 1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("失败");
    }

    @DeleteMapping("/")
    public RespBean deleteAllJobLevel(Integer[] ids){
        if (jobLevelService.deleteAllJobLevel(ids) == ids.length){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
