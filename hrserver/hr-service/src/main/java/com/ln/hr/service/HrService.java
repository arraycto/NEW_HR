package com.ln.hr.service;

import com.ln.hr.mapper.HrMapper;
import com.ln.hr.mapper.HrRoleMapper;
import com.ln.hr.model.Hr;
import com.ln.hr.model.RespBean;
import com.ln.hr.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;
    @Autowired
    HrRoleMapper hrRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(s);
        if (hr ==null){
            throw new UsernameNotFoundException("用户名不存在");
        } else {
            hr.setRoles(hrMapper.getHrRoleSById(hr.getId()));
        }
        return hr;
    }

    public List<Hr> getAllHrs(String keywords) {
        return hrMapper.getAllHrs(HrUtils.getCurrentHr().getId(),keywords);
    }

    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        hrRoleMapper.deleteByHrId(hrid);
        return hrRoleMapper.addRole(hrid, rids) == rids.length;
    }

    public Integer deleteByHrId(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }

    public List<Hr> getAllHrWithoutCurrent() {
        return hrMapper.getAllHrWithoutCurrent(HrUtils.getCurrentHr().getId());
    }
}
