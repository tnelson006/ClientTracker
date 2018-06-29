/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clienttrackerserver.main;

/**
 *
 * @author T-Nel
 */
import java.net.*;
import java.io.*;

public class ClientTrackerServer {
    public static void main(String[] args) throws IOException {

        int portNumber = 8080;
        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
	            new ClientTrackerServerThread(serverSocket.accept()).start();
	        }
	    } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}
