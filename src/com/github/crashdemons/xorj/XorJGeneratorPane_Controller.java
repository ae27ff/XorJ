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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author crash
 */
public class XorJGeneratorPane_Controller implements Initializable {

    @FXML
    private TextField inpByteValue;
    @FXML
    private RadioButton radGenConst;
    @FXML
    private ToggleGroup tgGenerators;
    @FXML
    private RadioButton radGenInc;
    @FXML
    private RadioButton radGenRand;
    @FXML
    private RadioButton radGenInvert;
    @FXML
    private TextField inpSeed;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleRadioGenerator(ActionEvent event) {
    }
    
}
