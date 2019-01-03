package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class Operations {
	Connection con=null;
	boolean test=false;
	Fest f;
	public Operations() {
		test=connection();
	}
	
	public boolean connection() {
		try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection
               ("jdbc:mysql://localhost:3306/fest?useSSL=false",
                        "root", "Dimpu2@");
 
        } catch (Exception e2) {
            System.out.println(e2);
            return false;
        }
		
		return true;
	}
	
	public boolean insertion(Fest f) {
	   try {
	     if (test) {
            String exp="insert into eventtable (studentid,eventname) values(?,?)";
 	         PreparedStatement ps = con.prepareStatement(exp);
	         ps.setInt(1, f.getSid());
	         ps.setString(2, f.getEvent());
	         
	         int i = ps.executeUpdate();
	         if (i > 0)   
	               return true;
	         else   	return false;
            }
            return false;
         } catch (Exception e2) {
                return false;
        }
	}
	public boolean update(Fest f) {
        try {
          if (test) {
            String exp=
             "UPDATE eventtable SET eventname = ? WHERE studentid = ?";
              PreparedStatement ps = con.prepareStatement(exp);
              ps.setString(1, f.getEvent());
              ps.setInt(2, f.getSid());
              int i = ps.executeUpdate();
	         if (i > 0)   
	           return true;
	         else
	          	return false;
            }
            return false;
         } catch (Exception e2) {
        	System.out.println(e2.getMessage());
                return false;
       }
	}
	public boolean delete(Fest f) {
        try {
	     if (test) {
              String exp="DELETE FROM eventtable WHERE studentid = ?";
              PreparedStatement ps = con.prepareStatement(exp);
              ps.setInt(1, f.getSid());
              int i = ps.executeUpdate();
	         if (i > 0)   
	           return true;
	         else
	         	return false;
           }
              return false;
         } catch (Exception e2) {
        	System.out.println(e2.getMessage());
                return false;
       }
     }
	public Fest find(int sid) {
        Statement stmt = null;
        try {
	     if (test) {
              f= new Fest();
              stmt = (Statement) con.createStatement();
              String exp="select studentid,eventname from eventtable WHERE studentid ="+sid;
              ResultSet rs = stmt.executeQuery(exp);
              while (rs.next()) {
            	 f.setSid(rs.getInt("studentid"));
            	 f.setEvent(rs.getString("eventname"));
           
              }
              return f;
            }
            return null;
        } catch (Exception e2) {
        	System.out.println(e2.getMessage());
           return null;
       }
	}
}
