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
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

/**
 *
 * @author crash
 */
public class XorJ_Controller implements Initializable {

    @FXML
    private TextField inpChunk;
    @FXML
    private Label lblFilesAdded;
    @FXML
    private Label lblGensAdded;
    @FXML
    private Label lblTotalChunks;
    @FXML
    private Label lblTotalBytes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    @FXML
    private void handleButtonFileAdd(ActionEvent event) {
            //lblFilesAdded.setText("test");
    }

    @FXML
    private void handleButtonFileClear(ActionEvent event) {
    }

    @FXML
    private void handleInputChunk(ActionEvent event) {
    }

    @FXML
    private void handleButtonGenAdd(ActionEvent event) {
    }

    @FXML
    private void handleButtonGenClear(ActionEvent event) {
    }
   
}
