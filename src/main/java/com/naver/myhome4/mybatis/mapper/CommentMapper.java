package com.naver.myhome4.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.naver.myhome4.domain.Comment;

@Mapper
public interface CommentMapper {

	int getListCount(int board_num);

	int commentsInsert(Comment c);

	List<Comment> getCommentList(Map<String, Integer> map);

	int commentsDelete(int num);

	int commentsUpdate(Comment co);

}
