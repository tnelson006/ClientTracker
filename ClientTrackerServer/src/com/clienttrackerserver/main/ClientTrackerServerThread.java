
package com.clienttrackerserver.main;

import com.clienttrackerserver.socket.protocols.AddClientProtocol;
import com.clienttrackerserver.socket.protocols.DeleteClientProtocol;
import java.net.*;
import java.io.*;
import java.sql.Connection;

/**
 *
 * @author T-Nel
 */
public class ClientTrackerServerThread extends Thread {
    private Socket socket = null;
    private Connection conn = null;

    public ClientTrackerServerThread(Socket socket, Connection conn) {
        super("ClientTrackerServerThread");
        this.socket = socket;
        this.conn = conn;
    }

    public void run() {

        try (
          PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
          BufferedReader in = new BufferedReader(
              new InputStreamReader(
                  socket.getInputStream())); ) {

          int protocol;
          protocol = Integer.parseInt(in.readLine());
          System.out.println("Server protocol #: " + protocol);

          switch (protocol) {
            case 1:
              AddClientProtocol acp = new AddClientProtocol(out, in, conn);
              acp.executeProtocol();
              break;
            case 2:
              DeleteClientProtocol dcp = new DeleteClientProtocol(in, conn);
              dcp.executeProtocol();
              break;
            default:
              System.out.println(protocol + " is not a supported protocol number.");
              break;
          }

          socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}