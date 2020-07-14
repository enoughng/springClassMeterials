package yeong.spring.web.board;

public class BoardSQLStatement {
	public final static String BOARD_INSERT = "INSERT INTO myboard(seq, title, writer, content) VALUES((SELECT nvl(max(seq), 0)+1 FROM myboard), ?, ? ,?)";
	public final static String BOARD_UPDATE = "UPDATE myboard set title = ?, content=? WHERE seq = ?";
	public final static String BOARD_DELETE = "DELETE FROM myboard WHERE seq = ?";
	public final static String BOARD_GET = "SELECT * FROM myboard WHERE seq = ?";
//	public final static String BOARD_LIST = "SELECT * FROM myboard ORDER BY seq desc";
	public final static String BOARD_LIST_T = "SELECT * FROM myboard "
			+ "WHERE title like '%'||?||'%' ORDER BY seq desc";
	public final static String BOARD_LIST_C = "SELECT * FROM myboard "
			+ "WHERE content like '%'||?||'%' ORDER BY seq desc";

}
