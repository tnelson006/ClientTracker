
package com.clienttrackerserver.main;

import com.clienttrackerserver.socket.protocols.AddClientProtocol;
import com.clienttrackerserver.socket.protocols.DeleteClientProtocol;
import java.net.*;
import java.io.*;

/**
 *
 * @author T-Nel
 */
public class ClientTrackerServerThread extends Thread {
    private Socket socket = null;

    public ClientTrackerServerThread(Socket socket) {
        super("ClientTrackerServerThread");
        this.socket = socket;
    }

    public void run() {

        try (
          PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
          BufferedReader in = new BufferedReader(
              new InputStreamReader(
                  socket.getInputStream())); ) {

          int protocol;
          protocol = Integer.parseInt(in.readLine());
          System.out.println(protocol);

          switch (protocol) {
            case 1:
              AddClientProtocol acp = new AddClientProtocol(out, in);
              acp.executeProtocol();
            case 2:
              DeleteClientProtocol dcp = new DeleteClientProtocol(in);
              dcp.executeProtocol();
            default:
              System.out.println(protocol + " is not a supported protocol number.");
          }

          socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}