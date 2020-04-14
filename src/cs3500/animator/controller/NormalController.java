package cs3500.animator.controller;

import cs3500.animator.view.AnimationView;
import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationModel;
import java.io.IOException;

public class NormalController implements ControllerType {
  ExcellenceAnimationModel model;
  AnimationView view;

  public NormalController(ExcellenceAnimationModel model, AnimationView view) {
    this.model = model;
    this.view = view;
  }

  public ExcellenceAnimationModel getModel() {
    return model;
  }

  @Override
  public AnimationView getView() {
    return view;
  }

  @Override
  public void run(Appendable file) throws IOException {
    view.display(file);
  }


}
