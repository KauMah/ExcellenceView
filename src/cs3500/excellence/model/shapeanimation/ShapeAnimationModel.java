package cs3500.excellence.model.shapeanimation;

import cs3500.excellence.model.animation.AnimationModel;
import cs3500.excellence.model.animation.AnimationOperations;
import cs3500.excellence.model.shapeanimation.Shape.shapeType;
import java.awt.Color;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A model to represent the animations applied to a single shape over a period of ticks.
 */
public class ShapeAnimationModel implements ShapeAnimationOperations {

  private final String objectId;
  private Shape shape;
  private shapeType type;
  private List<AnimationOperations> animationList;

  /**
   * Public constructor for a ShapeAnimationModel.  Initializes an empty list of Animations and sets
   * the object ID and type of shape.
   *
   * @param objectId ID for the shape.
   * @param type     type of shape.
   * @throws IllegalArgumentException if either of the inputs are null.
   */
  public ShapeAnimationModel(String objectId, shapeType type) {
    if (objectId == null || type == null) {
      throw new IllegalArgumentException("Parameters cannot be null");
    }
    this.objectId = objectId;
    this.shape = null;
    this.type = type;

    this.animationList = new ArrayList<>();
  }

  /**
   * Copy constructor for a ShapeAnimationModel.
   *
   * @param s ShapeAnimationModel object.
   */
  public ShapeAnimationModel(ShapeAnimationModel s) {
    this.objectId = s.objectId;
    this.shape = s.shape;
    this.animationList = s.animationList;
  }

  @Override
  public Point2D getCurrentPosition() {
    if (shape == null) {
      throw new IllegalStateException("Shape cannot be null, no animations have been set");
    }
    return shape.getPosition();
  }

  @Override
  public Dimension2D getCurrentDimensions() {
    if (shape == null) {
      throw new IllegalStateException("Shape cannot be null, no animations have been set yet.");
    }
    return shape.getDimensions();
  }

  @Override
  public Color getCurrentColor() {
    if (shape == null) {
      throw new IllegalStateException("Shape cannot be null, no animations have been set yet.");
    }
    return shape.getColor();
  }

  @Override
  public List<AnimationOperations> getAnimations() {
    return List.copyOf(animationList);
  }

  @Override
  public void addAnimation(int startTick, int endTick, int startX, int endX,
      int startY, int endY,
      int startWidth, int endWidth, int startHeight, int endHeight, int startRed, int endRed,
      int startGreen, int endGreen, int startBlue, int endBlue) {

    for (AnimationOperations i : animationList) {
      //We need to check that the animations do not overlap
      if ((startTick > i.getStartTick() && startTick < i.getEndTick())
          || (endTick > i.getStartTick() && endTick < i.getEndTick())
          || (endTick == i.getEndTick() || startTick == i.getStartTick())) {
        throw new IllegalStateException(
            "Cannot start a new animation until the first is complete.");
      }
    }

    AnimationModel a = new AnimationModel(objectId, startTick, endTick, startX, endX, startY, endY,
        startWidth, endWidth, startHeight, endHeight, startRed, endRed, startGreen, endGreen,
        startBlue, endBlue);

    animationList.add(a);

    setShape();

  }

  @Override
  public String getObjectId() {
    return objectId;
  }

  @Override
  public void moveAtCurrentTick(int currentTick) {
    if (shape == null) {
      throw new IllegalStateException("Shape cannot be null, cant move shape with no animations");
    }

    for (AnimationOperations a : animationList) {
      if (currentTick > a.getStartTick() && currentTick <= a.getEndTick()) {
        shape.setDimensions(a.getWidthChange(), a.getHeightChange());
        shape.setPosition(a.getXChange(), a.getYChange());
        shape.setColor(a.getRedChange(), a.getGreenChange(), a.getBlueChange());
      }

    }
  }

  @Override
  public Shape getShape() {
    return shape;
  }

  @Override
  public void addKeystroke(int keyframeIndex, int startX, int endX,
      int startY, int endY,
      int startWidth, int endWidth, int startHeight, int endHeight, int startRed, int endRed,
      int startGreen, int endGreen, int startBlue, int endBlue) {
    List<AnimationOperations> animations = getAnimations();
    int start = animations.get(keyframeIndex).getStartTick();
    int end = animations.get(keyframeIndex).getEndTick();
    if(keyframeIndex == 0) {
      for (AnimationOperations a : animations) {
        int startA = a.getStartTick();
        int endA = a.getEndTick();
        a.setStartTime(startA + 20);
        a.setEndTie(endA + 20);
      }
    } else if (keyframeIndex == animations.size()) {
      int time = animations.get(animations.size() - 1).getEndTick();
      addAnimation(time, time + 20, startX, endX, startY, endY, startWidth, endWidth,
          startHeight, endHeight, startRed, endRed, startGreen, endGreen, startBlue, endBlue);
    } else {
      animations.get(keyframeIndex).setEndTie(start + ((end-start) / 2));
      addAnimation((start + ((end-start) / 2)), end, startX, endX, startY, endY, startWidth, endWidth,
          startHeight, endHeight, startRed, endRed, startGreen, endGreen, startBlue, endBlue);
    }
  }

  @Override
  public void deleteKeystroke(int keyframeIndex) {
    List<AnimationOperations> animations = getAnimations();
    animationList.remove(keyframeIndex);
    animationList.remove(keyframeIndex - 1);
    AnimationOperations a = animations.get(keyframeIndex - 1);
    AnimationOperations a1 = animations.get(keyframeIndex);
    addAnimation(a.getStartTick(), a1.getEndTick(), a.getX(), a1.getEndX(), a.getY(), a1.getEndY(),
        a.getWidth(), a1.getEndWidth(), a.getHeight(), a1.getEndHeight(), a.getRed(),
        a1.getEndRed(), a.getGreen(), a1.getEndGreen(), a.getBlue(), a1.getEndBlue());
  }

  @Override
  public boolean isInvisible() {
    if(shape.getDimensions().getWidth() == 0 || shape.getDimensions().getHeight() == 0) {
      return true;
    }
  }

  @Override
  public boolean isOval() {
    return shape.getType().equals(shapeType.OVAL);
  }

  @Override
  public String toString() {
    if (shape == null) {
      throw new IllegalStateException("shape cannot be null");
    }
    String out = "Shape " + objectId + " " + shape.toString() + "\n";
    for (AnimationOperations i : animationList) {
      out += "motion " + objectId + " " + i.toString();
    }
    out += "\n";
    return out;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof ShapeAnimationModel)) {
      return false;
    }

    ShapeAnimationModel s = (ShapeAnimationModel) obj;

    if (s.animationList.size() != this.animationList.size()) {
      return false;
    }

    for (int i = 0; i < this.animationList.size(); i++) {
      if (!s.animationList.get(i).equals(this.animationList.get(i))) {
        return false;
      }
    }

    return this.objectId.equals(s.objectId) && this.shape == null && s.shape == null
        || this.shape.equals(s.shape);
  }

  @Override
  public int hashCode() {
    ArrayList<String> values = new ArrayList<>();
    for (int i = 0; i < animationList.size(); i++) {
      values.add(animationList.get(i).toString());
    }
    Collections.sort(values);
    String hashable = "";
    for (String i : values) {
      hashable += i;
    }
    return Objects.hash(objectId, shape, hashable);
  }

  /**
   * Finds and returns the animation that begins on the earliest tick.
   *
   * @return the first animation chronologically
   */
  private AnimationOperations getFirstAnimation() {
    int lowestTick = Integer.MAX_VALUE;
    if (animationList.isEmpty()) {
      return null;
    }
    AnimationOperations first = animationList.get(0);
    for (int i = 0; i < animationList.size(); i++) {
      AnimationOperations temp = animationList.get(i);
      if (temp.getStartTick() < lowestTick) {
        lowestTick = temp.getStartTick();
        first = temp;
      }
    }
    return first;
  }

  private void setShape() {
    AnimationOperations a = getFirstAnimation();
    shape = new Shape(a.getRed(), a.getGreen(), a.getBlue(), a.getWidth(), a.getHeight(),
        a.getX(), a.getY(), type);
  }
}
