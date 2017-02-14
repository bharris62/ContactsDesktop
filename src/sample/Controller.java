package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable{
    static ObservableList<Contact> contacts = FXCollections.observableArrayList();
    Contact contact = new Contact();

    @FXML
    ListView list;

    @FXML
    TextField name;

    @FXML
    TextField phoneNumber;

    @FXML
    TextField email;

    public Controller(){}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        list.setItems(contacts);

    }

    public void addItem() throws IOException {
        if(!name.getText().isEmpty() && !phoneNumber.getText().isEmpty() && !email.getText().isEmpty()){
            contacts.add(new Contact(name.getText(), phoneNumber.getText(), email.getText()));
            saveFile();
            name.setText("");
            phoneNumber.setText("");
            email.setText("");
        }

    }

    public void removeItem() throws IOException {
        Contact item = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(item);
        saveFile();
    }

    public static void load() throws FileNotFoundException {

        File f = new File("Contacts.json");
        Scanner s = new Scanner(f);
        JsonParser parser = new JsonParser();
        Contact contact;

        while(s.hasNext()){
            contact = parser.parse(s.nextLine(), Contact.class);

            contacts.add(contact);
        }
    }

    static void saveFile() throws IOException {

        JsonSerializer serializer = new JsonSerializer();
//        String json = serializer
//                .include("*")
//                .serialize(Controller.contacts);

        File f = new File("Contacts.json");
        FileWriter fw = new FileWriter(f);
        for(Contact c : contacts) {
            fw.write(serializer.serialize(c) + "\n");
        }

        fw.close();
    }

    public static ObservableList<Contact> getContacts() {
        return contacts;
    }

    public static void setContacts(ObservableList<Contact> contacts) {
        Controller.contacts = contacts;
    }

    public ListView getList() {
        return list;
    }

    public void setList(ListView list) {
        this.list = list;
    }

    public TextField getName() {
        return name;
    }

    public void setName(TextField name) {
        this.name = name;
    }

    public TextField getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(TextField phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TextField getEmail() {
        return email;
    }

    public void setEmail(TextField email) {
        this.email = email;
    }




}
