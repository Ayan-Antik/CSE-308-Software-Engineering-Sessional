package services;
import mediator.Mediator;
public class JPDC extends ServiceProvider {
    private int count;
    public JPDC(Mediator mediator){
        super(mediator);
        setName("JPDC");
        setServiceName("POWER");
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
