package 교수님github.day19_20230323_BoardInterface_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BoardService {
//	BoardRepositoryInt br = new BoardRepository1();
	BoardRepositoryInt br = new BoardRepository2();
	Scanner sc = new Scanner(System.in);
	
	public void save() {
		BoardDTO boardDTO = new BoardDTO();
		System.out.print("제목> ");
		boardDTO.setTitle(sc.nextLine());
		System.out.print("작성자> ");
		boardDTO.setWriter(sc.next());
		sc.nextLine();
		boolean success = br.save(boardDTO);
		if(success) {
			System.out.println("게시글 등록완료!");
		}else {
			System.out.println("게시글 등록실패ㅜ");
		}
	}
	
	// map 사용시 
//	public void findAll() {
//		Map<String, BoardDTO> boardMap = (Map<String, BoardDTO>) br.findAll();
//		System.out.println("글번호\t제목\t작성자\t조회수\t게시일");
//		System.out.println("--------------------------------------");
//		List<String> keySet = new ArrayList<>(boardMap.keySet());
//		Collections.sort(keySet);
//		for(String key : keySet) {
//			boardMap.get(key).print();
//		}
//	}
	
	// list 사용시
	public void findAll() {
		@SuppressWarnings("unchecked")
		List<BoardDTO> list = (List<BoardDTO>) br.findAll();
		System.out.println("글번호\t제목\t\t작성자\t조회수\t게시일");
		System.out.println("--------------------------------------");
		for (BoardDTO b : list) {
			b.print();
		}
	}
	
	public void findById() {
		System.out.print("읽을 글번호> ");
		String bno = sc.next();
		BoardDTO boardDTO = br.findById(bno);
		if(boardDTO == null) {
			System.out.println("찾을 수 없는 글입니다");
		}else {
			boardDTO.increaseCnt();
			System.out.println("글번호\t제목\t작성자\t조회수\t게시일");
			System.out.println("--------------------------------------");
			boardDTO.print();
		}
	}
	
	public void update() {
		System.out.print("수정할 글번호> ");
		String bno = sc.next();sc.nextLine();
		BoardDTO b = br.findById(bno);
		if(b == null) {
			System.out.println("조회할 수 없는 글번호 입니다");
		}else {
			BoardDTO boardDTO = new BoardDTO();
			System.out.print("수정할 제목> ");
			boardDTO.setTitle(sc.nextLine());
			System.out.print("수정할 작성자> ");
			boardDTO.setWriter(sc.next());
			sc.nextLine();
			if(br.update(boardDTO, bno)) {
				System.out.println("업데이트 성공");
			}else {
				System.out.println("업데이트 실패");
			}
		}
	}
	
	public void delete() {
		System.out.print("삭제할 글번호> ");
		String bno = sc.next();sc.nextLine();
		if(br.delete(bno)) {
			System.out.println("삭제완료");
		}else {
			System.out.println("삭제실패");
		}
	}
	
	public void testData() {
		for(int i=1; i<=5; i++) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setTitle("title"+i);
			boardDTO.setWriter("writer"+i);
			br.save(boardDTO);
		}		
	}	
}






