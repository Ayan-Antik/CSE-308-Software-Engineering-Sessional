package services;

import mediator.Mediator;

public class JWSA extends ServiceProvider {
    private int count;
    public JWSA(Mediator mediator){
        super(mediator);
        setName("JWSA");
        setServiceName("WATER");
        count = 0;
    }
    @Override
    public void request() {
        count++;
    }

    @Override
    public void serve() {
        if(count > 0) {
            count--;
            mediator.Serve(this);
        }
        else {
            System.out.println("Services Not required");
        }
    }
}
