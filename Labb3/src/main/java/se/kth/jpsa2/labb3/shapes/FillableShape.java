package se.kth.jpsa2.labb3.shapes;

import javafx.scene.paint.Color;

public abstract class FillableShape extends Shape {
    protected boolean filled;

    public FillableShape(double x, double y, Color color, boolean filled) {
        super(x, y, color);
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return super.toString() + ", filled=" + filled;
    }
}
