package com.example;

import com.example.LoginBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDBO 
{
    public String authorizeLogin(LoginBean loginBean) //create authorizeLogin()function
    {
        String email=loginBean.getEmail(); 
        String password=loginBean.getPassword(); 
        
        String dbemail="";  
        String dbpassword="";
        
        String url="jdbc:mysql://localhost:3306/fest"; //database connection url string
        String uname="root"; //database username
        String pass="Dimpu2@"; //database password
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //load driver
            Connection con=DriverManager.getConnection(url,uname,pass); //create connection
            
            PreparedStatement pstmt=null; //create statement
            
            pstmt=con.prepareStatement("select * from registertable where email=? and password=?"); //sql select query 
            pstmt.setString(1,email);
            pstmt.setString(2,password);
            ResultSet rs=pstmt.executeQuery(); //execute query and set in Resultset object rs.
             
            while(rs.next())
            {    
                dbemail=rs.getString("email");   
                dbpassword=rs.getString("password"); 
                
                if(email.equals(dbemail) && password.equals(dbpassword)) 
                {
                    return "SUCCESS LOGIN"; //if valid condition return string "SUCCESS LOGIN" 
                }
            } 
           
            pstmt.close(); //close statement
            
            con.close(); //close connection
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return "WRONG USERNAME AND PASSWORD"; //if invalid condition return string "WRONG USERNAME AND PASSWORD"
    }
}
