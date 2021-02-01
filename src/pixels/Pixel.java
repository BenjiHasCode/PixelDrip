package pixels;

public class Pixel {
    public boolean stable;
    protected int x,y;
    protected boolean hasMoved;
    protected int weight;

    public Pixel (int x, int y, boolean stable, int weight) {
        this.stable = stable;
        hasMoved = false;
        this.x = x;
        this.y = y;
        this.weight = weight;
    }

    public int getColor(){
        return 0;
    }

   /* public void update (Pixel[][] pixels) {
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
            }else {
                //pixels[x][y-1].stable = true;
                //WHAT IF IT HAS TO MOVE LATER?
            }
        }
    }*/

    public void update (Pixel[][] pixels) {
        //can I move down?
        if (!(y+1 == pixels[0].length) && pixels[x][y+1] == null) {
            pixels[x][y+1] = pixels[x][y];
            pixels[x][y] = null;
            pixels[x][y+1].setHasMoved(true);

            y++;
        }else if (!(y+1 == pixels[0].length) && pixels[x][y] != null && pixels[x][y+1] != null && pixels[x][y].weight > pixels[x][y+1].weight) {
            Pixel pTemp = pixels[x][y+1];
            pixels[x][y+1] = pixels[x][y];
            pixels[x][y] = pTemp;
            pixels[x][y+1].setHasMoved(true);

            y++;
        }
        //can I move down to the left?
       // else if () {

      //  }
        //can I move down to the right?
        //else if () {

        //}

    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public boolean hasMoved(){
        return hasMoved;
    }
}
