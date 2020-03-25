package cs3500.animator.view;

import cs3500.excellence.model.shapeanimation.Shape;
import cs3500.excellence.model.shapeanimation.Shape.shapeType;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfigTemplate;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.text.Position;

public class AnimationPanel extends JPanel {

  private List<Shape> shapes;

  public AnimationPanel(List<Shape> shapes) {
    super();
    this.shapes = shapes;
    this.setBackground(Color.WHITE);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    g2d.setColor(Color.BLACK);

    AffineTransform originalTransform = g2d.getTransform();

    for (Shape s : shapes) {
      Point2D p = s.getPosition();
      Color c = s.getColor();
      Dimension2D d = s.getDimensions();
      g2d.setColor(c);
      if(s.getType() == shapeType.OVAL) {
        g2d.fillOval((int)p.getX(), (int)p.getY(), (int)d.getWidth(), (int)d.getHeight());
        g2d.drawOval((int)p.getX(), (int)p.getY(), (int)d.getWidth(), (int)d.getHeight());
      } else if (s.getType() == shapeType.RECTANGLE) {
        g2d.fillRect((int)p.getX(), (int)p.getY(), (int)d.getWidth(), (int)d.getHeight());
        g2d.drawRect((int)p.getX(), (int)p.getY(), (int)d.getWidth(), (int)d.getHeight());
      } else {
        throw new IllegalArgumentException("Invalid shape type");
      }
    }

    g2d.setTransform(originalTransform);

  }

  public void setShapes(List<Shape> shapes) {
    this.shapes = shapes;
  }


}
