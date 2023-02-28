
public class SMessage {
    private String text;
    private String username;

    public SMessage(String username,String text){
        this.username = username;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String textForServer(){
        String messageToServer = "S#"  + username +"#" + text;
        return  messageToServer;
    }

}
