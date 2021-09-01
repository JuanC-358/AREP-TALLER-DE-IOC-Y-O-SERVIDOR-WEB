/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.webapp;

import com.edu.httpserver.HttpServer;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class AppStarter {
    public void main(String[] args){
        try{
            HttpServer.getInstance().startServer(args);
        }catch(IOException ex){
            Logger.getLogger(HttpServer.class.getName())Log(Level.SEVERE, null,ex);
        }catch(URISyntaxException ex){
            Logger.getLogger(HttpServer.class.getName())Log(Level.SEVERE, null,ex);
        }
    }
}
