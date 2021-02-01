import pixels.Sand;
import pixels.Water;
import pixels.Wood;

import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //initialize frame
        ImageFrame pixelFrame = new ImageFrame();

        //initialize array containing
        World world = new World(pixelFrame.imageComponent.getImageWidth(), pixelFrame.imageComponent.getImageHeight());


        while(true){
            int inDistanceOf = 10;

            if (Mouse.leftClicked && Mouse.point != null){
                for(int i = Mouse.point.x-inDistanceOf; i < Mouse.point.x+inDistanceOf; i++){
                    for(int j = Mouse.point.y-inDistanceOf; j < Mouse.point.y+inDistanceOf; j++){
                        //check if x and why are with in acceptable bounds
                        if(i >= 0 && i < World.pixels.length && j >= 0 && j < World.pixels[0].length){
                            double distance = Distance.calculate(new Point(i,j), Mouse.point);
                            if(distance <= inDistanceOf-1){
                                World.pixels[i][j] = new Sand(i,j);
                            }
                        }
                    }
                }
            } else if (Mouse.rightClicked && Mouse.point != null){
                for(int i = Mouse.point.x-inDistanceOf; i < Mouse.point.x+inDistanceOf; i++){
                    for(int j = Mouse.point.y-inDistanceOf; j < Mouse.point.y+inDistanceOf; j++){
                        //check if x and why are with in acceptable bounds
                        if(i >= 0 && i < World.pixels.length && j >= 0 && j < World.pixels[0].length){
                            double distance = Distance.calculate(new Point(i,j), Mouse.point);
                            if(distance <= inDistanceOf-1){
                                World.pixels[i][j] = new Water(i,j);
                            }
                        }
                    }
                }
            } else if (Mouse.middleClicked && Mouse.point != null){
                for(int i = Mouse.point.x-inDistanceOf; i < Mouse.point.x+inDistanceOf; i++){
                    for(int j = Mouse.point.y-inDistanceOf; j < Mouse.point.y+inDistanceOf; j++){
                        //check if x and why are with in acceptable bounds
                        if(i >= 0 && i < World.pixels.length && j >= 0 && j < World.pixels[0].length){
                            double distance = Distance.calculate(new Point(i,j), Mouse.point);
                            if(distance <= inDistanceOf-1){
                                World.pixels[i][j] = new Wood(i,j);
                            }
                        }
                    }
                }
            }

            //update world
            world.update();
            //paint image
            pixelFrame.imageComponent.drawScene();
            //repaint frame (so we can see the new image)
            pixelFrame.repaint();


            Thread.sleep(1);
        }
    }
}
