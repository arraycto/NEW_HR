package com.ln.hr.mapper;

import com.ln.hr.model.Hr;
import com.ln.hr.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HrMapper {

     List<Hr> getAllHrs(@Param("hrid") Integer hrid, @Param("keywords") String keywords);

    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    Hr loadUserByUsername(String username);

    List<Role> getHrRoleSById(Integer id);

    List<Hr> getAllHrWithoutCurrent(Integer id);
}