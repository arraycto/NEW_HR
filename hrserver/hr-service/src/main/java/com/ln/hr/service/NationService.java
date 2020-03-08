package com.ln.hr.service;

import com.ln.hr.mapper.NationMapper;
import com.ln.hr.model.Nation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationService {

    @Autowired
    NationMapper nationMapper;

    public List<Nation> getAllNations() {
        return nationMapper.getAllNations();
    }
}
