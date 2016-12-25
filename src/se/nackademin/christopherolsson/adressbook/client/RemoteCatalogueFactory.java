package se.nackademin.christopherolsson.adressbook.client;

public class RemoteCatalogueFactory {
    private int defaultPort = 61616;

    public RemoteCatalogueFactory(int port) {
        this.defaultPort = port;
    }

    public RemoteCatalogueProxy create(String host) {

        return new AtomicRemoteCatalogueProxy(host, this.defaultPort);
    }
}
