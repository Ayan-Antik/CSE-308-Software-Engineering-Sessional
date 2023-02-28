public class CMessage {

    private String text;
    private String myUserName;
    private String receivername;

    public CMessage(String myUserName, String receivername,String text) {
        this.text = text;
        this.myUserName = myUserName;
        this.receivername = receivername;
    }

    public String textForServer() {
        String messageToServer = "C#"  + myUserName +"#" +receivername + "#"+ text;
        return  messageToServer;
    }
}
