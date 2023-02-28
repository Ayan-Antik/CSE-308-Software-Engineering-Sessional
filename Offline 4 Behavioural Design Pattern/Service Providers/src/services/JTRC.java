package services;

import mediator.Mediator;

public class JTRC extends ServiceProvider {
    private int count;
    public JTRC(Mediator mediator){
        super(mediator);
        setName("JTRC");
        setServiceName("TELECOM");
        count = 0;
    }
    @Override
    public void request() {
        count++;
    }

    @Override
    public void serve() {
        if(count > 0){
            count--;
            mediator.Serve(this);
        }

        else {
            System.out.println("Services Not required");
        }
    }
}
