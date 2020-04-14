package cs3500.animator.controller;

import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationModel;
import java.io.IOException;

public interface ControllerType {

  /**
   * Gets the model which contains the necessary operations for the shapes.
   * @return an ExcellenceAnimationModel
   */
  public ExcellenceAnimationModel getModel();
}
