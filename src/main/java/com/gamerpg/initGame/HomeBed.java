package com.gamerpg.initGame;

import java.awt.*;

public class HomeBed extends SuperObject {

    public HomeBed() {
        this.name = "HOME_BED";
        this.collision = true;

        this.width = 94;
        this.heigth = 92;


        this.rectangle = new Rectangle(0, 0, this.width, this.heigth);
    }
}
