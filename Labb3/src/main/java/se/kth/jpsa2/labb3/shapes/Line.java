package se.kth.jpsa2.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape{

    private double x2, y2;

    public Line(double x, double y, double x2, double y2, Color color) {
        super(x, y ,color);
        this.x2 = x2;
        this.y2 = y2;
    }

    public Line(){
        super();
        this.x2 = 100;
        this.y2 = 100;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    @Override
    public void move(long elapsedTimeNs) {
        super.move(elapsedTimeNs);
        x2 += getDx() * elapsedTimeNs / BILLION;
        y2 += getDy() * elapsedTimeNs / BILLION;
    }

    @Override
    public void paint(GraphicsContext gc) {
        gc.setStroke(getColor());
        gc.strokeLine (getX(), getY() , x2, y2);
    }

    @Override
    protected void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        // Hantera x och y (från Shape)
        super.constrain(boxX, boxY, boxWidth, boxHeight);

        // Hantera x2
        if (x2 < boxX) {
            setDx(Math.abs(getDx()));
        } else if (x2 > boxWidth) {
            setDx(-Math.abs(getDx()));
        }

        // Hantera y2
        if (y2 < boxY) {
            setDy(Math.abs(getDy()));
        } else if (y2 > boxHeight) {
            setDy(-Math.abs(getDy()));
        }
    }



    @Override
    public String toString() {
        return super.toString() +
                ", x2=" + x2 +
                ", y2=" + y2;
    }
}
