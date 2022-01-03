package com.gamerpg.initGame;

import java.awt.*;

public class HomeBenchObject extends SuperObject {

    public HomeBenchObject() {
        this.name = "HOME_BENCH";
        this.collision = true;

        this.width = 26;
        this.heigth = 51;

        this.rectangle = new Rectangle(0, 0, this.width, this.heigth);
    }
}
