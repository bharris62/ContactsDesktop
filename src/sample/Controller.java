package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @FXML
    ListView list;

    @FXML
    TextField name;

    @FXML
    TextField phoneNumber;

    @FXML
    TextField email;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }

    public void addItem() {
        if(!name.getText().isEmpty() && !phoneNumber.getText().isEmpty() && !email.getText().isEmpty()){
            contacts.add(new Contact(name.getText(), phoneNumber.getText(), email.getText()));
            name.setText("");
            phoneNumber.setText("");
            email.setText("");
        }

    }

    public void removeItem() {
        Contact item = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(item);
    }


}
