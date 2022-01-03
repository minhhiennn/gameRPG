package com.gamerpg.initGame;

import java.awt.*;

public class HomeBookcaseObject extends SuperObject {

    public HomeBookcaseObject() {
        this.name = "HOME_BOOK_CASE";
        this.collision = true;

        this.width = 48;
        this.heigth = 74;

        this.rectangle = new Rectangle(0, 0, this.width, this.heigth);
    }
}
