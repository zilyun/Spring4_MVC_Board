package com.naver.myhome4.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

	int getListCount(int board_num);

}
