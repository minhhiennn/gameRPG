package com.gamerpg.initGame;

import java.awt.*;

public class HomeDownStairObject extends SuperObject {

    public HomeDownStairObject() {
        this.name = "HOME_DOWN_STAIR";
        this.collision = true;

        this.width = 62;
        this.heigth = 69;

        this.rectangle = new Rectangle(0, 0, this.width, this.heigth);
    }
}
