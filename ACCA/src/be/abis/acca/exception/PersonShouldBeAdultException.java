package be.abis.acca.exception;

public class PersonShouldBeAdultException extends AgeException {
    public PersonShouldBeAdultException(String message) {
        super(message);
    }
}
