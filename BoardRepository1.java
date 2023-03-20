package 교수님github.day19_20230323_BoardInterface_02;

import java.util.ArrayList;
import java.util.*;

public class BoardRepository1 implements BoardRepositoryInt {
	private Map<String, BoardDTO> boardMap = new HashMap<>();

	public boolean save(BoardDTO boardDTO) {
		BoardDTO result = boardMap.put(boardDTO.getBno(), boardDTO);
		if (result == null) {
			return true;
		} else {
			return false;
		}
	}

	public Map<String, BoardDTO> findAll() {
		return boardMap;
	}

	public BoardDTO findById(String bno) {
		for (String key : boardMap.keySet()) {
			if (bno.equals(boardMap.get(key).getBno())) {
				return boardMap.get(key);
			}
		}
		return null;
	}

	public boolean update(BoardDTO boardDTO, String bno) {
		for (String key : boardMap.keySet()) {
			if (bno.equals(boardMap.get(key).getBno())) {
				boardMap.get(key).setTitle(boardDTO.getTitle());
				boardMap.get(key).setWriter(boardDTO.getWriter());
				return true;
			}
		}
		return false;
	}

	public boolean delete(String bno) {
		for (String key : boardMap.keySet()) {
			if (bno.equals(boardMap.get(key).getBno())) {
				boardMap.remove(key);
				return true;
			}
		}
		return false;
	}

}
