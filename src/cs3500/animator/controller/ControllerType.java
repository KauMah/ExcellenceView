package cs3500.animator.controller;

import cs3500.animator.view.AnimationView;
import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationModel;
import cs3500.excellence.model.shapeanimation.Shape;
import java.awt.event.ActionEvent;
import java.io.IOException;

public interface ControllerType {

  /**
   * Gets the model which contains the necessary operations for the shapes.
   * @return an ExcellenceAnimationModel
   */
  public ExcellenceAnimationModel getModel();

  public AnimationView getView();

  void run(Appendable file) throws IOException;

  double getSpeed();
  void setAddShapeId();

  void actionPerformed(ActionEvent e);

  void displayError(String text);

  void removeShape(Shape s);

  void setSpeed(double speed);

  void setTick(int tick);

  int getTick();


}
