/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.crashdemons.xorj;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author crash
 */
public class XorJFilePane_Controller implements Initializable {

    @FXML
    private TextField inpFilename;
    @FXML
    private Label lblFilesize;
    @FXML
    private TextField inpPosStart;
    @FXML
    private TextField inpPosEnd;
    @FXML
    private Label lblSelectionLength;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonChooseFile(ActionEvent event) {
    }

    @FXML
    private void handleButtonResetStart(ActionEvent event) {
    }

    @FXML
    private void handleButtonGoToEnd(ActionEvent event) {
    }

    @FXML
    private void handleButtonChooseLength(ActionEvent event) {
    }
    
}
