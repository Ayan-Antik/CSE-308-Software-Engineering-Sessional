package TeaGASDirector;

import Hardware.Hardware;
import HardwareBuilder.HardwareBuilder;
import WebServer.WebServer;
import WebServerFactory.WebserverFactory;

public class TeaGASDirector {
    public void constructSystem(String pack,String net, String web){
        HardwareBuilder hardwareBuilder = new HardwareBuilder();
        WebserverFactory webserverFactory = new WebserverFactory();

        Hardware hardware = null;
        if (pack.equalsIgnoreCase("silver"))
            hardware = hardwareBuilder.buildSilverPackage(net);
        else if(pack.equalsIgnoreCase("gold"))
            hardware = hardwareBuilder.buildGoldPackage(net);
        else if(pack.equalsIgnoreCase("diamond"))
            hardware = hardwareBuilder.buildDiamondPackage(net);
        else if(pack.equalsIgnoreCase("platinum"))
            hardware = hardwareBuilder.buildPlatinumPackage(net);


        WebServer webServer = webserverFactory.getWebServer(web);

        if(hardware == null){
            System.out.println("Hardware Device could not be built");
            return;
        }
        hardware.showComponents();
        System.out.println("Web FrameWork: " + webServer.ServerType());

    }
}
