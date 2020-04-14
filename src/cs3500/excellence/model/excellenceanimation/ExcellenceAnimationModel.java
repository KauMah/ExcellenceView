package cs3500.excellence.model.excellenceanimation;

import cs3500.animator.util.AnimationBuilder;
import cs3500.excellence.model.IKeyframe;
import cs3500.excellence.model.Keyframe;
import cs3500.excellence.model.animation.AnimationOperations;

import cs3500.excellence.model.shapeanimation.ShapeAnimationModel;
import cs3500.excellence.model.shapeanimation.ShapeAnimationOperations;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A model to represent complex animations consisting of multiple animated shapes.
 */
public final class ExcellenceAnimationModel implements ExcellenceAnimationOperations {

  private List<Integer> canvasDimensions;
  private final List<ShapeAnimationOperations> shapeAnimations;
  //tempo in seconds
  private int tempo;

  /**
   * Public constructor for the ExcellenceAnimationModel. Creates an empty list to hold the shape
   * objects.
   */
  public ExcellenceAnimationModel() {
    this.shapeAnimations = new ArrayList<>();
    this.canvasDimensions = new ArrayList<>();
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

  //new
  public int getTempo() {
    return tempo;
  }

  //new
  public void setTempo(int tempo) {
    this.tempo = tempo;
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

  @Override
  public List<IKeyframe> getKeyframes(String shape) {
    List<IKeyframe> frames = new ArrayList<>();
    int endTick = 100000;
    ShapeAnimationOperations shapeA = getShapeWithObjectId(shape);
    for (AnimationOperations a : shapeA.getAnimations()) {
      if(a.getStartTick() != endTick) {
        frames.add(new Keyframe(a.getStartTick()));
      }
      endTick = a.getEndTick();
      frames.add(new Keyframe(endTick));
    }
    return frames;
  }

  @Override
  public int getLastTick() {
    int lastTick = 0;
    for (ShapeAnimationOperations s : shapeAnimations) {
      if (s.getLastTick() > lastTick)
        lastTick = s.getLastTick();
    }
    return lastTick;
  }

  @Override
  public void setCanvasDimensions(int startingX, int startingY, int width, int height) {
    if (startingX > 0 && startingY > 0 && width > 0 && height > 0) {
      canvasDimensions.add(startingX);
      canvasDimensions.add(startingY);
      canvasDimensions.add(width);
      canvasDimensions.add(height);
    } else {
      throw new IllegalArgumentException("Issue with given canvas dimensions - Illegal value(s)");
    }
  }

  @Override
  public List<Integer> getCanvasDimensions() {
    return canvasDimensions;
  }

  /**
   * Builder class for the model.
   */
  public final class Builder implements AnimationBuilder<ExcellenceAnimationOperations> {
    private final ExcellenceAnimationOperations model;

    public Builder() {
      this.model = new ExcellenceAnimationModel();
    }

    @Override
    public ExcellenceAnimationOperations build() {
      return new ExcellenceAnimationModel();
    }

    @Override
    public AnimationBuilder<ExcellenceAnimationOperations> setBounds(int x, int y, int width,
        int height) {

      return this;
    }

    @Override
    public AnimationBuilder<ExcellenceAnimationOperations> declareShape(String name, String type) {
      return this;
    }

    @Override
    public AnimationBuilder<ExcellenceAnimationOperations> addMotion(String name, int t1, int x1,
        int y1, int w1, int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2,
        int r2, int g2, int b2) {
      return this;
    }

    @Override
    public AnimationBuilder<ExcellenceAnimationOperations> addKeyframe(String name, int t, int x,
        int y, int w, int h, int r, int g, int b) {
      return this;
    }
  }
}
