package com.bitacademy.myportal.repository;

import java.util.List;

public interface BoardDao {
	public List<BoardVo> selectAll();
	public int insert(BoardVo boardVo);
	public BoardVo getContent(Long no);
	public BoardVo getContentHit(Long no);
	public int update(BoardVo boardVo);
	public int delete(Long no);
}
