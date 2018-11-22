package DBNewVersion;

import newversion.TransactionNewVersion;

import java.io.IOException;
import java.util.ArrayList;

public interface Connector {
    ArrayList<TransactionNewVersion> getTransaction() throws IOException;


}
