package se.kth.jpsa2.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends FillableShape {
    private double width, height;

    public Rectangle(double x, double y, double width, double height, Color color, boolean filled) {
        super(x, y, color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void paint(GraphicsContext gc) {
        gc.setFill(getColor());
        gc.setStroke(getColor());

        if (isFilled()) {
            gc.fillRect(getX(), getY(), width, height);
        } else {
            gc.strokeRect(getX(), getY(), width, height);
        }
    }

    @Override
    protected void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        super.constrain(boxX, boxY, boxWidth, boxHeight);

        // Hantera x-axeln
        if (getX() < boxX) {
            setX(boxX);
            setDx(Math.abs(getDx()));
        } else if (getX() + width > boxWidth) {
            setX(boxWidth - width);
            setDx(-Math.abs(getDx()));
        }

        // Hantera y-axeln
        if (getY() < boxY) {
            setY(boxY);
            setDy(Math.abs(getDy()));
        } else if (getY() + height > boxHeight) {
            setY(boxHeight - height);
            setDy(-Math.abs(getDy()));
        }
    }


    @Override
    public String toString() {
        return super.toString() + ", width=" + width + ", height=" + height;
    }
}
