package be.abis.acca.exception;

public class PersonShouldNotBeRetiredException extends AgeException {
    public PersonShouldNotBeRetiredException(String message) {
        super(message);
    }
}
