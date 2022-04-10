package com.example.controller;

import dao.ConnectionFactory;
import dao.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "login",value="/login",loadOnStartup = 1)
public class LoginServlet extends HttpServlet{
    private static UserDao userDao;
    public LoginServlet() {
        super();
        LOGGER.log(Level.INFO,"======= SERVLET CREATED =========== ");
    }

    private static  final Logger LOGGER = java.util.logging.Logger.getLogger(LoginServlet.class.getName());
    @Override protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        LOGGER.log(Level.INFO,"======= WE ARE IN THE SERVICE METHOD =========== ");
    }

    @Override public void destroy() {
        super.destroy();
        LOGGER.log(Level.INFO,"======= WE ARE IN THE DESTROY METHOD =========== ");
    }

    @Override public String getInitParameter(String name) {
        return super.getInitParameter(name);
    }

    @Override public void init() throws ServletException {
        super.init();
        if (userDao==null) userDao = new UserDao(ConnectionFactory.getConnection(this.getServletContext()));
        LOGGER.log(Level.INFO,"======= WE ARE IN THE INIT METHOD =========== ");
        System.out.println(this.getServletContext().getInitParameter("DATABASE_URL"));
    }

    @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.log(Level.INFO,"======= WE ARE IN THE DO GET METHOD =========== ");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (email==null) email = "";
        if (password==null) password = "";
        HttpSession session = req.getSession(true);
        session.setAttribute("email",email);
        session.setAttribute("password",password);
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.log(Level.INFO,"======= WE ARE IN THE DO POST METHOD =========== ");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        if (session!=null){
            User validateUser = userDao.isValidate(email,password);
            if (validateUser !=null){
                LOGGER.log(Level.INFO,"======= CONNECTED =========== ");
                req.setAttribute("connectedUser",validateUser);
                session.setAttribute("connected",true);
                req.getRequestDispatcher("/MainApp.jsp").forward(req,resp);
            }else {
                session.setAttribute("connected",false);
                req.setAttribute("email",email);
                req.setAttribute("password",password);
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
                LOGGER.log(Level.INFO,"=======  NOT CONNECTED =========== ");
            }
        }
    }
}
