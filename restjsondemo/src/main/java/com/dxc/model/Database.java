package com.dxc.model;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Database {
	private static final String DBNAME="myDb";
	private static final String STUDENT_COLLECTION="student";

	private static MongoCollection<Document> collection; 
	
	public static void connect()
	{
		MongoClient mongo=new MongoClient("localhost",27017);
		MongoDatabase database=mongo.getDatabase(DBNAME);
		collection=database.getCollection(STUDENT_COLLECTION);
	}
		
	public static ArrayList retreiveAllStudents()
	{
		ArrayList al=new ArrayList();
		FindIterable<Document>fit=collection.find();
		Iterator<Document> it=fit.iterator();
		while(it.hasNext())
		{
		 Document stdDocument=(Document)it.next();	
		 Student stdObject=DocumentMapper.getStudent(stdDocument);
		 al.add(stdObject);
		}
		return al;
	}
	
	public static void addStudent(Document std)
	{
	  collection.insertOne(std);	
	}
}
