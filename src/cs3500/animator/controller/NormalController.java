package cs3500.animator.controller;

import cs3500.animator.view.AnimationView;
import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationModel;
import cs3500.excellence.model.shapeanimation.Shape;
import java.awt.event.ActionEvent;
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

  @Override
  public double getSpeed() {
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

  }

  @Override
  public void removeShape(String shapeId) {

  }

  @Override
  public void setSpeed(String objectId) {

  }

  @Override
  public void setTick(int tick) {

  }

  @Override
  public int getTick() {
    return 0;
  }


}
