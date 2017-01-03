package se.nackademin.christopherolsson.adressbook.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


public class AtomicRemoteCatalogueProxy implements RemoteCatalogueProxy {
    private final static Logger log = Logger.getLogger(AtomicRemoteCatalogueProxy.class.getName());

    private CatalogueClient catalogueClient;


    public AtomicRemoteCatalogueProxy(String host, int port) {
        catalogueClient = new CatalogueClient(host, port);
    }

    public List<String> getContacts() throws IOException {
        List<String> remoteContacts;
        catalogueClient.connect();
        if (catalogueClient.isConnected()) {
            log.info("Fetching contacts...");
            catalogueClient.sendRequest("getall");
            remoteContacts = Arrays.asList(catalogueClient.waitForResponse().split("/"));
            log.info("Contacts has been fetched.");
            catalogueClient.disconnect();
            return remoteContacts;
        }
        return null;
    }
}
