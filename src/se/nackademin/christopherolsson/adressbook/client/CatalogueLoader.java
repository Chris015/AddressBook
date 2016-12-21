package se.nackademin.christopherolsson.adressbook.client;

import se.nackademin.christopherolsson.adressbook.registry.remote_registry.RemoteRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class CatalogueLoader {

    private RemoteRegistry remoteRegistry;
    private RemoteCatalogueFactory remoteCatalogueFactory = new RemoteCatalogueFactory(61616);

    private List<String> hosts = new ArrayList<>();

    public CatalogueLoader(RemoteRegistry remoteRegistry, String...hostsAddress) {
        this.remoteRegistry = remoteRegistry;
        addHost(hostsAddress);
    }

    private void addHost(String[] hostsAddress) {
        for (String address : hostsAddress) {
            hosts.add(address);
        }
    }

    public void run(){
        for (String host : hosts) {
            new Thread(() -> {
                List<String> remoteContacts = remoteCatalogueFactory.create(host).getContacts();
                for (int i = 0; i < remoteContacts.size(); i++) {
                    String[] contactInfo = remoteContacts.get(i).split(" ");
                    remoteRegistry.add(contactInfo[0], contactInfo[1], contactInfo[2], contactInfo[3]);
                }
            }).start();
        }

    }

}
