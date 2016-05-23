package com.minsub.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Select;


public interface AnnotationMapper2 {
	
	@Select("select * from nation")
	public List<NationVO> selectNationAll();
}
