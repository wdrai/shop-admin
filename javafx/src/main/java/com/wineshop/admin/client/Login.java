/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wineshop.admin.client;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.inject.Inject;

import org.granite.client.tide.data.DataObserver;
import org.granite.client.tide.events.TideEvent;
import org.granite.client.tide.events.TideEventObserver;
import org.granite.client.tide.javafx.spring.Identity;
import org.granite.client.tide.server.ServerSession;
import org.granite.client.tide.server.SimpleTideResponder;
import org.granite.client.tide.server.TideFaultEvent;
import org.granite.client.tide.server.TideResultEvent;
import org.springframework.stereotype.Component;

/**
 * 
 * @author william
 */
@Component
public class Login implements Initializable, TideEventObserver {

	@FXML
	private TextField fUsername;
	
	@FXML
	private PasswordField fPassword;
	
	@FXML
	private Label lMessage;
	
	@Inject
	private Identity identity;
	
	@Inject
	private DataObserver wineshopTopic;
	
	
	@SuppressWarnings("unused")
	@FXML
	private void login(ActionEvent event) {
		identity.login(fUsername.getText(), fPassword.getText(),
			new SimpleTideResponder<String>() {
				@Override
				public void result(TideResultEvent<String> tre) {
					lMessage.setVisible(false);
				}
				
				@Override
				public void fault(TideFaultEvent tfe) {
					lMessage.setVisible(true);
					lMessage.setText(tfe.getFault().getFaultDescription());
				}
			}
		);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}

	@Override
	public void handleEvent(TideEvent event) {
		if (ServerSession.LOGIN.equals(event.getType())) {
			wineshopTopic.subscribe();
		}
		else if (ServerSession.LOGOUT.equals(event.getType())) {
			wineshopTopic.unsubscribe();
		}
		else if (ServerSession.SESSION_EXPIRED.equals(event.getType())) {
			lMessage.setVisible(true);
			lMessage.setText("Session expired");
		}
	}
}
