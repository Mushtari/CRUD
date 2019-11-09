package com.LTI.College_Proj.Model;

public class Student {

	protected int id;
	protected String studname;
	protected String studdob; 
	protected int courseid; 
	protected int deptno;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(int id, String studname, String studdob, int courseid, int deptno) {
		super();
		this.id = id;
		this.studname = studname;
		this.studdob = studdob;
		this.courseid = courseid;
		this.deptno = deptno;
	}
	
	
	
	public Student(String studname, String studdob, int courseid, int deptno) {
		super();
		this.studname = studname;
		this.studdob = studdob;
		this.courseid = courseid;
		this.deptno = deptno;
	}

	public String getStudname() {
		return studname;
	}
	public void setStudname(String studname) {
		this.studname = studname;
	}
	public String getStuddob() {
		return studdob;
	}
	public void setStuddob(String studdob) {
		this.studdob = studdob;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studname=" + studname + ", studdob=" + studdob + ", courseid=" + courseid
				+ ", deptno=" + deptno + "]";
	} 
	
	
}
