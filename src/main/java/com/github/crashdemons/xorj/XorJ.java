/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.crashdemons.xorj;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 *
 * @author crashdemons <crashdemons -at- github.com>
 */
public class XorJ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //GridLayout grid = new GridLayout(0,1,1,1);
        
        UI ui = new UI();
        FilePanel jp = new FilePanel();

        ui.setVisible(true);
    }
}
