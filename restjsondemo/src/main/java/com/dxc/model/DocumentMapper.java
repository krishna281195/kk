package com.dxc.model;
import org.bson.Document;

public class DocumentMapper {

	public static Student getStudent(Document d)
	{
		Student std=new Student();
		std.setName(d.getString("name"));
		std.setRollno(d.getString("rollno"));
		std.setMarks(d.getDouble("marks"));
		std.setDept(d.getString("dept"));
		return std;		
	}
	
	public static Document getDocument(Student std)
	{
		Document doc=new Document().append("name",std.getName())
				.append("rollno", std.getRollno())
				.append("marks", std.getMarks())
				.append("dept", std.getDept());
		return doc;

	}
}
