package cs3500.excellence.model;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * Class represnting a keyframe that implements the IKeyframe interface.
 * Represents a set of characteristic at a keyframe.
 */
public class Keyframe implements IKeyframe {

  private final int tick;
  private final int width;
  private final int height;
  private final Point2D position;
  private final Color color;

  public Keyframe(int tick) {
    this.tick = tick;
    //logiv to get height, color, width, position at this tick
  }

  @Override
  public int getTick() {
    return tick;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public Point2D getPosition() {
    return position;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public int getHeight() {
    return height;
  }
}
