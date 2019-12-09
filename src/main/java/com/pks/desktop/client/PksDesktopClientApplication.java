package com.pks.desktop.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class PksDesktopClientApplication extends Application {

	private ConfigurableApplicationContext springContext;
	private Parent root;
	private FXMLLoader loader;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(PksDesktopClientApplication.class);
		loader = new FXMLLoader();
		loader.setControllerFactory(springContext::getBean);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		loader.setLocation(getClass().getResource("welcomepanel/WelcomeLayout.fxml"));
		root = loader.load();
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("PKS dekstop client");
		primaryStage.setOnCloseRequest(event -> System.exit(0));
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		springContext.stop();
		super.stop();
	}

}
