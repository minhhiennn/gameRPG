package com.gamerpg;

import com.gamerpg.initGame.MainCharacter;
import com.gamerpg.initResources.Cell;
import com.gamerpg.initResources.ImagesResource;
import com.gamerpg.initResources.MapReader;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

public class Main extends Application {

    // copy code
    static Set<Character> currentlyPressedKeys = new HashSet<>();
    static Set<Character> wasPressedKeys = new HashSet<>();
    static Set<Integer> currentlyPressedKeyCodes = new HashSet<>();

    static int witdhX = 640;
    static int heightY = 320;
    static int mainScreenX = witdhX / 2 - (32 / 2); //screenX
    static int mainScreenY = heightY / 2 - (32 / 2); //screenY

    //maxWorldCol = 50 => worldWidth = 50 * 32;
    //maxWorldRow = 50 => worldHeight = 50 * 32;

    public static boolean checkCollisionObject(String direction) {

        boolean result = false;

        for (int i = 0; i < GolbalUse.gridObj.length; i++) {
            if (GolbalUse.gridObj[i] != null) {

                GolbalUse.rectangleCharacter.x = GolbalUse.pointX + GolbalUse.rectangleCharacter.x;
                GolbalUse.rectangleCharacter.y = GolbalUse.pointY + GolbalUse.rectangleCharacter.y;

                GolbalUse.gridObj[i].rectangle.x = GolbalUse.gridObj[i].pointX + GolbalUse.gridObj[i].rectangle.x;
                GolbalUse.gridObj[i].rectangle.y = GolbalUse.gridObj[i].pointY + GolbalUse.gridObj[i].rectangle.y;

                switch (direction) {
                    case "up":
                        GolbalUse.rectangleCharacter.y -= GolbalUse.speed;
                        if (GolbalUse.rectangleCharacter.intersects(GolbalUse.gridObj[i].rectangle) && GolbalUse.gridObj[i].collision == true) {
                            result = true;
                        }
                        break;
                    case "down":
                        GolbalUse.rectangleCharacter.y += GolbalUse.speed;
                        if (GolbalUse.rectangleCharacter.intersects(GolbalUse.gridObj[i].rectangle) && GolbalUse.gridObj[i].collision == true) {
                            result = true;
                        }
                        break;
                    case "left":
                        GolbalUse.rectangleCharacter.x -= GolbalUse.speed;
                        if (GolbalUse.rectangleCharacter.intersects(GolbalUse.gridObj[i].rectangle) && GolbalUse.gridObj[i].collision == true) {
                            result = true;
                        }
                        break;
                    case "right":
                        GolbalUse.rectangleCharacter.x += GolbalUse.speed;
                        if (GolbalUse.rectangleCharacter.intersects(GolbalUse.gridObj[i].rectangle) && GolbalUse.gridObj[i].collision == true) {
                            result = true;
                        }
                        break;
                    default:
                        break;
                }
                GolbalUse.rectangleCharacter.x = 0;
                GolbalUse.rectangleCharacter.y = 16;
                GolbalUse.gridObj[i].rectangle.x = 0;
                GolbalUse.gridObj[i].rectangle.y = 0;

            }
        }
        return result;
    }

    public static boolean checkCollision(String direction) {
        boolean result = false;

        int pointLeft = GolbalUse.pointX;
        int pointRight = GolbalUse.pointX + GolbalUse.rectangleCharacter.width;
        int pointTop = GolbalUse.pointY + GolbalUse.rectangleCharacter.y;
        int pointBottom = GolbalUse.pointY + GolbalUse.rectangleCharacter.y + GolbalUse.rectangleCharacter.height;

        // tìm ra col và row
        int leftCol = pointLeft / 32;
        int rightCol = pointRight / 32;
        int topRow = pointTop / 32;
        int bottomRow = pointBottom / 32;

        Cell cell1, cell2;

        switch (direction) {
            case "up":
                topRow = (pointTop - GolbalUse.speed) / 32;
                cell1 = GolbalUse.grid[topRow][leftCol];
                cell2 = GolbalUse.grid[topRow][rightCol];
                if (cell1 == null || cell2 == null) {
                    result = true;
                } else if (cell1.collision || cell2.collision) {
                    result = true;
                }
                break;
            case "down":
                bottomRow = (pointBottom + GolbalUse.speed) / 32;
                cell1 = GolbalUse.grid[bottomRow][leftCol];
                cell2 = GolbalUse.grid[bottomRow][rightCol];
                if (cell1 == null || cell2 == null) {
                    result = true;
                } else if (cell1.collision || cell2.collision) {
                    result = true;
                }
                break;
            case "left":
                leftCol = (pointLeft - GolbalUse.speed) / 32;
                cell1 = GolbalUse.grid[topRow][leftCol];
                cell2 = GolbalUse.grid[bottomRow][leftCol];
                if (cell1 == null || cell2 == null) {
                    result = true;
                } else if (cell1.collision || cell2.collision) {
                    result = true;
                }
                break;
            case "right":
                rightCol = (pointRight + GolbalUse.speed) / 32;
                cell1 = GolbalUse.grid[topRow][rightCol];
                cell2 = GolbalUse.grid[bottomRow][rightCol];
                if (cell1 == null || cell2 == null) {
                    result = true;
                } else if (cell1.collision || cell2.collision) {
                    result = true;
                }
                break;
            default:
                break;
        }

        return result;
    }

    public static void reDraw(GraphicsContext gc, ImagesResource imagesResource, MainCharacter mainCharacter) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, witdhX, heightY);


        //redraw character
        if (isPressed('W')) {
            mainCharacter.setDir(3);
            //chạm rìa
            if (GolbalUse.pointY <= 0) {
                return;
            }

            // check collision
            if (!checkCollision("up") && !checkCollisionObject("up")) {
                GolbalUse.pointY -= GolbalUse.speed;
            }
        }
        if (isPressed('A')) {
            mainCharacter.setDir(2);
            //chạm rìa
            if (GolbalUse.pointX <= 0) {
                return;
            }

            // check collision
            if (!checkCollision("left") && !checkCollisionObject("left")) {
                GolbalUse.pointX -= GolbalUse.speed;
            }
        }
        if (isPressed('S')) {
            mainCharacter.setDir(4);
            // check collision
            if (!checkCollision("down") && !checkCollisionObject("down")) {
                GolbalUse.pointY += GolbalUse.speed;
            }
        }
        if (isPressed('D')) {
            mainCharacter.setDir(1);
            // check collision
            if (!checkCollision("right") && !checkCollisionObject("right")) {
                GolbalUse.pointX += GolbalUse.speed;
            }
        }

        if (isPressed('W') || isPressed('A') || isPressed('S') || isPressed('D')) {
            if (mainCharacter.getStage() >= 15) {
                mainCharacter.setStage(1);
            } else {
                mainCharacter.setStage(mainCharacter.getStage() + 1);
            }
        }

        //redraw background
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                int worldX = j * 32;
                int worldY = i * 32;
                int screenX = worldX - GolbalUse.pointX + mainScreenX;
                int screenY = worldY - GolbalUse.pointY + mainScreenY;

                //công thức tính toán sao chỉ vẽ map ở những chỗ mình nhìn thấy
                if (worldX + 32 > GolbalUse.pointX - mainScreenX &&
                        worldX - 32 < GolbalUse.pointX + mainScreenX &&
                        worldY + 32 > GolbalUse.pointY - mainScreenY &&
                        worldY - 32 < GolbalUse.pointY + mainScreenY) {
                    if (GolbalUse.grid[i][j].wall) {
                        gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Resource[GolbalUse.IMG_WALL]), screenX, screenY);
                    }
                    if (GolbalUse.grid[i][j].floor) {
                        gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Resource[GolbalUse.IMG_FLOOR]), screenX, screenY);
                    }
                    if (GolbalUse.grid[i][j].black) {
                        gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Resource[GolbalUse.IMG_BLACK]), screenX, screenY);
                    }
                    if (GolbalUse.grid[i][j].home_floor) {
                        gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Resource[GolbalUse.IMG_HOME_FLOOR]), screenX, screenY);
                    }
                    if (GolbalUse.grid[i][j].home_wall) {
                        gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Resource[GolbalUse.IMG_HOME_WALL]), screenX, screenY);
                    }
                }
            }
        }


        //redraw object
        for (int i = 0; i < GolbalUse.gridObj.length; i++) {
            if (GolbalUse.gridObj[i] != null) {
                int screenX = GolbalUse.gridObj[i].pointX - GolbalUse.pointX + mainScreenX;
                int screenY = GolbalUse.gridObj[i].pointY - GolbalUse.pointY + mainScreenY;
//                if (GolbalUse.gridObj[i].name.equals("HOME_DOWN_STAIR")) {
//                    screenX += 2;
//                    screenY -= 4;
//                }
//                if (GolbalUse.gridObj[i].name.equals("HOME_CHAIR")) {
//                    screenY += 6;
//                }
                gc.drawImage(GolbalUse.convertToFxImage(GolbalUse.gridObj[i].image), screenX, screenY);
            }
        }


        //redraw character
        switch (mainCharacter.getDir()) {
            case 1:
                if (mainCharacter.getStage() >= 1 && mainCharacter.getStage() <= 4) {
                    gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Character_Resource[GolbalUse.IMG_CHARACTER_1_1]), mainScreenX, mainScreenY);
                } else if (mainCharacter.getStage() >= 5 && mainCharacter.getStage() <= 9) {
                    gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Character_Resource[GolbalUse.IMG_CHARACTER_1_2]), mainScreenX, mainScreenY);
                } else if (mainCharacter.getStage() >= 10 && mainCharacter.getStage() <= 15) {
                    gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Character_Resource[GolbalUse.IMG_CHARACTER_1_3]), mainScreenX, mainScreenY);
                }
                break;
            case 2:
                if (mainCharacter.getStage() >= 1 && mainCharacter.getStage() <= 4) {
                    gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Character_Resource[GolbalUse.IMG_CHARACTER_2_1]), mainScreenX, mainScreenY);
                } else if (mainCharacter.getStage() >= 5 && mainCharacter.getStage() <= 9) {
                    gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Character_Resource[GolbalUse.IMG_CHARACTER_2_2]), mainScreenX, mainScreenY);
                } else if (mainCharacter.getStage() >= 10 && mainCharacter.getStage() <= 15) {
                    gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Character_Resource[GolbalUse.IMG_CHARACTER_2_3]), mainScreenX, mainScreenY);
                }
                break;
            case 3:
                if (mainCharacter.getStage() >= 1 && mainCharacter.getStage() <= 4) {
                    gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Character_Resource[GolbalUse.IMG_CHARACTER_3_1]), mainScreenX, mainScreenY);
                } else if (mainCharacter.getStage() >= 5 && mainCharacter.getStage() <= 9) {
                    gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Character_Resource[GolbalUse.IMG_CHARACTER_3_2]), mainScreenX, mainScreenY);
                } else if (mainCharacter.getStage() >= 10 && mainCharacter.getStage() <= 15) {
                    gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Character_Resource[GolbalUse.IMG_CHARACTER_3_3]), mainScreenX, mainScreenY);
                }
                break;
            case 4:
                if (mainCharacter.getStage() >= 1 && mainCharacter.getStage() <= 4) {
                    gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Character_Resource[GolbalUse.IMG_CHARACTER_4_1]), mainScreenX, mainScreenY);
                } else if (mainCharacter.getStage() >= 5 && mainCharacter.getStage() <= 9) {
                    gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Character_Resource[GolbalUse.IMG_CHARACTER_4_2]), mainScreenX, mainScreenY);
                } else if (mainCharacter.getStage() >= 10 && mainCharacter.getStage() <= 15) {
                    gc.drawImage(GolbalUse.convertToFxImage(imagesResource.IMG_Character_Resource[GolbalUse.IMG_CHARACTER_4_3]), mainScreenX, mainScreenY);
                }
                break;
            default:
                break;
        }
    }

    public static boolean isPressed(char c) {
        return currentlyPressedKeys.contains(c);
    }


    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {

        // khởi tạo các biến tài nguyên
        ImagesResource imagesResource = new ImagesResource();
        MainCharacter mainCharacter = new MainCharacter();
        MapReader mapReader = new MapReader(imagesResource);
        //init map
        mapReader.initMap();
        //init map object
        mapReader.initMapObject();

        // khởi tạo canvas
        final Canvas canvas = new Canvas(witdhX, heightY);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        reDraw(gc, imagesResource, mainCharacter);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(canvas);
        Scene scene = new Scene(anchorPane, witdhX, heightY);
        scene.addEventFilter(KeyEvent.KEY_RELEASED, key -> {
            currentlyPressedKeys.remove(key.getCode().toString().charAt(0));
            currentlyPressedKeyCodes.remove(key.getCode().getCode());
        });
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            currentlyPressedKeys.add(key.getCode().toString().charAt(0));
            currentlyPressedKeyCodes.add(key.getCode().getCode());
            wasPressedKeys.add(key.getCode().toString().charAt(0));
        });

        new AnimationTimer() {
            final double drawInterval = 1000000000 / 60;
            double delta = 0;
            long lastTime = System.nanoTime();
            long timer = 0;
            long currrentTime;
            int drawCount = 0;

            @Override
            public void handle(long now) {

                currrentTime = System.nanoTime();
                delta += (currrentTime - lastTime) / drawInterval;
                timer += (currrentTime - lastTime);
                lastTime = currrentTime;

                if (delta >= 1) {
                    reDraw(gc, imagesResource, mainCharacter);
                    delta--;
                    drawCount++;
                }

                if (timer >= 1000000000) {
                    //System.out.println("FPS:" + drawCount);
                    drawCount = 0;
                    timer = 0;
                }

            }
        }.start();


        //show stage
        stage.setTitle("GameRPG");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}