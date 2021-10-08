package Task_2;

import java.net.UnknownHostException;

public class MyValidExeption extends UnknownHostException {
    private String strMessage;
    public MyValidExeption(String message) {
        super(message);
        this.strMessage = message;
    }

    @Override
    public String getMessage() {
        return this.strMessage;
    }
}
