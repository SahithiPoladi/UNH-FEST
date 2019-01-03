package com.example;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.RegisterBean;
import com.example.RegisterDBO;

public class RegisterController extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        if(request.getParameter("btn_register")!=null) 
        {
            String firstname=request.getParameter("txt_firstname");
            String lastname=request.getParameter("txt_lastname");
            String email=request.getParameter("txt_email"); 
            String password=request.getParameter("txt_password");
            
            RegisterBean registerBean=new RegisterBean(); 
            
            registerBean.setFirstname(firstname);
            registerBean.setLastname(lastname);
            registerBean.setEmail(email);  
            registerBean.setPassword(password);
            
            RegisterDBO registerdao=new RegisterDBO(); 
            String registerValidate=registerdao.authorizeRegister(registerBean); 
            if(registerValidate.equals("SUCCESS REGISTER")) 
            {
                request.setAttribute("RegiseterSuccessMsg",registerValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("login.jsp"); 
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("RegisterErrorMsg",registerValidate); 
                RequestDispatcher rd=request.getRequestDispatcher("register.jsp"); 
                rd.include(request, response);
            }
        }
    }

}