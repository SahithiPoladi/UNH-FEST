package com.example;

import com.example.RegisterBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegisterDBO 
{
    public String authorizeRegister(RegisterBean registerBean) 
    {
        String firstname=registerBean.getFirstname();
        String lastname=registerBean.getLastname();
        String email=registerBean.getEmail();  
        String password=registerBean.getPassword();
        
        String url="jdbc:mysql://localhost:3306/fest"; 
        String uname="root"; 
        String pass="Dimpu2@"; 
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection con=DriverManager.getConnection(url,uname,pass); 
            
            PreparedStatement pstmt=null; 
            
            pstmt=con.prepareStatement("insert into registertable(firstname,lastname,email,password) values(?,?,?,?)"); 
            pstmt.setString(1,firstname);
            pstmt.setString(2,lastname);
            pstmt.setString(3,email);
            pstmt.setString(4,password); 
            pstmt.executeUpdate(); 
             
            pstmt.close(); 
            
            con.close(); 
           
            return "SUCCESS REGISTER"; 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            return "FAIL REGISTER"; 
    }
}
