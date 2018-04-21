/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.crashdemons.xorlib;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author crash
 */


public class GeneratorDataSource extends DataSource {
    public GeneratorType type = GeneratorType.CONSTANT;
    public long seed=-1;
    public byte byte_value=0;
    private byte current_byte_value=0;
    private static Random rand;
    
    public GeneratorDataSource(GeneratorType type, long initial_value){
        setSource(type,initial_value);
    }
    
    public void setSource(GeneratorType type, long initial_value){
        super.setSource(0, 0, -1);
        this.type = type;
        switch(type){
            case CONSTANT:
                byte_value = (byte) initial_value;
                break;
            case RANDOM:
                seed = initial_value;
                break;
            case INCREMENTAL:
                byte_value=(byte) initial_value;
                break;
        }
        reset();
    }
    public void reset(){
        switch(type){
            case RANDOM:
                if(seed!=-1) rand.setSeed(seed);
                break;
            case INCREMENTAL:
                current_byte_value=(byte) byte_value;
                break;
        }
    }
    
    private void generateRand(ByteBuffer buf,int nbytes){
        byte[] gbuf = new byte[nbytes];
        rand.nextBytes(gbuf);
        buf.put(gbuf);
    }
    private void generateConstant(ByteBuffer buf,int nbytes){
        byte[] gbuf = new byte[nbytes];
        Arrays.fill(gbuf,byte_value);
        buf.put(gbuf);
    }
    private void generateIncremental(ByteBuffer buf,int nbytes){
        byte[] gbuf = new byte[nbytes];
        for(int i=0;i<nbytes;i++){
            System.out.println(current_byte_value);
            gbuf[i] = (current_byte_value++);
        }
        buf.put(gbuf);
    }
    
    public void generate(ByteBuffer buf,int nbytes){
        switch(type){
            case CONSTANT:
                System.out.println("const");
                generateConstant(buf,nbytes);
                break;
            case RANDOM:
                System.out.println("rng");
                generateRand(buf,nbytes);
                break;
            case INCREMENTAL:
                System.out.println("inc");
                generateIncremental(buf,nbytes);
                break;
        }
    }
    
    
    
}
