package cs3500.animator.view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public interface AnimationView {
  /**
   * Set the listener for any actions.
   */
  void setListener(ActionListener listener);

  /**
   * Display this view.
   */
  void display();
}
