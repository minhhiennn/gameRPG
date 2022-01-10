package com.gamerpg.initGame;

public class MainCharacter {

    private int Dir = 1; // có 4 hướng quay nhân vật
    // Dir = 1 quay trái
    // Dir = 2 quay phải
    // Dir = 3 quay lên
    // Dir = 4 quay xuống
    // Dir = 5 không làm gì hết
    private int Stage = 1; // lúc đi có 3 cái hình (animation)
    // 1 là hình đầu
    // 5 là hình sau
    // 10 là hình cuối

    public MainCharacter() {

    }

    public int getDir() {
        return Dir;
    }

    public void setDir(int dir) {
        Dir = dir;
    }

    public int getStage() {
        return Stage;
    }

    public void setStage(int stage) {
        Stage = stage;
    }
}
