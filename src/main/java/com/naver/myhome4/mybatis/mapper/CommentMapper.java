package com.naver.myhome4.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.naver.myhome4.domain.Comment;

@Mapper
public interface CommentMapper {

	int getListCount(int board_num);

	int commentsInsert(Comment c);

}
