package pixels;

import java.awt.*;

public class Water extends Pixel{
    public Color color = new Color(0,255,255);

    public Water(int x, int y) {
        super(x,y,false,1);
    }

    @Override
    public void update (Pixel[][] pixels) {
        //check max y bounds
        if (!(y + 1 == pixels[0].length)){
            //can I move down?
            if (pixels[x][y+1] == null){
                pixels[x][y+1] = pixels[x][y];
                pixels[x][y] = null;
                pixels[x][y+1].setHasMoved(true);

                y++;
            }
            //can I move down and to the left?
            else if (x-1 >= 0 && pixels[x-1][y+1] == null){
                pixels[x-1][y+1] = pixels[x][y];
                pixels[x][y] = null;
                pixels[x-1][y+1].setHasMoved(true);

                x--;
                y++;
            }
            //can I move down and to my right?
            else if (x+1 != pixels.length && pixels[x+1][y+1] == null) {
                pixels[x+1][y+1] = pixels[x][y];
                pixels[x][y] = null;
                pixels[x+1][y+1].setHasMoved(true);

                x++;
                y++;
            }
            //can I move to the left?
            else if (x-1 >= 0 && pixels[x-1][y] == null) {
                pixels[x-1][y] = pixels[x][y];
                pixels[x][y] = null;
                pixels[x-1][y].setHasMoved(true);

                x--;
            }
            //can I move to the right?
            else if (x+1 != pixels.length && pixels[x+1][y] == null) {
                pixels[x+1][y] = pixels[x][y];
                pixels[x][y] = null;
                pixels[x+1][y].setHasMoved(true);

                x++;
            }
        }
    }

    public int getColor() {
        return color.getRGB();
    }
}
