package cs3500.animator.view;

import cs3500.animator.controller.ControllerType;
import java.io.IOException;

public interface AnimationView {

  /**
   * Sets the controller for the view.
   */
  void setController(ControllerType c);

  /**
   * Display this view.
   *
   * @throws IOException if file is null
   */
  void display(Appendable file) throws IOException;
}
