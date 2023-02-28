public class BMessage {

    private String text;
    private String username;

    public BMessage(String username,String text){
        this.username = username;
        this.text = text;
    }

    public String textForServer() {
        String messageToServer = "B#"  + username +"#" + text;
        return  messageToServer;
    }
}
