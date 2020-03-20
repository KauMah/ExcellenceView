package cs3500.excellence.model.shapeanimation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

/**
 * An enumeration to represent different expected shapes in the ShapeAnimationModel class.
 */
public class Shape {

  /**
   * An enumeration to describe the type of shape to be drawn
   */
  public enum shapeType {
    RECTANGLE {
      @Override
      public String toString() {
        return "Rectangle";
      }
    }, OVAL {
      @Override
      public String toString() {
        return "Oval";
      }
    }
  }

  private shapeType type;
  private Color color;
  private Dimension2D dimensions;
  private Point2D position;

  /**
   * Constructs a Shape object given the color, size, and position parameters.
   *
   * @param red     the intensity of red in the color
   * @param green   the intensity of green in the color
   * @param blue    the intensity of blue in the color
   * @param width   the overall width of the shape
   * @param height  the overall height of the shape
   * @param x       the x-coordinate of the position
   * @param y       the y-coordinate of the position
   * @param type    an enum determining the type of shape as a shapeType
   */
  public Shape(int red, int green, int blue, int width, int height, int x, int y, shapeType type) {
    this.color = new Color(red, green, blue);
    this.dimensions = new Dimension(width, height);
    this.position = new Point(x, y);
    this.type = type;
  }

  /**
   * Returns the color of the shape.
   * @return a color object representing the color of the shape
   */
  public Color getColor() {
    return color;
  }

  /**
   * Returns the overall two dimensional size of the shape.
   * @return a Dimension2D object with an x and y component
   */
  public Dimension2D getDimensions() {
    return dimensions;
  }

  /**
   * Returns the position of an object in 2D space.
   * @return a Point2D object with an x and y component
   */
  public Point2D getPosition() {
    return position;
  }

  /**
   * Sets the color of the shape.
   * @param red   the red value of the color
   * @param green the green value of the color
   * @param blue  the blue value of the color
   */
  public void setColor(int red, int green, int blue) {
    this.color = new Color(color.getRed() + red, color.getGreen() + green,
        color.getBlue() + blue);

  }

  /**
   * Sets the dimensions of the shape.
   * @param width   the width of the shape
   * @param height  the height of the shape
   */
  public void setDimensions(int width, int height) {
    this.dimensions = new Dimension((int) dimensions.getWidth() + width,
        (int) dimensions.getHeight() + height);
  }

  /**
   * Sets the position of the shape in 2D space.
   * @param x the x-coordinate of the shape
   * @param y the y-coordinate of the shape
   */
  public void setPosition(int x, int y) {
    this.position = new Point((int) position.getX() + x, (int) position.getY() + y);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof Shape)) {
      return false;
    }

    Shape s = (Shape) obj;

    return s.type == this.type && s.color.equals(this.color) && this.position.equals(s.position)
        && this.dimensions.equals(s.dimensions);
  }

  @Override
  public String toString() {
    return type.toString();
  }
}
