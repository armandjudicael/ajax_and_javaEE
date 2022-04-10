package com.example.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class MyServletContext implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(MyServletContext.class.getName());

    @Override public void contextInitialized(ServletContextEvent sce) {
       LOGGER.log(Level.INFO," ============= i-JERRY APP STARTED ============= ");
    }

    @Override public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.log(Level.INFO," ============= i-JERRY APP DESTROYED ============= ");
    }
}
