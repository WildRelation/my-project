package se.kth.jpsa2.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends FillableShape {
    private double diameter;

    public Circle(double x, double y, double diameter, Color color, boolean filled) {
        super(x, y, color, filled);
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public void paint(GraphicsContext gc) {
        gc.setFill(getColor());
        gc.setStroke(getColor());

        if (isFilled()) {
            gc.fillOval(getX(), getY(), diameter, diameter);
        } else {
            gc.strokeOval(getX(), getY(), diameter, diameter);
        }
    }

    @Override
    protected void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY, boxWidth, boxHeight);

        // Hantera x-axeln
        if (getX() < boxX) {
            setX(boxX);
            setDx(Math.abs(getDx()));
        } else if (getX() + diameter > boxWidth) {
            setX(boxWidth - diameter);
            setDx(-Math.abs(getDx()));
        }

        // Hantera y-axeln
        if (getY() < boxY) {
            setY(boxY);
            setDy(Math.abs(getDy()));
        } else if (getY() + diameter > boxHeight) {
            setY(boxHeight - diameter);
            setDy(-Math.abs(getDy()));
        }
    }


    @Override
    public String toString() {
        return super.toString() + ", diameter=" + diameter;
    }
}
