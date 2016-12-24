package se.nackademin.christopherolsson.adressbook.client;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class RemoteCatalogueFactory {
    private int defaultPort = 61616;

    public RemoteCatalogueFactory(int port) {
        this.defaultPort = port;
    }

    public RemoteCatalogueProxy create(String host) {

        return new AtomicRemoteCatalogueProxy(host, this.defaultPort);
    }
}
