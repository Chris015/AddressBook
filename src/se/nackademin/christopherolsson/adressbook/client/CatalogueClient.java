package se.nackademin.christopherolsson.adressbook.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class CatalogueClient {

    private String host;
    private int port;
    private Socket clientSocket;
    private PrintWriter writer;
    private BufferedReader reader;

    public CatalogueClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public synchronized void connect() {
        try {
            this.clientSocket = new Socket(host, port);
            writer = new PrintWriter(clientSocket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendRequest(String request) {
        writer.write(request);
    }

    public String waitForResponse(){
        String response = null;
        try {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (line.equals("")) {
                    break;
                }
                response += line + "-";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public void diconnect() {
        try {
            sendRequest("exit");
            this.clientSocket.close();
            this.reader.close();
            this.writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
