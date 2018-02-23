package zdy;

import javax.annotation.Resource;

/**
 * @author zdy
 */

public class MyException extends Exception {

    private int code;

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}
