package se.nackademin.christopherolsson.adressbook.client;

import se.nackademin.christopherolsson.adressbook.registry.remote_registry.RemoteRegistry;
import se.nackademin.christopherolsson.adressbook.user_interface.ConsolePrinter;

import java.io.IOException;
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
    private ConsolePrinter consolePrinter;

    public CatalogueLoader(ConsolePrinter consolePrinter, RemoteRegistry remoteRegistry, String... hostAddress) {
        this.consolePrinter = consolePrinter;
        this.remoteRegistry = remoteRegistry;
        addHost(hostAddress);
    }

    private void addHost(String[] hostAddress) {
        for (String address : hostAddress) {
            hosts.add(address);
        }
    }

    public void run() {
        for (String host : hosts) {
            new Thread(() -> {
                List<String> remoteContacts = null;
                try {
                    remoteContacts = remoteCatalogueFactory.create(host).getContacts();
                } catch (IOException e) {
                    consolePrinter.print("Couldn't connect to server with IP-address: " + host);
                }
                if (remoteContacts != null) {
                    for (String remoteContact : remoteContacts) {
                        String[] contactInfo = remoteContact.split(" ");
                        remoteRegistry.add(contactInfo[0], contactInfo[1], contactInfo[2], contactInfo[3]);
                    }
                }
            }).start();
        }

    }

}
