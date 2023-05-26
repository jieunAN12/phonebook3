package com.javaex.vo;

public class PersonVO {
	
	private int person_id;
	private String name;
	private String hp;
	private String company;
	
	public PersonVO() {
		super();
	}
	
	public PersonVO(String name, String hp, String company) {
		super();
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	public PersonVO(int person_id, String name, String hp, String company) {
		super();
		this.person_id = person_id;
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "PersonVO [person_id=" + person_id + ", name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}
	
}