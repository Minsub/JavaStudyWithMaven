package com.minsub.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Select;


public interface AnnotationMapper {
	
	@Select("select * from PERS where dept = #{dept}")
	public List<Item> selectByDept(final int dept);
}
