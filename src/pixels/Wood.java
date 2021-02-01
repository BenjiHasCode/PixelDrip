package pixels;

import java.awt.*;

public class Wood extends Pixel{
    public static Color color = new Color(150,90,60);

    public Wood (int x, int y) {
        super(x,y,true, 10);
        stable = true;
    }

    public int getColor(){
        return color.getRGB();
    }
}