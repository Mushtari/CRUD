package com.LTI.College_Proj.Model;



public class Course {

	protected int id;
	protected String preq;
	protected int dur;
	protected String name;
	protected int deptno;
	protected int instrid;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Course(int id, String preq, int dur, String name, int deptno, int instrid) {
		super();
		this.id = id;
		this.preq = preq;
		this.dur = dur;
		this.name = name;
		this.deptno = deptno;
		this.instrid = instrid;
	}
	
	
	
	public Course(String preq, int dur, String name, int deptno, int instrid) {
		super();
		this.preq = preq;
		this.dur = dur;
		this.name = name;
		this.deptno = deptno;
		this.instrid = instrid;
	}


	public String getPreq() {
		return preq;
	}
	public void setPreq(String preq) {
		this.preq = preq;
	}
	public int getDur() {
		return dur;
	}
	public void setDur(int dur) {
		this.dur = dur;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getInstrid() {
		return instrid;
	}
	public void setInstrid(int instrid) {
		this.instrid = instrid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", preq=" + preq + ", dur=" + dur + ", name=" + name + ", deptno=" + deptno
				+ ", instrid=" + instrid + "]";
	}
	
	
	
}