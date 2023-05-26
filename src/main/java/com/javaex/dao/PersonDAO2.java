package com.javaex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.javaex.vo.PersonVO;

@Repository
public class PersonDAO2 {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Autowired
	private DataSource ds;
	
	public Connection connect() {
		try {
			conn = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(conn != null)conn.close();
			if(pstmt != null)pstmt.close();
			if(rs != null)rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	// personinsert
	public void personinsert(PersonVO vo) {
		// System.out.println("dao "+vo.toString());
		// ctrl + shift + o 자동 인포트됨
		// 3. SQL문 준비 / 바인딩 / 실행
		// insert, update, delete 는 -> int count = pstmt.executeUpdate();
		// select -> ResultSet rs = pstmt.executeQuery();
		String sql = "insert into person values(seq_person_id.nextval,?,?,?)";
		try {
			conn = connect();
			pstmt = conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, vo.getName());//vo에서 네임을 가져와서 셋팅함
			pstmt.setString(2, vo.getHp());
			pstmt.setString(3, vo.getCompany());
			
			int count = pstmt.executeUpdate();
			
			// 4.결과처리
			System.out.println(count+"건 등록 성공");
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			close(conn, pstmt, null);
		}
	}
	
	// getPersonlist
		public ArrayList<PersonVO> getPersonlist() {
			ArrayList<PersonVO> plist = new ArrayList<PersonVO>();
			String sql = "select person_id, name, hp, company from person";
			try {
				conn = connect();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					PersonVO vo = new PersonVO();
					vo.setPerson_id(rs.getInt("person_id"));
					vo.setName(rs.getString("name"));
					vo.setHp(rs.getString("hp"));
					vo.setCompany(rs.getString("company"));
					plist.add(vo);
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			} finally {
				close(conn, pstmt, rs);
			}
			return plist;
		}
		
		public int personupdate(PersonVO vo) {
			int row = 0;
			String sql = "update person set name=?, hp=?, company=? where person_id = ? ";
			try {
			conn = connect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getHp());
			pstmt.setString(3, vo.getCompany());
			pstmt.setInt(4, vo.getPerson_id());
			row = pstmt.executeUpdate();
//				if(pstmt.executeUpdate() > 0) {
//					System.out.println("update 성공!!!");
//					bool = true;
//				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(conn, pstmt, null);
			}
			return row;
		}
		
		public int persondelect(int person_id) {
			String sql = "delete from person where person_id = ? ";
			int row=0;
			try {
				conn = connect();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, person_id);
				row = pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(conn, pstmt, null);
			}
			return row;
		}
		
		//1명 정보 가져오기
		public PersonVO getPerson(int person_id) {
			PersonVO vo = null;
			try {
				conn = connect();
				String sql = "select person_id, name, hp, company from person where person_id = ? ";
				//바인딩 
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, person_id);
				//실행
				rs = pstmt.executeQuery();
				// 4.결과처리
				while(rs.next()) {
					vo = new PersonVO();
					vo.setPerson_id(rs.getInt("person_id"));
					vo.setName(rs.getString("name"));
					vo.setHp(rs.getString("hp"));
					vo.setCompany(rs.getString("company"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(conn, pstmt, rs);
			}
			return vo;
		}

}//class end
