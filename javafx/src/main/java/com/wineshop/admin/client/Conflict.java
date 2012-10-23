package com.wineshop.admin.client;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.granite.client.tide.data.Conflicts;
import org.granite.client.tide.javafx.TideFXMLLoader;

public class Conflict {
	
	private final Stage alert;
	private final Conflicts conflicts;
	
	public Conflict(Conflicts conflicts) throws IOException {
		this.conflicts = conflicts;
		alert = new Stage(StageStyle.TRANSPARENT);
		alert.initModality(Modality.APPLICATION_MODAL);
		Parent root = (Parent)TideFXMLLoader.load("Conflict.fxml", this);
		alert.setScene(new Scene(root));
	}
	
	public void show() {
		alert.show();
	}
	
	@FXML
	public void acceptClient() {
		conflicts.acceptAllClient();
		alert.close();
	}
	
	@FXML
	public void acceptServer() {
		conflicts.acceptAllServer();
		alert.close();
	}
}