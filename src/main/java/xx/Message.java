package xx;

/**
 * Created by luokai on 2017/6/19.
 * Version 1.0
 */
public class Message {
//    public static final String HELLO = "Hello";
//    public static final String GOODBYE = "bye";

    public static final int HELLO = 0;
    public static final int GOODBYE = 1;

    private String message;
    private int status;

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int  status) {
        this.status = status;
    }
}
