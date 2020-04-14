package cs3500.excellence.model;

import java.awt.Color;
import java.awt.geom.Point2D;

public interface IKeyframe {

  int getTick();

  int getWidth();

  Point2D getPosition();

  Color getColor();

  int getHeight();
}
