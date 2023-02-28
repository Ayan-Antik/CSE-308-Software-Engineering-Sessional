package mediator;

import services.*;

import java.util.LinkedList;
import java.util.Queue;

public class JCC extends Mediator {
    private JWSA jwsa;
    private JPDC jpdc;
    private JRTA jrta;
    private JTRC jtrc;

    Queue<String> WaterService = new LinkedList<>();

    Queue<String> PowerService = new LinkedList<>();
    Queue<String> TransportService = new LinkedList<>();
    Queue<String> TelecomService = new LinkedList<>();

    public void setJwsa(JWSA jwsa){
        this.jwsa = jwsa;
    }

    public void setJpdc(JPDC jpdc) {
        this.jpdc = jpdc;
    }

    public void setJrta(JRTA jrta) {
        this.jrta = jrta;
    }

    public void setJtrc(JTRC jtrc) {
        this.jtrc = jtrc;
    }

    public void requestService(String name, String type){
        if(type.equalsIgnoreCase("water")){
            jwsa.request();
            WaterService.add(name);
        }
        else if(type.equalsIgnoreCase("power")){
            jpdc.request();
            PowerService.add(name);
        }
        else if(type.equalsIgnoreCase("transport")){
            jrta.request();
            TransportService.add(name);
        }
        else if(type.equalsIgnoreCase("telecom")){
            jtrc.request();
            TelecomService.add(name);
        }

        System.out.println(name + " requests for " + type + " service");

    }

    @Override
    public void Serve(ServiceProvider serviceProvider) {
        System.out.print(serviceProvider.getName().toUpperCase() + " serves the request of ");
        if(serviceProvider.getServiceName().equalsIgnoreCase("water")){
            System.out.println(WaterService.element().toUpperCase());
            WaterService.remove();
        }
        else if(serviceProvider.getServiceName().equalsIgnoreCase("power")){
            System.out.println(PowerService.element().toUpperCase());
            PowerService.remove();
        }
        else if(serviceProvider.getServiceName().equalsIgnoreCase("transport")){
            System.out.println(TransportService.element().toUpperCase());
            TransportService.remove();
        }
        else if(serviceProvider.getServiceName().equalsIgnoreCase("telecom")){
            System.out.println(TelecomService.element().toUpperCase());
            TelecomService.remove();
        }


    }
}
