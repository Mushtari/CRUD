package com.LTI.College_Proj.Model;



public class Instructor {

	protected int id;
	protected String name;
	protected int phno;
	protected int rmno;
	protected int deptno;
	
	
	public Instructor(int id, String name, int phno, int rmno, int deptno) {
		super();
		this.id = id;
		this.name = name;
		this.phno = phno;
		this.rmno = rmno;
		this.deptno = deptno;
	}
	
	
	
	
	public Instructor(String name, int phno, int rmno, int deptno) {
		super();
		this.name = name;
		this.phno = phno;
		this.rmno = rmno;
		this.deptno = deptno;
	}




	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", phno=" + phno + ", rmno=" + rmno + ", deptno=" + deptno
				+ "]";
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
	public int getRmno() {
		return rmno;
	}
	public void setRmno(int rmno) {
		this.rmno = rmno;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
	
	
	
		
}