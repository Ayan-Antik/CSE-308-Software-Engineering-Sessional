package services;

import mediator.Mediator;

public abstract class ServiceProvider {
    protected Mediator mediator;
    private String name;
    private String serviceName;


    public ServiceProvider(Mediator mediator){
        this.mediator = mediator;
    }

    public String getName(){
        return name;
    };

    public void setName(String name){
        this.name = name;
    };

    public String getServiceName(){
        return serviceName;
    };

    public void setServiceName(String serviceName){
        this.serviceName = serviceName;
    };

    public abstract void request();
    public abstract void serve();
}
