package cs3500.animator.controller;

import cs3500.animator.view.AnimationView;
import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Class for the animation controller.
 */
public class AnimationController implements ControllerType, ActionListener {

  public AnimationController() {
    //empty constructor
  }

  @Override
  public ExcellenceAnimationModel getModel() {
    return null;
  }

  @Override
  public AnimationView getView() {
    return null;
  }

  @Override
  public void run(Appendable file) throws IOException {
    //TODO: implement.
  }

  @Override
  public int getSpeed() {
    return 0;
  }

  @Override
  public void setAddShapeId(String text) {
    //TODO: figure out what this does
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
  public void displayError(String text) {
    //empty
  }

  @Override
  public void removeShape(String shapeId) {
    //empty
  }

  @Override
  public void setSpeed(String speed) {
    //empty
  }

  @Override
  public void setTick(int tick) {
    //empty
  }

  @Override
  public int getTick() {
    return 0;
  }

  @Override
  public void addKeyframe(String a, String b, String c, String d, String e, int f) {
    //empty
  }

  @Override
  public void replaceKeyframe(String a, String b, String c, String d, String e, int f) {
    //empty
  }

  @Override
  public void removeKeyframe(String text, int tick) {
    //empty
  }

  @Override
  public void pause() {
    //pause
  }
}
