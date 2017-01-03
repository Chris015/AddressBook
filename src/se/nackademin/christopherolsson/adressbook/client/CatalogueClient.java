package se.nackademin.christopherolsson.adressbook.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogueClient {
    private final static Logger log = Logger.getLogger(CatalogueClient.class.getName());
    private String host;
    private int port;
    private Socket clientSocket;
    private PrintWriter writer;
    private BufferedReader reader;

    public CatalogueClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() throws IOException {
        log.info("Connecting to server: " + host + " on port " + port + "...");
        this.clientSocket = new Socket(host, port);
        writer = new PrintWriter(clientSocket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        log.info("Connection established to server: " + host + " on port " + port);
    }

    public void sendRequest(String request) {
        writer.println(request);
        log.info("Request " + request + " sent to server.");
        writer.flush();
    }

    public String waitForResponse() throws IOException {
        String response = "";
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            if (line.equals("")) {
                break;
            } else {
                response += line + "/";
            }
        }

        return response;
    }

    public void disconnect() {
        try {
            sendRequest("exit");
            closeResources();
            log.info("Connection closed.");
        } catch (IOException e) {
            log.log(Level.SEVERE, "Something wrong occurred", e);
        }
    }

    private void closeResources() throws IOException {
        this.clientSocket.close();
        this.reader.close();
        this.writer.close();
    }


    public boolean isConnected() {
        return clientSocket != null && clientSocket.isConnected();
    }
}
