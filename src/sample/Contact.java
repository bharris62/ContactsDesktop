package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.LoadException;
import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by BHarris on 2/14/17.
 */
public class Contact {
    String name;
    String phoneNumber;
    String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact(String name, String phoneNumber, String email){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public Contact(){}

    static void saveFile() throws IOException {

        //Global global = new Global();
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer
                .include("*")
                .serialize(Controller.contacts);

        File f = new File("Contacts.json");
        FileWriter fw = new FileWriter(f);

        fw.write(json);
        fw.close();
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", this.name, this.phoneNumber, this.email);
    }

    public ArrayList<Contact> load() throws FileNotFoundException {

        File f = new File("Contacts.json");
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();
        s.close();

        JsonParser p = new JsonParser();
        return p.parse(contents, ArrayList.class);
    }
}
