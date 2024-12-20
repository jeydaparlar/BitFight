package bitFight;

import java.io.*;

public class Save{

    static <T> void saveObject(String fileLocation, T object) {
       try (FileOutputStream fileOut = new FileOutputStream(fileLocation);
       ObjectOutputStream out = new ObjectOutputStream(fileOut) ){
        out.writeObject(object);
         System.out.println(fileLocation+" : Saved");
       } catch (IOException e) {
         System.out.println(" erreur save:" + e.toString());
       }   
     } 

  static <T> T loadObject(String fileLocation) {
     try (FileInputStream fileIn = new FileInputStream(fileLocation);
     ObjectInputStream in = new ObjectInputStream(fileIn)){
      T object = (T) in.readObject();
      System.out.println(fileLocation+" : Loaded");
        return (T) object;
     } catch (Exception e) {
       System.out.println(" erreur load:" +fileLocation + ": "+e.toString());
       return null;
     }    
  }
}


    
