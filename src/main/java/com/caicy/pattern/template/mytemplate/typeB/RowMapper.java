package com.caicy.pattern.template.mytemplate.typeB;

import java.sql.ResultSet;

/**
 * 映射sql结果和实体类
 */
public interface RowMapper<T> {
     T mapRow(ResultSet rs, int rowNum) throws Exception;
}
