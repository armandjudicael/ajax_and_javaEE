package com.example.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class MySessionListenner implements HttpSessionListener {
    private static final Logger LOGGER = Logger.getLogger(MyServletContext.class.getName());
    private static int sessionCounter = 0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSessionListener.super.sessionCreated(se);
        synchronized (this){
            sessionCounter++;
        }
        LOGGER.log(Level.INFO," ============= SESSION CREATED {0} ============= ",sessionCounter);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSessionListener.super.sessionDestroyed(se);
        LOGGER.log(Level.INFO," ============= SESSION DESTROYED {0} ============= ",sessionCounter);
        synchronized (this){
            sessionCounter--;
        }
    }
}
