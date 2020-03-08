package com.ln.hr.exception;

import com.ln.hr.model.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLSyntaxErrorException;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有关联，操作失败");
        }
        if (e instanceof SQLSyntaxErrorException){
            return RespBean.error("=====Bad SQL=====");
        }
        return RespBean.error("数据库操作异常");
    }
}
