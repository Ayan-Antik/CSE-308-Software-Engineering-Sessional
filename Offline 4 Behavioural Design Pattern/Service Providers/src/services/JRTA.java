package services;

import mediator.Mediator;

public class JRTA extends ServiceProvider {
    private int count;
    public JRTA(Mediator mediator){
        super(mediator);
        setName("JRTA");
        setServiceName("TRANSPORT");
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
