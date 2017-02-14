package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


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
            contact.load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        list.setItems(contacts);

    }

    public void addItem() throws IOException {
        if(!name.getText().isEmpty() && !phoneNumber.getText().isEmpty() && !email.getText().isEmpty()){
            contacts.add(new Contact(name.getText(), phoneNumber.getText(), email.getText()));
            contact.saveFile();
            name.setText("");
            phoneNumber.setText("");
            email.setText("");
        }

    }

    public void removeItem() throws IOException {
        Contact item = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(item);
        contact.saveFile();
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
