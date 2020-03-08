package com.ln.hr.utils;

import com.ln.hr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

public class HrUtils {
    public static Hr getCurrentHr(){
        return ((Hr)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
