package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	private void getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "jsp", "jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}

	} // end of getConn()
	
	public List<Member> memberList(){
		getConn();
		String sql = "select * from member";
		List<Member> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getInt("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setTel(rs.getString("tel"));
				member.setMemberBday(rs.getString("member_bday"));
				member.setGender(rs.getString("gender"));
				
				list.add(member);
			}
		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		return list;
	}
	
	public String showDetail(int memberId) {
		getConn();
		
		String sql = "select * from member where member_id = ?";
		
		
			Member member = new Member();
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, memberId);
				
				psmt.executeQuery();
				if(rs.next()) {
				member.setMemberId(rs.getInt("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setTel(rs.getString("tel"));
				member.setMemberBday(rs.getString("member_bday"));
				member.setGender(rs.getString("gender"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return member.toString();
	}
	
	public boolean insertMember(Member member) {
		getConn();
		String sql = "insert into member(member_id, member_name, tel, member_bday, gender) "
					+ "values(member_seq.nextval, ?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getMemberName());
			psmt.setString(2, member.getTel());
			psmt.setString(3, member.getMemberBday());
			psmt.setString(4, member.getGender());
			int r = psmt.executeUpdate();
			
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}
	
	public boolean updateMember(Member member) {
		getConn();
		String sql = "update member set tel = ? where member_id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getTel());
			psmt.setInt(2, member.getMemberId());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}
	
	public boolean deleteMember(int memberId) {
		getConn();
		String sql = "delete member where member_id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, memberId);
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}
	
	
	
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}


