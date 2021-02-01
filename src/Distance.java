import java.awt.*;

public class Distance {
    public static double calculate(Point p1, Point p2){
        //Distance formula:
        //d = Square root of x2-x1 (to the power of 2) + y2-y1 (to the power of 2)
        double xPower = Math.pow(p2.x - p1.x, 2);
        double yPower = Math.pow(p2.y - p1.y, 2);

        return Math.sqrt(xPower + yPower);
    }
}
