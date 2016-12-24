package se.nackademin.christopherolsson.adressbook.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
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
