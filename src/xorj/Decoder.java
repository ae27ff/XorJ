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
        fos.close();
        fos=null;
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
            FileInfo fi=new FileInfo(fe);
            File file = new File(fi.filename);  // initialize somewhere
            byte[] myBytes = new byte[CHUNK];
            ByteBuffer buffer=ByteBuffer.wrap(myBytes);  // initialize somewhere
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            FileChannel fc = raf.getChannel();
            fc.position(fi.start);  // position to the byte you want to start reading
            
            info.add(fi);
            files.add(file);
            buffers.add(buffer);
            raffiles.add(raf);
            channels.add(fc);
        }
    }
    public boolean readAll() throws IOException{
        minread=-1;
        boolean lastRead=false;
        for(int i=0;i<info.size();i++){
            FileChannel fc=channels.get(i);
            long pos=fc.position();
            if(pos>info.get(i).end || pos>=info.get(i).size) return false;
            int nread=fc.read(buffers.get(i));
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
