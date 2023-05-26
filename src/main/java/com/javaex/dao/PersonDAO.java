package com.javaex.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVO;

@Repository//컨트롤러에서 사용할수 있게 연결역할
public class PersonDAO {
	@Autowired
	private SqlSession sqlsession;
	
	public List<PersonVO> getPersonlist() {
		List<PersonVO> personList = sqlsession.selectList("phonebook.selectList");
		System.out.println(personList);
		return personList;
	}
	
	public void personinsert(PersonVO vo) {
		sqlsession.insert("phonebook.insert",vo);
	}
	
	public int personupdate(PersonVO vo) {
		int row = sqlsession.update("phonebook.update",vo);
		return row;
	}
	
	public int persondelect(int person_id) {
		int row = sqlsession.delete("phonebook.delete",person_id);
		return row;
	}
	
	public PersonVO getPerson(int person_id) {
		PersonVO vo = sqlsession.selectOne("phonebook.selectdetail",person_id);
		return vo;
	}

	public int personinsert(String name, String hp, String company) {
		HashMap<String, String> personvo = new HashMap<String, String>();
		personvo.put("name", name);
		personvo.put("hp", hp);
		personvo.put("company", company);
		//System.out.println(personvo);
		int cnt = sqlsession.insert("phonebook.insert2", personvo);
		//System.out.println(name + hp + company);
		return cnt;
	}

}
