package kz.satbayev.contactbook.exception;

public class ContactNotFoundException extends RuntimeException{

    public ContactNotFoundException(String message) {
        super(message);
    }
}
