package bitFight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Image{

    String filePath;
    int size;
    File file;

    public Image (String  filePath,int size){
        this.filePath=filePath;
        this.file= new File(filePath);
        this.size=size;
    }

    public void imageGenerator() throws IOException{
        BufferedReader br= new BufferedReader(new FileReader(this.file));
        String s="";
        for(int i=0; i<size;i++){
            s= br.readLine();
            System.out.println(s);
        }
        br.close();
        
    }
}