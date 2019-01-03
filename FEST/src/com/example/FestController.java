package com.example;

import java.io.IOException;

import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FestController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	Fest aFest=null;
	RequestDispatcher rd;
	Operations dbo;
	String result=null;
     public FestController() {
        super();
        aFest=new Fest();
        dbo= new Operations();
    }
	
	protected void doGet(HttpServletRequest request, 
         HttpServletResponse response) 
             throws ServletException, IOException {
   		  doPost(request, response);
				
	}
	
	protected void doPost(
          HttpServletRequest request, HttpServletResponse response) 
             throws ServletException, IOException {
	   PrintWriter out = response.getWriter();
				
	   int sid=0;
	   String event=null;
	   String mode=null, res=null;
	   String action = request.getParameter("action");

	   if ("insert".equals(action)) {
		sid=Integer.parseInt(request.getParameter("sid"));
		event=request.getParameter("event");
		
		aFest.setSid(sid);
		aFest.setEvent(event);
		
		if(dbo.insertion(aFest)) {
		  request.setAttribute("operation", "insertion");
		  rd = request.getRequestDispatcher("/display.jsp");
		}else {
		  rd = request.getRequestDispatcher("/error.jsp");
		}
	   }else if("update".equals(action)) {
		   sid=Integer.parseInt(request.getParameter("sid"));
		   event=request.getParameter("event");
			
			aFest.setSid(sid);
			aFest.setEvent(event);
			
		if(dbo.update(aFest)) {
		  request.setAttribute("operation", "updation");
		  rd = request.getRequestDispatcher("/display.jsp");
		}else {
		  rd = request.getRequestDispatcher("/error.jsp");
		}
	   }else if("delete".equals(action)) {
		   sid=Integer.parseInt(request.getParameter("sid"));
		   event=request.getParameter("event");
			
			aFest.setSid(sid);
		if(dbo.delete(aFest)) {
		  request.setAttribute("operation", "deletion");
		  rd = request.getRequestDispatcher("/display.jsp");
		}
		else {
		  rd = request.getRequestDispatcher("/error.jsp");
		}
	   }else if("find".equals(action)) {
		 sid=Integer.parseInt(request.getParameter("sid"));
		 if((aFest=dbo.find(sid))!=null) {
		    request.setAttribute
                    ("sid",String.valueOf(aFest.getSid()));
		    request.setAttribute("event", aFest.getEvent());
		  
			 rd = request.getRequestDispatcher("/events.jsp");
	       }else {
			 rd = request.getRequestDispatcher("/error.jsp");
		  }
	   }
	    rd.forward(request, response);
	}
}
