package yeong.spring.web.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import yeong.spring.web.common.JDBCUtil;
import yeong.spring.web.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private final static String USER_GET = "SELECT * FROM myuser WHERE id =? and password = ?";
	
	public UserVO getUser(UserVO vo) {
		System.out.println("JDBC로 getUser() 기능 처리");
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn, pstmt, rs);
		}
		return user;
	}
}
