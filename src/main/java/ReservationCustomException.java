public abstract class ReservationCustomException extends RuntimeException {

    public ReservationCustomException() {
    }

    public ReservationCustomException(String message) {
        super(message);
    }

    abstract int getCode();
}
