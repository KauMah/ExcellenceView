package cs3500.animator.controller;

import cs3500.animator.view.AnimationView;
import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationOperations;

public interface IController {

  void run(AnimationView view, ExcellenceAnimationOperations model, int tempo);
}
