package com.bitacademy.myportal.service;

import java.util.List;

import com.bitacademy.myportal.repository.BoardVo;

public interface BoardService {
	public List<BoardVo> getList();
	public BoardVo getContent(Long no);
	public BoardVo getContentHit(Long no);
	public boolean write(BoardVo vo);
	public boolean update(BoardVo vo);
	public boolean delete(Long no);
}
