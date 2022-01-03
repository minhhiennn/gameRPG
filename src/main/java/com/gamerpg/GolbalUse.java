package com.gamerpg;

import com.gamerpg.initGame.SuperObject;
import com.gamerpg.initResources.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GolbalUse {


/*
     có tất cả 12 bức hình character
     tên biến được đặt theo Character_DIR_STAGE
*/

    public static final int IMG_CHARACTER_1_1 = 0;
    public static final int IMG_CHARACTER_1_2 = 1;
    public static final int IMG_CHARACTER_1_3 = 2;
    public static final int IMG_CHARACTER_2_1 = 3;
    public static final int IMG_CHARACTER_2_2 = 4;
    public static final int IMG_CHARACTER_2_3 = 5;
    public static final int IMG_CHARACTER_3_1 = 6;
    public static final int IMG_CHARACTER_3_2 = 7;
    public static final int IMG_CHARACTER_3_3 = 8;
    public static final int IMG_CHARACTER_4_1 = 9;
    public static final int IMG_CHARACTER_4_2 = 10;
    public static final int IMG_CHARACTER_4_3 = 11;

    /*
     *
     * đây là biến sử dụng cho map ngoài đường
     * map thì có 2 loại là đá với cỏ
     *
     */
    public static final int IMG_FLOOR = 0;
    public static final int IMG_WALL = 1;
    public static final int IMG_BLACK = 2;

    /*
     *
     * đây là biến sử dụng cho map trong nhà
     * map trong nhà thì có nhiều loại : bàn, gỗ, tủ,...
     *
     */
    public static final int IMG_HOME_FLOOR = 3;
    public static final int IMG_HOME_WALL = 7;
    public static final int IMG_HOME_BENCH = 4;
    public static final int IMG_HOME_BOOKCASE = 5;
    public static final int IMG_HOME_ROUNDTABLE = 6;
    public static final int IMG_HOME_WINDOW = 8;
    public static final int IMG_HOME_CHAIR = 9;
    public static final int IMG_HOME_DOWN_STAIR = 10;
    public static final int IMG_HOME_BED = 11;


    //start point
    public static int pointX = 100;
    public static int pointY = 100;


    // chiều dài, chiều rộng nhân vật
    public static int characterWidth = 25;
    public static int characterHeight = 16;
    public static Rectangle rectangleCharacter = new Rectangle(0, 16, characterWidth, characterHeight);

    // khởi tạo list Cell của map
    public static Cell[][] grid = new Cell[50][50];

    // khởi tạo list Object của map
    // lúc đầu chỉ cho 10 object
    public static SuperObject[] gridObj = new SuperObject[10];


    public static Image convertToFxImage(BufferedImage image) {
        WritableImage wr = null;
        if (image != null) {
            wr = new WritableImage(image.getWidth(), image.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    pw.setArgb(x, y, image.getRGB(x, y));
                }
            }
        }
        return new ImageView(wr).getImage();
    }
}
