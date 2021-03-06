package cs3500.animator.controller;

import cs3500.animator.view.AnimationView;
import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * interface for the controller.
 */
public interface ControllerType extends ActionListener {

  /**
   * Gets the model which contains the necessary operations for the shapes.
   *
   * @return an ExcellenceAnimationModel
   */
  ExcellenceAnimationModel getModel();

  AnimationView getView();

  void run(Appendable file) throws IOException;

  int getSpeed();

  void setAddShapeId(String text);

  void actionPerformed(ActionEvent e);

  void displayError(String text);

  void removeShape(String shapeId);

  void setSpeed(String speed);

  void setTick(int tick);

  int getTick();

  void addKeyframe(String a, String b, String c, String d, String e, int f);

  void replaceKeyframe(String a, String b, String c, String d, String e, int f);

  void removeKeyframe(String text, int tick);

  void pause();

}
