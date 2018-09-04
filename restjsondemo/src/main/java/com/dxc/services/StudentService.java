package com.dxc.services;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.dxc.model.Database;
import com.dxc.model.DocumentMapper;
import com.dxc.model.Student;

public class StudentService {

	private static ArrayList<Student> students=new ArrayList<Student>();
	
	static{
//		// TODO Auto-generated constructor stub
//		students.add(new Student("ramesh","cs1",99.3,"cs"));
//		students.add(new Student("john","it2",95.3,"it"));
//		students.add(new Student("paul","cs3",19.3,"cs"));	
		Database.connect();
	}
	 
	public static Student replace(Student old,Student newStd)
	{
		int index=getIndexOf(old);
		if(index!=-1)
		{
			students.set(index,newStd);
			return newStd;
		}
		else {
		 	return null;
		}		
	}
	
	private static int getIndexOf(Student std)
	{
		int index=-1;
		int total=students.size();
		for(int i=0;i<total;i++)
		{
			Student current=(Student)students.get(i);
			if(current.getRollno().equals(std.getRollno()))
				{
				 index=i;
				 break;
				}
		}
		return index;
	}
	
	public static Student update(String rollno,Student newStd)
	{
		Student old=getStudenByRollno(rollno);
		newStd.setRollno(rollno);
		newStd=replace(old,newStd);
		return newStd;
	}
	
//	public static ArrayList<Student> getAllStudents()
//	{
//		return students;
//	}

   public static ArrayList getAllStudents()
	{
	 ArrayList al=Database.retreiveAllStudents();
	 return al;
	}
	
	public static void add(Student std)
	{
	    Document stdDoc=DocumentMapper.getDocument(std);
	    Database.addStudent(stdDoc);	    
	}
	
	public static boolean delete(String rollno)
	{
		Student to_delete=getStudenByRollno(rollno);
		boolean success=students.remove(to_delete);		
		return success;
	}
	
	public static Student getStudenByRollno(String rollno)
	{
		Student found=null;
		int size=students.size();
		for(int i=0;i<size;i++)
		{
			
			if(students.get(i).getRollno().equals(rollno))
			{
				found=students.get(i);
				break;
			}
		}
		return found;
	}
}
