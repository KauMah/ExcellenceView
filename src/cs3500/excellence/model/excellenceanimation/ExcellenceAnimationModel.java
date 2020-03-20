package cs3500.excellence.model.excellenceanimation;

import cs3500.excellence.model.shapeanimation.ShapeAnimationModel;
import cs3500.excellence.model.shapeanimation.ShapeAnimationOperations;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A model to represent complex animations consisting of multiple animated shapes.
 */
public class ExcellenceAnimationModel implements ExcellenceAnimationOperations {

  private final List<ShapeAnimationOperations> shapeAnimations;

  /**
   * Public constructor for the ExcellenceAnimationModel. Creates an empty list to hold the shape
   * objects.
   */
  public ExcellenceAnimationModel() {
    this.shapeAnimations = new ArrayList<>();
  }

  @Override
  public void addShapeAnimation(ShapeAnimationModel shapeAnimation) {
    for (ShapeAnimationOperations i : shapeAnimations) {
      if (i.getObjectId().equals(shapeAnimation.getObjectId())) {
        throw new IllegalArgumentException("Object Id's cannot be the same");
      }
    }
    shapeAnimations.add(new ShapeAnimationModel(shapeAnimation));
  }

  @Override
  public List<ShapeAnimationOperations> getShapeAnimations() {
    return List.copyOf(shapeAnimations);
  }

  @Override
  public ShapeAnimationOperations getShapeWithObjectId(String objectId) {
    for (ShapeAnimationOperations i : shapeAnimations) {
      if (i.getObjectId().equals(objectId)) {
        return i;
      }
    }
    throw new IllegalArgumentException("A shape with this objectId does not exist.");
  }

  @Override
  public String toString() {
    String out = "";
    for (ShapeAnimationOperations i : shapeAnimations) {
      out += i.toString();
    }
    return out;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof ExcellenceAnimationModel)) {
      return false;
    }

    ExcellenceAnimationModel e = (ExcellenceAnimationModel) obj;

    if (e.shapeAnimations.size() != this.shapeAnimations.size()) {
      return false;
    }

    for (int i = 0; i < this.shapeAnimations.size(); i++) {
      if (!e.shapeAnimations.get(i).equals(this.shapeAnimations.get(i))) {
        return false;
      }
    }

    return true;
  }

  @Override
  public int hashCode() {
    ArrayList<String> values = new ArrayList<>();
    for (int i = 0; i < shapeAnimations.size(); i++) {
      values.add(shapeAnimations.get(i).toString());
    }
    Collections.sort(values);
    String hashable = "";
    for (String i : values) {
      hashable += i;
    }
    return Objects.hash(hashable);
  }

  @Override
  public void animationAtCurrentTick(int tick) {
    for (ShapeAnimationOperations i : shapeAnimations) {
      i.moveAtCurrentTick(tick);
    }
  }
}
