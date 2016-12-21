package se.nackademin.christopherolsson.adressbook.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

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
        } catch (UnknownHostException h){
            System.out.println("Host with name: " + host + " on port: " + port + " could not be reached.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendRequest(String request) {
        writer.println(request);
        writer.flush();
    }

    public String waitForResponse(){
        String response = "";
        try {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                if (line.equals("")) {
                    break;
                } else {
                    response += line + "/";
                    System.out.println(response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public void disconnect() {
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
