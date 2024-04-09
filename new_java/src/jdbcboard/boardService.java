package jdbcboard;

import java.util.List;

//boardService.java
public interface boardService {

	 int remove(int bno);
	
	 int register(boardVO b);
	
	 boardVO getDetail(int bno);
	
	 int modify(boardVO p);
	
	 List<boardVO> getList();

}


