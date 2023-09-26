package com.example.application.views;

import org.springframework.context.annotation.Scope;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;

import jakarta.annotation.security.PermitAll;

@SpringComponent
@Scope("prototype")
@PermitAll
@Route(value = "child", layout = MainLayout.class)
@PageTitle("Kind")
public class ChildView extends VerticalLayout {

    H1 title;
    ComboBox<String> comboBoxName;
    TextField textFieldPrice;
    TextField textFieldItemBought;
    Button buttonSave;
    String selectedName = "";
    
    public ChildView() {
        this.add(this.getTitle());
        this.add(this.getComboBoxName());
        this.add(this.getTextFieldPrice());
        this.add(this.getTextFieldItemBought());
        this.add(this.getButtonSave());
    }

    private H1 getTitle() {
        if (this.title  == null) {
            this.title = new H1("Kind");
        }
        return this.title;
    }

    private ComboBox<String> getComboBoxName() {
        if (this.comboBoxName == null) {
            this.comboBoxName = new ComboBox<>("Naam");
            this.comboBoxName.setItems("Silke", "Stijn");
            this.comboBoxName.addValueChangeListener(e -> {
                this.selectedName = e.getValue();
            });
        }
        return this.comboBoxName;
    }

    private TextField getTextFieldPrice() {
        if (this.textFieldPrice == null) {
             this.textFieldPrice = new TextField("Prijs (euro)");
        }
        return this.textFieldPrice;
    }

    private TextField getTextFieldItemBought() {
        if (this.textFieldItemBought == null) {
            this.textFieldItemBought = new TextField("Gekocht voorwerp");
        }
        return this.textFieldItemBought;
    }

    private Button getButtonSave() {
        if (this.buttonSave == null) {
            this.buttonSave = new Button("Opslaan");
            this.buttonSave.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
            this.buttonSave.addClickListener(e -> {
                System.out.println(
                    "Voor " + this.selectedName + " " +
                    "heb ik " + this.getTextFieldItemBought().getValue() + " gekocht " + 
                    "voor " + this.getTextFieldPrice().getValue() + " euro"
                );
            });
        }
        return this.buttonSave;
    }
}
