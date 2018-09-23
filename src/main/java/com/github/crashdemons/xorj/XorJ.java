/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.crashdemons.xorj;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
        
        InputStream resource = XorJ.class.getResourceAsStream("/application.properties");
        if(resource==null){//internal resource not found
            System.err.println("WARNING: Internal resource not found - application name may not display correctly.");
        }else{
            Properties props = new Properties();
            try{
                props.load(resource);
                String name = props.getProperty("NAME");
                String ver = props.getProperty("VERSION");
                ui.setTitle(name+" - "+ver);
            }catch(IOException e){
                System.err.println("WARNING: Internal resource reading failed - application name may not display correctly.");
            }
        }
        
    }
}
