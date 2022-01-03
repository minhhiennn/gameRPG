package com.gamerpg.initGame;

import java.awt.*;

public class HomeRoundtableObject extends SuperObject {

    public HomeRoundtableObject() {
        this.name = "HOME_ROUND_TABLE";
        this.collision = true;

        this.width = 51;
        this.heigth = 43;

        this.rectangle = new Rectangle(0, 0, this.width, this.heigth);
    }
}
