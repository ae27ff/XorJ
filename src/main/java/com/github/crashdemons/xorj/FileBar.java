/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.crashdemons.xorj;

/**
 *
 * @author crashdemons <crashdemons -at- github.com>
 */
public class FileBar {
    long start,end,size,selected;
    int x,width, xselected, wselected;
    
    public FileBar(FileEntry fe){
        init(fe.getStart(),fe.getEnd(),fe.getFilesize());
    }
    public FileBar(long start, long end,long filesize){
        init(start, end, filesize);
    }
    private void init(long start, long end,long filesize){
        this.start=start;
        this.end=end;
        this.size=filesize;
        
        selected=(end-start)+1;
        if(selected<0) selected=0;
        x=0;
    }
    
    public void setScale(int maxwidth, long maxsize){
       width= getWidth(maxwidth,maxsize);
       xselected=getSelectionX();
       wselected=getSelectionW();
       if(width<6) width=5;
       if(wselected<3) wselected=5;
    }
    public void shift(int x){
        this.x+=x;
        this.xselected+=x;
    }
    
    
    
    private int getSelectionW(){
        double p = getScale(selected,size);
        return scaleValue(p,width);
    }
    private int getSelectionX(){
         double p=getScale(start,size-1);
         return scaleValue(p,width);
    }
    private double getPosFraction(){
         return ((double) start)/((double) (size-1));
    }
    
    
    public double getScale(long n,long bound){
        return ((double) n)/((double) bound);
    }
    public int scaleValue(double percent,long value){
        return (int)(percent*(double)value);
    }
    
    
    
    public int getWidth(int maxwidth,long maxsize){
        if(maxsize<=0) return maxwidth;
        double p =getScale(size,maxsize);
        return scaleValue(p,maxwidth);
    }
}
