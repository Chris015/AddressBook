package se.nackademin.christopherolsson.adressbook.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AtomicRemoteCatalogueProxy implements RemoteCatalogueProxy {


    private CatalogueClient catalogueClient;


    public AtomicRemoteCatalogueProxy(String host, int port) {
        catalogueClient = new CatalogueClient(host, port);
    }

    public List<String> getContacts() throws IOException {
        List<String> remoteContacts;
        catalogueClient.connect();
        if (catalogueClient.isConnected()) {
            catalogueClient.sendRequest("getall");
            remoteContacts = Arrays.asList(catalogueClient.waitForResponse().split("/"));
            catalogueClient.disconnect();
            return remoteContacts;
        }
        return null;
    }
}
