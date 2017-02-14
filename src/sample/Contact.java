package sample;

/**
 * Created by BHarris on 2/14/17.
 */
public class Contact {
    String name;
    String phoneNumber;
    String email;


    public Contact(String name, String phoneNumber, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", this.name, this.phoneNumber, this.email);
    }
}
