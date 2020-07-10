package yeong.spring.web.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import yeong.spring.web.common.JDBCUtil;
import yeong.spring.web.user.UserVO;
import yeong.spring.web.user.dao.UserDAO;

@Repository
public class OracleUserDAO implements UserDAO{
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private final String USER_GET = "select * from myuser where id=? and password=?";

	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		try {
			System.out.println("JDBC로 getUser() 기능 처리");
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(USER_GET);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, pstmt, rs);
		}
		return user;
	}
}
