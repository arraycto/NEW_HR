package com.ln.hr.service;

import com.ln.hr.mapper.PoliticsstatusMapper;
import com.ln.hr.model.Politicsstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoliticsStatusService {

    @Autowired
    PoliticsstatusMapper politicsstatusMapper;

    public List<Politicsstatus> getAllPoliticsStatus() {
        return politicsstatusMapper.getAllPoliticsStatus();
    }
}
