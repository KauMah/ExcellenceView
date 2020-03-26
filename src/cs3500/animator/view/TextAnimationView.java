package cs3500.animator.view;

import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationModel;

/**
 * Public class for the text animation view.
 */
public class TextAnimationView {

  private ExcellenceAnimationModel eA;

  /**
   * Public constructor for the test animation view.
   *
   * @param eA the model.
   */
  public TextAnimationView(ExcellenceAnimationModel eA) {
    this.eA = eA;
  }

  @Override
  public String toString() {
    return eA.toString();
  }
}
