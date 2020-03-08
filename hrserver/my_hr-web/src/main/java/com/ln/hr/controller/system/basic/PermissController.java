package com.ln.hr.controller.system.basic;

import com.ln.hr.model.Menu;
import com.ln.hr.model.RespBean;
import com.ln.hr.model.Role;
import com.ln.hr.service.MenusService;
import com.ln.hr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenusService menusService;

    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenu(){
        return menusService.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable int rid){
        return menusService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids){
        if (menusService.updateMenuRole(rid, mids)){                //采取先删除所有，再插入已选中的
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("失败");
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if (roleService.addRole(role) == 1){
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid){
        if (roleService.deleteRoleById(rid) == 1){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败");
    }
}
