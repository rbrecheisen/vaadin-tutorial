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
@Route(value = "car", layout = MainLayout.class)
@PageTitle("Auto")
public class CarView extends VerticalLayout {
    
    H1 title = new H1("Auto");
    ComboBox<String> comboBoxCar = new ComboBox<>("Auto");
    TextField textFieldKm = new TextField("Kilometers");
    TextField textFieldDestination = new TextField("Bestemming");
    Button buttonSave = new Button("Opslaan");

    public CarView() {
        this.comboBoxCar.setItems("Mazda 6", "MX-5");
        this.buttonSave.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        this.add(this.title);
        this.add(this.comboBoxCar);
        this.add(this.textFieldKm);
        this.add(this.textFieldDestination);
        this.add(this.buttonSave);
    }
}
