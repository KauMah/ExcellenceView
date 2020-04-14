package cs3500.animator.controller;

import cs3500.animator.view.AnimationView;
import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationOperations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationController implements ActionListener, IController {

  public AnimationController() {

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "beg":
        break;
      case "rew":
        break;
      case "pausePlay":
        break;
      case "ffw":
        break;
      case "end":
        break;
      case "repeat":
        break;
      default:
    }
  }

  @Override
  public void run(AnimationView view, ExcellenceAnimationOperations model, int tempo) {
    if (view == null) {
      throw new IllegalArgumentException("View cannot be null");
    }
    if (model == null) {
      throw new IllegalArgumentException("model cannot be null");
    }
    if (tempo < 1) {
      throw new IllegalArgumentException("tempo must be greater than 1");
    }

    view.display();
  }
}
