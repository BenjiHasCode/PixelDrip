package pixels;

import java.awt.*;

public class Sand extends Pixel{
    public static Color color = new Color(255,200,0);

    public Sand (int x, int y) {
        super(x, y, false, 2);
    }

    public int getColor(){
        return color.getRGB();
    }
}
