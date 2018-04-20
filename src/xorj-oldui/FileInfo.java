/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xorj;

/**
 *
 * @author crashdemons <crashdemons -at- github.com>
 */
public class FileInfo {
    public long start;
    public long end;
    public long size;
    public String filename;
    public FileInfo(FileEntry fe){
        start=fe.getStart();
        end=fe.getEnd();
        size=fe.getFilesize();
        filename=fe.getFilename();
    }
}
