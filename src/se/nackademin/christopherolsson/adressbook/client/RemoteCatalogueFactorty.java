package se.nackademin.christopherolsson.adressbook.client;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class RemoteCatalogueFactorty {
    private int defaultPort = 61616;

    public RemoteCatalogueFactorty(int port) {
        this.defaultPort = port;
    }

    public RemoteCatalogueProxy create(String host){

        RemoteCatalogueProxy catalogueProxy = new AtomicRemoteCatalogueProxy(host, this.defaultPort);

        return catalogueProxy;
    }
}
