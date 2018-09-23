/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.crashdemons.xorj;

import static com.github.crashdemons.xorj.Common.stoi;

/**
 *
 * @author crashdemons <crashdemons -at- github.com>
 */
public class FileInfo {
    public long start;
    public long end;
    public long size;
    public String filename;
    
    public long constBytePos;
    
    public FileInfo(FileEntry fe){
        start=fe.getStart();
        end=fe.getEnd();
        size=fe.getFilesize();
        filename=fe.getFilename();
        constBytePos=0l;
    }
    public boolean isConstByteValue(){
        return filename.startsWith("byte://const/");
    }
     public int getConstByteValue(){
        if(isConstByteValue()){
            String svalue = filename.substring("byte://const/".length());
            return stoi(svalue);
        }else return 0;
    }
}
