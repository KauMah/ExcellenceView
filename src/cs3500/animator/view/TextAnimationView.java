package cs3500.animator.view;

import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationModel;

public class TextAnimationView {
  private ExcellenceAnimationModel eA;

  public TextAnimationView(ExcellenceAnimationModel eA) {
    this.eA =  eA;
  }

  @Override
  public String toString() {
    return eA.toString();
  }
}
