package cs3500.animator.otherview;

import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationOperations;
import cs3500.excellence.model.shapeanimation.ShapeAnimationOperations;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.List;
import javax.swing.JPanel;

/**
 * The panel for the animation, which draws the shapes.
 */
public class AnimationPanel extends JPanel {

  private final ExcellenceAnimationOperations model;

  /**
   * Constructs the panel from a read-only model.
   *
   * @param model the model
   */
  public AnimationPanel(ExcellenceAnimationOperations model) {
    super();
    this.model = model;
    this.setBackground(Color.WHITE);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;

    g2d.setColor(Color.BLACK);
    List<ShapeAnimationOperations> shapes = this.model.getShapeAnimations();
    for (ShapeAnimationOperations s : shapes) {
      if (s.isInvisible()) {
        continue;
      }
      java.awt.Shape shape = s.isOval() ? new Ellipse2D.Double(s.getCurrentPosition().getX(),
          s.getCurrentPosition().getY(),
          s.getCurrentDimensions().getWidth(), s.getCurrentDimensions().getHeight())
          : new Rectangle.Double(s.getCurrentPosition().getX(),
              s.getCurrentPosition().getY(),
              s.getCurrentDimensions().getWidth(), s.getCurrentDimensions().getWidth());
      g2d.setColor(new Color(s.getCurrentColor().getRed(), s.getCurrentColor().getGreen(),
          s.getCurrentColor().getBlue()));

      g2d.fill(shape);
    }

    AffineTransform originalTransform = g2d.getTransform();

    g2d.translate(0, this.getPreferredSize().getHeight());
    g2d.scale(1, -1);
    g2d.setTransform(originalTransform);
  }
}
