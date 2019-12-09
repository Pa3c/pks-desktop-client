package com.pks.desktop.client.application;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

@Component
public class SpringFXMLLoader {

    @Autowired
    private ApplicationContext springContext ;

    public Parent load(String resourceName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceName));
        loader.setControllerFactory(springContext::getBean);
        return loader.load();
    }
}
