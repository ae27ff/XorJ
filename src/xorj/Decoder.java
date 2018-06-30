/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xorj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author crashdemons <crashdemons -at- github.com>
 */
public class Decoder {
    private static final int CHUNK=512;
    ArrayList<FileInfo> info=new ArrayList<FileInfo>();
    ArrayList<File> files=new ArrayList<File>();
    ArrayList<RandomAccessFile> raffiles=new ArrayList<RandomAccessFile>();
    ArrayList<ByteBuffer> buffers=new ArrayList<ByteBuffer>();
    ArrayList<FileChannel> channels=new ArrayList<FileChannel>();
    
    FileOutputStream fos=null;
    byte[] obuf = new byte[CHUNK];
    int minread;
    
    
    
    
    public Decoder(){
        
    }
    public void clearParameters() throws IOException{
        if(fos!=null) fos.close();
        fos=null;
        
        
        for(FileChannel fc : channels) if(fc!=null) fc.close();
        for(RandomAccessFile raf : raffiles) if(raf!=null) raf.close();
        
        channels.clear();
        buffers.clear();
        raffiles.clear();
        files.clear();
        info.clear();
    }
    public void setSaveFile(String filename) throws FileNotFoundException{
        fos = new FileOutputStream(filename);
    }
    public void setParameters(ArrayList<FileEntry> fes) throws FileNotFoundException, IOException{
        for(FileEntry fe : fes){
            byte[] myBytes = new byte[CHUNK];
            ByteBuffer buffer=ByteBuffer.wrap(myBytes);  // initialize somewhere
            FileInfo fi=new FileInfo(fe);
            if(fi.isConstByteValue()){
                Arrays.fill(myBytes, (byte) fi.getConstByteValue());
                files.add(null);
                raffiles.add(null);
                channels.add(null);
            }else{
                File file = new File(fi.filename);  // initialize somewhere
                RandomAccessFile raf = new RandomAccessFile(file, "r");
                FileChannel fc = raf.getChannel();
                fc.position(fi.start);  // position to the byte you want to start reading

                files.add(file);
                raffiles.add(raf);
                channels.add(fc);
            }
            info.add(fi);
            buffers.add(buffer);
        }
    }
    public boolean readAll() throws IOException{
        minread=-1;
        boolean lastRead=false;
        for(int i=0;i<info.size();i++){
            int nread = 0;
            long nleft = 0;
            if(info.get(i).isConstByteValue()){
                long pos = info.get(i).constBytePos;
                long end = info.get(i).end;
                
                if(pos>end || pos>=info.get(i).size) return false;
                nleft=(end - pos)+1;
                
                //read CHUNK bytes into buffers.get(i); 
                // NOTE: this buffer is preloaded with the byte value in setParameters.
                // We only handle position book-keeping here for constant byte-value inputs.
                nread = CHUNK;
            }else{
                FileChannel fc=channels.get(i);
                long pos=fc.position();
                long end=info.get(i).end;
                
                if(pos>end || pos>=info.get(i).size) return false;
                nleft=(end - pos)+1;

                nread=fc.read(buffers.get(i));//If we read past the selection end, change nread so that the output is cropped. (Issue #1)
            }
            if(nread>nleft) nread=(int)nleft;//Implicit Long comparison: http://stackoverflow.com/questions/11143253
            if(minread==-1 || nread<minread) minread=nread;
            if( nread < CHUNK) lastRead=true;
        }
        return !lastRead;
    }
    public void xorAll(){
        Arrays.fill( obuf, (byte) 0 );
        for(int i=0;i<buffers.size();i++){
            ByteBuffer bb=buffers.get(i);
            byte[] buf=bb.array();
            for(int j=0;j<buf.length;j++)
                obuf[j]^=buf[j];
            bb.clear();
        }
    }
    public void write() throws IOException{
        fos.write(obuf,0,minread);
    }
    
    
    private void test(){
        
    }
    
    
}
