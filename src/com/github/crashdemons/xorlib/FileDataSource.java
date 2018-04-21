/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.crashdemons.xorlib;

import java.io.File;

/**
 *
 * @author crash
 */
public class FileDataSource extends DataSource{
    public String filename;
    public void setSource(String filename){
        this.filename=filename;
        long start = 0;
        long size = (new File(filename)).length();
        long end = size-1;
        if(size==0) end=0;
        super.setSource(start, end, size);
    }
    public FileDataSource(String fn){
        setSource(fn);
    }
}
