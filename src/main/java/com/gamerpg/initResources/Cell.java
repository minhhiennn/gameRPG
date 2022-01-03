package com.gamerpg.initResources;

public class Cell {


    public boolean floor;
    public boolean wall;
    public boolean black;

    //object
    public boolean home_floor;
    public boolean home_wall;

    //collision
    public boolean collision;


    public Cell() {
        floor = false;
        wall = false;
        black = false;

        //home
        home_floor = false;
        home_wall = false;


        //collision
        collision = false;
    }
}
