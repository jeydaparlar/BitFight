package bitFight;

import java.io.IOException;

import bitFight.Image;

public class ImageTest{

   
    public static void main(String[] args) throws IOException {
        Image image=new Image("res/mouvement.ini", 16);
        image.imageGenerator();
        Image image2=new Image("res/perso-1.txt", 16);
        image2.imageGenerator();
        Image image3=new Image("res/fight.ini", 12);
        image3.imageGenerator();
    }
}

