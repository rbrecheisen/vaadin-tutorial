package com.example.application.views;

import org.springframework.context.annotation.Scope;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;

import jakarta.annotation.security.PermitAll;

@SpringComponent
@Scope("prototype")
@PermitAll
@Route(value = "", layout = MainLayout.class)
@PageTitle("Hoofdmenu")
public class MainMenuView extends VerticalLayout {

    H1 title = new H1("Hoofdmenu");
    Button car = new Button("Auto");
    Button child = new Button("Kind");

    public MainMenuView() {
        this.car.addClickListener(e -> this.car.getUI().ifPresent(ui -> ui.navigate("car")));
        this.child.addClickListener(e -> this.car.getUI().ifPresent(ui -> ui.navigate("child")));
        this.add(title);
        this.add(this.createButtonsLayout());
    }

    private Component createButtonsLayout() {
        this.car.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        this.child.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        return new VerticalLayout(
            this.car,
            this.child
        );
    }
}
