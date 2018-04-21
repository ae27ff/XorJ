/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.crashdemons.xorj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage; 

import com.github.crashdemons.xorlib.GeneratorDataSource;
import com.github.crashdemons.xorlib.GeneratorType;
import java.nio.ByteBuffer;

/**
 *
 * @author crash
 */
public class XorJ extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("XorJ_View.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(com.sun.javafx.runtime.VersionInfo.getRuntimeVersion());
        
        
        GeneratorDataSource gen = new GeneratorDataSource(GeneratorType.INCREMENTAL, 126);
        
        byte[] barr = new byte[5];
        ByteBuffer bbuf = ByteBuffer.allocate(5);
        bbuf.rewind();
        
        System.out.println("init "+bbuf.position() + " "+bbuf.limit());
        
        while (bbuf.hasRemaining()){
            byte b= bbuf.get();
            System.out.println("   Byte = "+b+" "+bbuf.position() + " "+bbuf.limit());
        }
        bbuf.rewind();
        System.out.println("gen "+bbuf.position() + " "+bbuf.limit());
        gen.generate(bbuf,5);
        bbuf.rewind();
        
        System.out.println("out "+bbuf.position() + " "+bbuf.limit());
        while (bbuf.hasRemaining()){
            byte b= bbuf.get();
            System.out.println("   Byte = "+b+" "+String.format("%02X ",b)+" "+bbuf.position() + " "+bbuf.limit());
        }
        
        System.out.println("fin "+bbuf.position() + " "+bbuf.limit());
        launch(args);
    }
    
}
