package cs3500.animator.controller;

import cs3500.animator.view.AnimationView;
import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationModel;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class NormalController implements ControllerType {

  ExcellenceAnimationModel model;
  AnimationView view;
  private int tick;

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

  @Override
  public int getSpeed() {
    return 0;
  }

  @Override
  public void setAddShapeId(String text) {

  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

  @Override
  public void displayError(String text) {
    throw new IllegalArgumentException(text);
  }

  @Override
  public void removeShape(String shapeId) {
    model.removeShape(shapeId);
  }

  @Override
  public void setSpeed(String speed) {
    model.setTempo(Integer.parseInt(speed));
  }

  @Override
  public void setTick(int tick) {
    this.tick = tick;
  }

  @Override
  public int getTick() {
    return tick;
  }

  @Override
  public void addKeyframe(String objectId, String color, String position, String width,
      String height, int tick) {

  }

  @Override
  public void replaceKeyframe(String a, String b, String c, String d, String e, int f) {

  }

  @Override
  public void removeKeyframe(String text, int tick) {

  }

  @Override
  public void pause() {

  }


}
