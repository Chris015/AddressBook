package se.nackademin.christopherolsson.adressbook.client;

import java.util.ArrayList;
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

    public List<String> getContacts(){
        List<String> remoteContacts;
        catalogueClient.connect();
        catalogueClient.sendRequest("getall");
        remoteContacts = Arrays.asList(catalogueClient.waitForResponse().split("-"));
        catalogueClient.diconnect();
        return remoteContacts;
    }
}
