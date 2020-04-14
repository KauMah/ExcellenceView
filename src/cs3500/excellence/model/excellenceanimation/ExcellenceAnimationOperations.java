package cs3500.excellence.model.excellenceanimation;

import cs3500.excellence.model.IKeyframe;
import cs3500.excellence.model.shapeanimation.ShapeAnimationModel;
import cs3500.excellence.model.shapeanimation.ShapeAnimationOperations;
import java.util.List;

/**
 * An Interface that describes the operation that can be performed by an Excellence animation.
 */
public interface ExcellenceAnimationOperations {

  /**
   * Adds a shape to the list of ShapeAnimationModel objects.
   *
   * @param shapeAnimation Object of type interface ShapeAnimationOperations.
   */
  void addShapeAnimation(ShapeAnimationModel shapeAnimation);

  /**
   * Returns a list of all the shape objects in the list.
   *
   * @return List of shape objects.
   */
  List<ShapeAnimationOperations> getShapeAnimations();

  /**
   * Returns the shape with the given objectId.
   *
   * @param objectId String representing objectId of a shape.
   * @return ShapeAnimationModel for the shape with given objectId.
   * @throws IllegalArgumentException if a shape with the given objectId does not exist.
   */
  ShapeAnimationOperations getShapeWithObjectId(String objectId);

  /**
   * Updates the ShapeAnimationOperations given the current tick.
   *
   * @param tick the current tick of the animation.
   */
  void animationAtCurrentTick(int tick);

  /**
   * get the dimensions of the canvas.
   *
   * @return List representing dimensions of the canvas.
   */
  List<Integer> getCanvasDimensions();

  /**
   * sets the dimensions of the canvas.
   *
   * @param x      x dimension.
   * @param y      y dimension.
   * @param width  width of canvas.
   * @param height height of canvas.
   */
  void setCanvasDimensions(int x, int y, int width, int height);

  /**
   * Returns the keyframes for a given shape.
   *
   * @param shape String representing the object ID of the shape.
   * @return List of type IKeyframe for the given shape.
   */
  List<IKeyframe> getKeyframes(String shape);

  /**
   * Returns the last tick for all the animations. The end of the whole animaition.
   *
   * @return integer representing last tick.
   */
  int getLastTick();

  void removeShape(String objectId);

  void setTempo(int tempo);

}
