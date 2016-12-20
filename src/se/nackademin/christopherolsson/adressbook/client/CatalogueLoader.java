package se.nackademin.christopherolsson.adressbook.client;

import se.nackademin.christopherolsson.adressbook.registry.remote_registry.RemoteRegistry;

import java.util.List;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class CatalogueLoader {

    private RemoteRegistry remoteRegistry;
    private RemoteCatalogueFactorty remoteCatalogueFactorty;

    public void run(){
        new Thread(() -> {
            while (true) {
                List<String> remoteContacts = remoteCatalogueFactorty.create("localhost").getContacts();
                for (int i = 0; i < remoteContacts.size(); i++) {
                    String[] contactInfo = remoteContacts.get(i).split(",");
                    remoteRegistry.add(contactInfo[0], contactInfo[1], contactInfo[2], contactInfo[3]);
                }
            }
        }).start();



    }

}
