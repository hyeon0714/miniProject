package com.javaex.miniproject;

public class PhoneDB {
	
	private String name;
	private String hp;
	private String company;
	
	public PhoneDB() {
	}
	
	public PhoneDB(String name, String hp, String company) {
		
		this.hp=hp;
		this.name=name;
		this.company=company;
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
		return "PhoneDB [name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}
	
	public void showInfo() {
		System.out.println("\t"+name+"\t"+hp+"\t"+company);
	}
	
	public String getOut() {
		return name+","+hp+","+company;
	}
	
	
}
