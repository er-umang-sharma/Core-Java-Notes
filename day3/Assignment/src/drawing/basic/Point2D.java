package drawing.basic;

public class Point2D {

    private double x, y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public boolean isEqual(Point2D point) {
        if (this.x == point.x && this.y == point.y)
            return true;
        return false;
    }

    public Point2D createNewPoint(double xOffSet, double yOffSet) {
        return new Point2D(this.x + xOffSet, this.y + yOffSet);
    }

    public double calcDistance(Point2D point) {
        return Math.sqrt(Math.pow((this.x - point.x), 2) + Math.pow((this.y - point.y), 2));
    }
}
