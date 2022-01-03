package com.gamerpg.initResources;

import com.gamerpg.GolbalUse;
import com.gamerpg.Main;
import com.gamerpg.initGame.*;

import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;

public class MapReader {

    private ImagesResource imagesResource;

    public MapReader(ImagesResource imagesResource) {
        this.imagesResource = imagesResource;
    }

    public void initMap() throws IOException, URISyntaxException {
        // đọc file
        File file = new File(Paths.get(Objects.requireNonNull(Main.class.getResource("map/map.txt")).toURI()).toString());
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        int i = 0;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lineSplit = line.split(" ");
            for (int j = 0; j < lineSplit.length; j++) {
                GolbalUse.grid[i][j] = new Cell();
                if (Integer.parseInt(lineSplit[j]) == 0) {
                    GolbalUse.grid[i][j].floor = true;
                } else if (Integer.parseInt(lineSplit[j]) == 1) {
                    GolbalUse.grid[i][j].wall = true;
                } else if (Integer.parseInt(lineSplit[j]) == 2) {
                    GolbalUse.grid[i][j].black = true;
                } else if (Integer.parseInt(lineSplit[j]) == 3) {
                    GolbalUse.grid[i][j].home_floor = true;
                } else if (Integer.parseInt(lineSplit[j]) == 7) {
                    GolbalUse.grid[i][j].collision = true;
                    GolbalUse.grid[i][j].home_wall = true;
                }
            }
            i++;
        }
        fileReader.close();
        bufferedReader.close();
    }

    public void initMapObject() throws IOException, URISyntaxException {
        File file = new File(Paths.get(Objects.requireNonNull(Main.class.getResource("map/map_object.txt")).toURI()).toString());
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        int i = 0;
        int indexObj = 0;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lineSplit = line.split(" ");
            for (int j = 0; j < lineSplit.length; j++) {
                if (Integer.parseInt(lineSplit[j]) == 4) {
                    GolbalUse.gridObj[indexObj] = new HomeBenchObject();
                    GolbalUse.gridObj[indexObj].pointX = 32 * j;
                    GolbalUse.gridObj[indexObj].pointY = 32 * i;
                    GolbalUse.gridObj[indexObj].image = imagesResource.IMG_Resource[GolbalUse.IMG_HOME_BENCH];
                    indexObj++;
                } else if (Integer.parseInt(lineSplit[j]) == 5) {
                    GolbalUse.gridObj[indexObj] = new HomeBookcaseObject();
                    GolbalUse.gridObj[indexObj].pointX = 32 * j;
                    GolbalUse.gridObj[indexObj].pointY = 32 * i;
                    GolbalUse.gridObj[indexObj].image = imagesResource.IMG_Resource[GolbalUse.IMG_HOME_BOOKCASE];
                    indexObj++;
                } else if (Integer.parseInt(lineSplit[j]) == 6) {
                    GolbalUse.gridObj[indexObj] = new HomeRoundtableObject();
                    GolbalUse.gridObj[indexObj].pointX = 32 * j;
                    GolbalUse.gridObj[indexObj].pointY = 32 * i;
                    GolbalUse.gridObj[indexObj].image = imagesResource.IMG_Resource[GolbalUse.IMG_HOME_ROUNDTABLE];
                    indexObj++;
                } else if (Integer.parseInt(lineSplit[j]) == 8) {
                    GolbalUse.gridObj[indexObj] = new HomeWindowObject();
                    GolbalUse.gridObj[indexObj].pointX = 32 * j;
                    GolbalUse.gridObj[indexObj].pointY = 32 * i;
                    GolbalUse.gridObj[indexObj].image = imagesResource.IMG_Resource[GolbalUse.IMG_HOME_WINDOW];
                    indexObj++;
                } else if (Integer.parseInt(lineSplit[j]) == 9) {
                    GolbalUse.gridObj[indexObj] = new HomeChairObject();
                    GolbalUse.gridObj[indexObj].pointX = 32 * j;
                    GolbalUse.gridObj[indexObj].pointY = 32 * i + 6;
                    GolbalUse.gridObj[indexObj].image = imagesResource.IMG_Resource[GolbalUse.IMG_HOME_CHAIR];
                    indexObj++;
                } else if (Integer.parseInt(lineSplit[j]) == 10) {
                    GolbalUse.gridObj[indexObj] = new HomeDownStairObject();
                    GolbalUse.gridObj[indexObj].pointX = 32 * j + 2;
                    GolbalUse.gridObj[indexObj].pointY = 32 * i - 4;
                    GolbalUse.gridObj[indexObj].image = imagesResource.IMG_Resource[GolbalUse.IMG_HOME_DOWN_STAIR];
                    indexObj++;
                } else if (Integer.parseInt(lineSplit[j]) == 11) {
                    GolbalUse.gridObj[indexObj] = new HomeBed();
                    GolbalUse.gridObj[indexObj].pointX = 32 * j + 3;
                    GolbalUse.gridObj[indexObj].pointY = 32 * i;
                    GolbalUse.gridObj[indexObj].image = imagesResource.IMG_Resource[GolbalUse.IMG_HOME_BED];
                    indexObj++;
                }
            }
            i++;
        }
        fileReader.close();
        bufferedReader.close();
    }
}
