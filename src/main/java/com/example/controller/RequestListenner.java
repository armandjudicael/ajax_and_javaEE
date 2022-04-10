package com.example.controller;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebListener
public class RequestListenner implements ServletRequestListener {

    private static final Logger LOGGER = Logger.getLogger(MyServletContext.class.getName());
    private static int sessionCounter = 0;

    @Override public void requestDestroyed(ServletRequestEvent sre) {
        synchronized (this){
            sessionCounter++;
        }
        LOGGER.log(Level.INFO," ============= REQUEST DESTROYED {0} ============= ",sessionCounter);
    }

    @Override public void requestInitialized(ServletRequestEvent sre) {
        LOGGER.log(Level.INFO," ============= REQUEST INITIALIZED {0} ============= ",sessionCounter);
        synchronized (this){
            sessionCounter--;
        }
    }
}
