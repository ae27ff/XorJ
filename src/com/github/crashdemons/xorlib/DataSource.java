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
public abstract class DataSource {
    public long start;
    public long end;
    public long size;
    
    private long source_start;
    private long source_end;
    private long source_size;
    
    public DataSource(){
        source_start=0;
        source_end=0;
        source_size=0;
        resetInclusion();
    }
    public static long calcSizeFromPos(long lstart,long lend){
        if(lstart>lend){
            long ltmp=lstart;
            lstart=lend;
            lend=ltmp;
        }
        return (lend-lstart)+1;
    }
    
    public void setSource(long start, long end, long size){
        this.source_start=start;
        this.source_end=end;
        this.source_size=size;
        resetInclusion();
    }
    
    public void resetInclusion(){
        this.start=this.source_start;
        this.end=this.source_end;
        this.size=this.source_size;
    }
    
    public void setInclusionPosForced(long start, long end){
        this.start=start;
        this.end=end;
        this.size=calcSizeFromPos(start,end);
    }
    
    public boolean validateInclusionPos(long lstart, long lend){
        if(lstart<source_start || lstart>source_end) return false;
        if(lend<source_start || lend>source_end) return false;
        if(lstart>lend) return false;
        return true;
    }
    public void setInclusionPosNormalized(long start, long end){
        if(start<source_start) start=source_start;
        if(start>source_end) start=source_end;
        if(end<source_start) end=source_start;
        if(end>source_end) end=source_end;
        if(start>end) start=end;
        setInclusionPosForced(start,end);
    }
    public boolean setInclusionPos(long start, long end){
        if(!validateInclusionPos(start,end)) return false;
        setInclusionPosForced(start,end);
        return true;
    }
    
    
    public boolean setInclusionLength(long start,long length){
        long end = start + (length-1);
        return setInclusionPos(start,end);
    }
    
}
