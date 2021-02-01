import pixels.Pixel;

public class World {
    public static Pixel[][] pixels;

    public World(int x, int y){
        pixels = new Pixel[x][y];
    }


    public void update() {
        for (int x = 0; x < pixels.length; x++) {
            for (int y = pixels[0].length - 1; y >= 0; y--) {
                if (pixels[x][y] != null && !pixels[x][y].stable && !pixels[x][y].hasMoved()) {
                    pixels[x][y].update(pixels);
                }
            }
        }
        resetMovedBoolean();
    }

    private void resetMovedBoolean() {
        for (int x = 0; x < pixels.length; x++) {
            for (int y = pixels[0].length - 1; y >= 0; y--) {
                if (pixels[x][y] != null && !pixels[x][y].stable) {
                    pixels[x][y].setHasMoved(false);
                }
            }
        }
    }
}
