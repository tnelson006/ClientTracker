
package com.clienttrackerserver.main;

import com.clienttrackerserver.socket.protocols.AddClientProtocol;
import com.clienttrackerserver.socket.protocols.AddNoteProtocol;
import com.clienttrackerserver.socket.protocols.DeleteClientProtocol;
import com.clienttrackerserver.socket.protocols.DeleteNoteProtocol;
import com.clienttrackerserver.socket.protocols.EditNoteProtocol;
import com.clienttrackerserver.socket.protocols.InitializeClientTrackerProtocol;
import com.clienttrackerserver.socket.protocols.NewUserProtocol;
import com.clienttrackerserver.socket.protocols.SignInProtocol;
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
            case 0:
              InitializeClientTrackerProtocol ictp = new InitializeClientTrackerProtocol(out, in, conn);
              ictp.executeProtocol();
              break;
            case 1:
              AddClientProtocol acp = new AddClientProtocol(out, in, conn);
              acp.executeProtocol();
              break;
            case 2:
              DeleteClientProtocol dcp = new DeleteClientProtocol(in, conn);
              dcp.executeProtocol();
              break;
            case 3:
              AddNoteProtocol anp = new AddNoteProtocol(out, in, conn);
              anp.executeProtocol();
              break;
            case 4:
              EditNoteProtocol enp = new EditNoteProtocol(in, conn);
              enp.executeProtocol();
              break;
            case 5:
              DeleteNoteProtocol dnp = new DeleteNoteProtocol(in, conn);
              dnp.executeProtocol();
              break;
            case 6:
              SignInProtocol sip = new SignInProtocol(out, in, conn);
              sip.executeProtocol();
              break;
            case 7:
              NewUserProtocol nup = new NewUserProtocol(out, in, conn);
              nup.executeProtocol();
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