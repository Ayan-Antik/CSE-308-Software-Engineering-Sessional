
public class LMessage {

    private String User;
    private String Pass;
    private String type;

    public void setUser(String user) {
        User = user;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String textForServer(){
        String messageToServer = "L#" + User + "#" + Pass + "#" + type;
        return  messageToServer;
    }

    public String getUser() {
        return User;
    }

    public String getType() {
        return type;
    }
}