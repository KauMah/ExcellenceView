package cs3500.excellence.model;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * Interface for a keyframe. A keyframe is a set of characteristics for a shape that can be added to
 * the animaton.
 */
public interface IKeyframe {

  /**
   * Returns the tick of the keyframe.
   *
   * @return integer vale for tick.
   */
  int getTick();

  /**
   * width of the shape in the keyframe.
   *
   * @return integer value for width.
   */
  int getWidth();

  /**
   * position of the shape in the keyframe.
   *
   * @return Point2D value for the shape.
   */
  Point2D getPosition();

  /**
   * Color of the shape in the keyframe.
   *
   * @return color of shape.
   */
  Color getColor();

  /**
   * Height of the shape in the keyframe.
   *
   * @return integer value for height of shape.
   */
  int getHeight();
}
