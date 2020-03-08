package com.ln.hr.controller.system;

import com.ln.hr.model.Hr;
import com.ln.hr.model.RespBean;
import com.ln.hr.model.Role;
import com.ln.hr.service.HrService;
import com.ln.hr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {

    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords){
        return hrService.getAllHrs(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr){
        if (hrService.updateHr(hr) == 1){
            return RespBean.ok("更改状态成功!");
        }
        return RespBean.error("更改状态失败");
    }

    @GetMapping("/role")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid, Integer[] rids){
        if (hrService.updateHrRole(hrid, rids)){
            return RespBean.ok("更改角色成功!");
        }
        return RespBean.error("更改角色失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteByHrId(@PathVariable Integer id){
        if (hrService.deleteByHrId(id) == 1){
            return RespBean.ok("删除角色成功!");
        }
        return RespBean.error("删除失败");
    }
}
