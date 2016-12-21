package se.nackademin.christopherolsson.adressbook.client;

import se.nackademin.christopherolsson.adressbook.registry.remote_registry.RemoteRegistry;

import java.util.List;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class CatalogueLoader {

<<<<<<< HEAD
    private RemoteRegistry remoteRegistry;
    private RemoteCatalogueFactorty remoteCatalogueFactorty;
=======
    RemoteRegistry remoteRegistry;
    RemoteCatalogueFactorty remoteCatalogueFactorty = new RemoteCatalogueFactorty(61616);
>>>>>>> 77397acbfd5d178e9ee9a3b7b4f55a7380579ce3

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
