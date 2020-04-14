package cs3500.animator.controller;

import cs3500.animator.view.AnimationView;
import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationModel;
import cs3500.excellence.model.shapeanimation.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public interface ControllerType extends ActionListener {

  /**
   * Gets the model which contains the necessary operations for the shapes.
   * @return an ExcellenceAnimationModel
   */
  public ExcellenceAnimationModel getModel();

  public AnimationView getView();

  void run(Appendable file) throws IOException;

  int getSpeed();

  void setAddShapeId(String text);

  void actionPerformed(ActionEvent e);

  void displayError(String text);

  void removeShape(String shapeId);

  void setSpeed(String objectId);

  void setTick(int tick);

  int getTick();

  void addKeyframe(String a, String b, String c, String d, String e, int f);

  void replaceKeyframe(String a, String b, String c, String d, String e, int f);

  void removeKeyframe(String text, int tick);

  void pause();

}
