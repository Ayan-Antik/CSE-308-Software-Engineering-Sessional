package WebServerFactory;

import WebServer.*;

public class WebserverFactory {

    public WebServer getWebServer(String servertype){
        if(servertype == null)
            return null;

        if(servertype.equalsIgnoreCase("Django"))
            return new Django();
        else if(servertype.equalsIgnoreCase("Laravel"))
            return new Laravel();

        else if(servertype.equalsIgnoreCase("Spring"))
            return new Spring();

        return null;
    }
}
