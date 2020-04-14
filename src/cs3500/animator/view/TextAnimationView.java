package cs3500.animator.view;

import cs3500.animator.controller.ControllerType;
import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationModel;
import java.io.IOException;

/**
 * Public class for the text animation view.
 */
public class TextAnimationView implements AnimationView{
  private ControllerType controller;


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

  @Override
  public void setController(ControllerType c) {
    this.controller = c;
  }

  @Override
  public void display(Appendable file) {
    if (file == null) {
      throw new IllegalArgumentException("Output file is null");
    }
    try {
      file.append(this.controller.getModel().toString());
    } catch(IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
