package com.dxc.restjsondemo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dxc.model.Student;
import com.dxc.services.StudentService;

import javassist.bytecode.MethodParametersAttribute;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
    	
    	return Response.ok(StudentService.getAllStudents())
    	        .header("Access-Control-Allow-Origin", "*")
    	        // whatever other CORS headers
    	        .build();
    	
    }
    
    @DELETE
    @Path("delete/{rollno}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("rollno") String rollno)
    {
        if(StudentService.delete(rollno))
        {
         	return "{\"status\":\"0\",\"message\":\"successfuly deleted\"}";
        }
        else
        {
        return "{\"status\":\"1\",\"message\":\"Not found\"}";        	
        }
    }
    
    
    
    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Student input)
    {
    //	Response.ok().build();
    	System.out.println("input student"+input);
    	StudentService.add(input);
    	return Response.ok("{\"status\":\"0\",\"message\":\"successfuly added\"}").build();

    }    
    @GET
    @Path("get/{rollno}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudentBy(@PathParam("rollno") String rollno)
    {
    	Student s=StudentService.getStudenByRollno(rollno);
        return s;
    	
    }
    
    @PUT
    @Path("update/{rollno}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("rollno") String rollno,Student input)
    {
    	Student updated=StudentService.update(rollno,input);
    	
    	System.out.println("Student "+updated);
    	Response response=null;
    	if(updated==null) {
    		response=Response.noContent().header("Access-Control-Allow-Origin", "*")
        	        // whatever other CORS headers
        	        .build();
    	}
    	else {
        	response=Response.ok(updated)
        	        .header("Access-Control-Allow-Origin", "*")
        	        // whatever other CORS headers
        	        .build();
    	}
	
    	return response;
    }
    
}
