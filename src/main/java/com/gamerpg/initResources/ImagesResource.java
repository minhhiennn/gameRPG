package com.gamerpg.initResources;

import com.gamerpg.GolbalUse;
import com.gamerpg.Main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ImagesResource {

    public BufferedImage[] IMG_Resource = new BufferedImage[12];
    public BufferedImage[] IMG_Character_Resource = new BufferedImage[12];

    public ImagesResource() throws IOException {
        initializeResource();
        initializeCharacterResource();
    }

    public void initializeResource() throws IOException {
        BufferedImage image = ImageIO.read(Objects.requireNonNull(Main.class.getResource("images/imageGame1.jpg")));
        IMG_Resource[GolbalUse.IMG_FLOOR] = image.getSubimage(0, 32, 32, 32);
        IMG_Resource[GolbalUse.IMG_WALL] = image.getSubimage(224, 64, 32, 32);
        IMG_Resource[GolbalUse.IMG_BLACK] = image.getSubimage(0, 0, 32, 32);
        IMG_Resource[GolbalUse.IMG_HOME_WALL] = image.getSubimage(224, 64, 32, 32);
        IMG_Resource[GolbalUse.IMG_HOME_FLOOR] = image.getSubimage(160, 128, 32, 32);
        // home furniture
        BufferedImage image1 = ImageIO.read(Objects.requireNonNull(Main.class.getResource("images/homeFurniture.jpg")));
        IMG_Resource[GolbalUse.IMG_HOME_BENCH] = image1.getSubimage(249, 191, 26, 51);
        IMG_Resource[GolbalUse.IMG_HOME_BOOKCASE] = image1.getSubimage(351, 258, 48, 74);
        IMG_Resource[GolbalUse.IMG_HOME_ROUNDTABLE] = image1.getSubimage(382, 353, 51, 43);
        IMG_Resource[GolbalUse.IMG_HOME_CHAIR] = image1.getSubimage(160, 189, 24, 30);
        // home continue
        BufferedImage image2 = ImageIO.read(Objects.requireNonNull(Main.class.getResource("images/home3.jpg")));
        IMG_Resource[GolbalUse.IMG_HOME_WINDOW] = image2.getSubimage(104, 138, 43, 48);
        IMG_Resource[GolbalUse.IMG_HOME_DOWN_STAIR] = image2.getSubimage(438, 422, 62, 69);
        IMG_Resource[GolbalUse.IMG_HOME_BED] = image2.getSubimage(0, 62, 94, 92);

    }

    public void initializeCharacterResource() throws IOException {
        BufferedImage image = ImageIO.read(Objects.requireNonNull(Main.class.getResource("images/imageCharacter.jpg")));
        IMG_Character_Resource[GolbalUse.IMG_CHARACTER_1_1] = image.getSubimage(198, 64, 22, 32);
        IMG_Character_Resource[GolbalUse.IMG_CHARACTER_1_2] = image.getSubimage(230, 64, 22, 32);
        IMG_Character_Resource[GolbalUse.IMG_CHARACTER_1_3] = image.getSubimage(261, 64, 22, 32);
        IMG_Character_Resource[GolbalUse.IMG_CHARACTER_2_1] = image.getSubimage(195, 32, 23, 32);
        IMG_Character_Resource[GolbalUse.IMG_CHARACTER_2_2] = image.getSubimage(227, 32, 23, 32);
        IMG_Character_Resource[GolbalUse.IMG_CHARACTER_2_3] = image.getSubimage(259, 32, 23, 32);
        IMG_Character_Resource[GolbalUse.IMG_CHARACTER_3_1] = image.getSubimage(197, 96, 23, 32);
        IMG_Character_Resource[GolbalUse.IMG_CHARACTER_3_2] = image.getSubimage(229, 96, 23, 32);
        IMG_Character_Resource[GolbalUse.IMG_CHARACTER_3_3] = image.getSubimage(261, 96, 23, 32);
        IMG_Character_Resource[GolbalUse.IMG_CHARACTER_4_1] = image.getSubimage(195, 0, 27, 32);
        IMG_Character_Resource[GolbalUse.IMG_CHARACTER_4_2] = image.getSubimage(226, 0, 29, 32);
        IMG_Character_Resource[GolbalUse.IMG_CHARACTER_4_3] = image.getSubimage(259, 0, 27, 32);
    }

//    chức năng làm mờ ảnh(hiện tại chưa xài tới)
//    gc.setGlobalBlendMode(BlendMode.SCREEN);
//        for (int i = 0 ; i < NUM_IMGS; i++) {
//            final double opacity = 1 - ((double) i) / NUM_IMGS;
//            System.out.println(opacity);
//            gc.setGlobalAlpha(opacity);
//            gc.setEffect(new BoxBlur(i * 2, i * 2, 3));
//
//            gc.drawImage(image, i * W, 0);
//        }

}
