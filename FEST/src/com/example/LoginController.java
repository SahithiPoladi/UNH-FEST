package com.example;

import com.example.LoginBean;
import com.example.LoginDBO;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getParameter("btn_login")!=null) 
        {
            String email=request.getParameter("txt_email"); 
            String password=request.getParameter("txt_password"); 
            
            LoginBean loginBean=new LoginBean(); 
            loginBean.setEmail(email); 
            loginBean.setPassword(password); 
            
            LoginDBO loginDao=new LoginDBO(); 
            
            String authorize=loginDao.authorizeLogin(loginBean); 
            
            if(authorize.equals("SUCCESS LOGIN")) 
            {
                HttpSession session=request.getSession(); 
                session.setAttribute("login",loginBean.getEmail()); 
                RequestDispatcher rd=request.getRequestDispatcher("events.jsp"); 
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("WrongLoginMsg",authorize); 
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp"); 
                rd.include(request, response);
            }
        }
    }

}
