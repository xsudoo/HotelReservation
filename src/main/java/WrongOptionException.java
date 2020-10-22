public class WrongOptionException extends ReservationCustomException {

    private int code = 101;


    public WrongOptionException() {
        super();
    }

    public WrongOptionException(String message) {
        super(message);
    }

    public int getCode() {
        return code;
    }
}
