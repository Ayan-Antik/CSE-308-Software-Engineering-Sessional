package Hardware.InternetFactory;

import Hardware.InternetConnection.Ethernet;
import Hardware.InternetConnection.GSMModule;
import Hardware.InternetConnection.Internet;
import Hardware.InternetConnection.WiFiModule;

public class InternetFactory {

    public Internet getInternet(String internetType){
        if (internetType== null)
            return null;
        if(internetType.equalsIgnoreCase("Ethernet"))
                return new Ethernet();

        else if(internetType.equalsIgnoreCase("SIMcard") || internetType.equalsIgnoreCase("sim card"))
            return new GSMModule();
        else if(internetType.equalsIgnoreCase("Wifi"))
            return new WiFiModule();
        return null;
    }
}
