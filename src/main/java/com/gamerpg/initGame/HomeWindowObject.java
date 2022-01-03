package com.gamerpg.initGame;

import java.awt.*;

public class HomeWindowObject extends SuperObject {

    public HomeWindowObject() {
        this.name = "HOME_WINDOW";
        this.collision = true;

        this.width = 43;
        this.heigth = 48;

        this.rectangle = new Rectangle(0, 0, this.width, this.heigth);
    }
}
