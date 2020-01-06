package com.deloitte.ecommerce;
import com.deloitte.ecommerce.*;
import com.deloitte.ecommerce.entity.Customer;
import com.deloitte.ecommerce.service.IService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/second")

public class detailsprint extends HttpServlet {

    private IService service=new ServiceImpl(new DaoImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        String signedOutVal = req.getParameter("signout");
        boolean sessionDestroyed = false;
        if (signedOutVal != null && signedOutVal.equals("true")) {
            session.invalidate();
            sessionDestroyed = true;
        }
        Object mobilenoObj=null;
        if (!sessionDestroyed) {
            mobilenoObj = session.getAttribute("mobileno");
        }

        if (mobilenoObj == null || mobilenoObj.toString().isEmpty()) {
            resp.getWriter().println("you are not signed in yet");
            String signInLink = "<a href='/html/form.html'>Sign In </a> ";
            writer.println(signInLink);
            return;
        }
        String mobileno=mobilenoObj.toString();
        Customer user=service.findById(mobileno);
        double balance=user.getBalance();
        writer.println("Balance is " + balance );
        String name=user.getName();
        writer.println("Name " + name );
        String signoutLink = "<a href='/second?signout=true'>Sign out </a> ";
        writer.println(signoutLink);

    }


}


        
      