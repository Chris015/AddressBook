package se.nackademin.christopherolsson.adressbook.client;

import se.nackademin.christopherolsson.adressbook.registry.remote_registry.RemoteRegistry;

/**
 * Created by Robin Gk on 2016-12-20 as a school project.
 * email kallrobin92@gmail.com
 */
public class CatalogueLoader {

    RemoteRegistry remoteRegistry;
    RemoteCatalogueFactorty remoteCatalogueFactorty;

    public void run(){
        new Thread(() -> {
            while (true) {
                remoteCatalogueFactorty.create("localhost");
            }
        }).start();



    }

}
