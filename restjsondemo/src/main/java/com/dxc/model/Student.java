package com.dxc.model;


public class Student{
	
	String name;
	String rollno;
	double marks;
	String dept; 

	public Student()
	{
		
	}
	
	public Student(String name,String rollno, double marks,String dept)
	{
		this.name=name;
		this.rollno=rollno;
		this.marks=marks;
		this.dept=dept;
	}
	


	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	public String getRollno() {
		return rollno;
	}
	

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public double getMarks() {
		return marks;
	}
	
	
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String getDept() {
		return dept;
	}
	
	
	public void setDept(String dept) {
		this.dept = dept;
	}
}
