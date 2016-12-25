package se.nackademin.christopherolsson.adressbook.client;

import java.io.IOException;
import java.util.List;

public interface RemoteCatalogueProxy {

    List<String> getContacts() throws IOException;

}
