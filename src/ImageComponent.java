import pixels.Sand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class ImageComponent extends JComponent {
    private final int imageWidth = 300;
    private final int imageHeight = 300;
    BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);


    public ImageComponent(){
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                Mouse.point = translatePoint(e.getPoint());

                switch (e.getButton()) {
                    case 1:
                        Mouse.leftClicked = true;
                        break;
                    case 2:
                        Mouse.middleClicked = true;
                        break;
                    case 3:
                        Mouse.rightClicked = true;
                        break;
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point point = translatePoint(e.getPoint());
                if(point.x >= 0 && point.x < imageWidth && point.y >= 0 && point.y < imageHeight){
                    Mouse.point = point;
                }
            }
            @Override
            public void mouseReleased(MouseEvent e){
                switch (e.getButton()) {
                    case 1:
                        Mouse.leftClicked = false;
                        break;
                    case 2:
                        Mouse.middleClicked = false;
                        break;
                    case 3:
                        Mouse.rightClicked = false;
                        break;
                }
            }
        };

        deleteImage();

        //adding our mouseadapter as listeners to the frame. Allows the frame to use the listener.
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    public void paintComponent (Graphics g){
        g.drawImage(image, 0, 0, ImageFrame.DEFAULT_WIDTH-15, ImageFrame.DEFAULT_HEIGHT-37, this);
    }

    public void drawScene(){
        deleteImage();
        for (int x = 0; x < World.pixels.length; x++) {
            for (int y = 0; y < World.pixels[0].length; y++) {
                if(World.pixels[x][y] != null){
                    image.setRGB(x,y, World.pixels[x][y].getColor());
                }else {
                    image.setRGB(x, y, new Color(100,100,100).getRGB());
                }
            }
        }
    }

    //takes point finds how big the frame is percent wise
    //and translate it to a point that would fit within the component.
    //returns translated point
    public Point translatePoint(Point point){
        double widthDif = (double) (ImageFrame.DEFAULT_WIDTH - imageWidth) / imageWidth;
        double heightDif = (double) (ImageFrame.DEFAULT_HEIGHT - imageHeight) / imageHeight;

        //create new point new coordinates
        int x = (int) (point.x/(widthDif + 1));
        int y = (int) (point.y/(heightDif + 1));

        return new Point(x, y);
    }

    public void deleteImage(){
        for(int i = 0; i < imageWidth; i++){
            for(int j = 0; j < imageHeight; j++){
           //     image.setRGB(i, j, new Color(255, 255, 255).getRGB());

            }
        }
    }

    public int getImageWidth(){
        return imageWidth;
    }

    public int getImageHeight() {
        return  imageHeight;
    }
}