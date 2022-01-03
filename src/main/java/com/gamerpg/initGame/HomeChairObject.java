package com.gamerpg.initGame;

import java.awt.*;

public class HomeChairObject extends SuperObject {

    public HomeChairObject() {
        this.name = "HOME_CHAIR";
        this.collision = true;

        this.width = 24;
        this.heigth = 30;

        this.rectangle = new Rectangle(0, 0, this.width, this.heigth);
    }

}
