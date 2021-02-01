import javax.swing.*;

public class ImageFrame extends JFrame {
    public static final int DEFAULT_WIDTH = 1000;
    public static final int DEFAULT_HEIGHT = 1000;
    ImageComponent imageComponent = new ImageComponent();

    public ImageFrame() {
        setResizable(false);
        setTitle("Pixel Player");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null); //Makes the window "spawn" in the middle of the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        //Create ImageComponent and add to ImageFrame
        add(imageComponent);
        imageComponent.setBounds(0,0, DEFAULT_WIDTH, DEFAULT_HEIGHT);

        setVisible(true);
    }
}