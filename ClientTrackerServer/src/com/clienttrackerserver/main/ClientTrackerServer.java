package com.clienttrackerserver.main;

import java.net.*;
import java.io.*;

import java.sql.*;

/**
 * ClientTrackerServer serves as the launch point for the server application.
 * It establishes a connection to the database, and then await socket
 * connections. Each new connection results in a ClientTrackerServerThread
 * object being created.
 */
public class ClientTrackerServer {
    public static void main(String[] args) throws IOException {
      Connection conn;
      int portNumber = 8080;
      boolean listening = true;

      try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
        Class.forName("com.mysql.cj.jdbc.Driver");

        conn = DriverManager.
                getConnection("jdbc:mysql://clienttrackerdatabase.cmwupebesy8c.us-east-2.rds.amazonaws.com:3306/ClientTrackerServer", "tnelson006", "Regis1234567890StrongPassword");

        while (listening) {
          new ClientTrackerServerThread(serverSocket.accept(), conn).start();
        }
      } catch (IOException e) {
          System.err.println("Could not listen on port " + portNumber);
          System.exit(-1);
      } catch (SQLException e) {
        System.err.println("Database bologna 1: ");
        e.printStackTrace();
        System.exit(-1);
      } catch (ClassNotFoundException e) {
        System.err.println("Database bologna 2: ");
        e.printStackTrace();
        System.exit(-1);
      }
    }
}
