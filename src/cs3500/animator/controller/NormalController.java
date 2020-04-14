package cs3500.animator.controller;

import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationModel;
import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationOperations;

public class NormalController implements ControllerType {
  ExcellenceAnimationModel model;

  public NormalController(ExcellenceAnimationModel model) {
    this.model = model;
  }

  public ExcellenceAnimationModel getModel() {
    return model;
  }
}
