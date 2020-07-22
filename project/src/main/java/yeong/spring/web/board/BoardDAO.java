package yeong.spring.web.board;

import java.util.List;



/**
 * @제목 : title
 * @패키지이름 : yeong.spring.web.board
 * @파일이름 : BoardDAO.java
 * @작성일 : 2020. 7. 21.
 * @이름 : Yeong
 * @프로그램설명 : 
 * == 수정 정보 ==
 *
 * DATE		 AUTHOR			NOTE
 * -------	--------	-------------	
 */
public interface BoardDAO {
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(BoardVO vo);
}
