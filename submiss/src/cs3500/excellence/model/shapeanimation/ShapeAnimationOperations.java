package cs3500.excellence.model.shapeanimation;

import cs3500.excellence.model.AnimationState;
import cs3500.excellence.model.animation.AnimationOperations;
import java.util.List;

/**
 * An interface that represents the animation operations of a shape.
 */
public interface ShapeAnimationOperations extends AnimationState {

  /**
   * Returns a list of animations on the current shape.
   *
   * @return List of Animations for the current shape.
   */
  List<AnimationOperations> getAnimations();

  /**
   * Adds an animation to the shape.
   *
   * @param startTick   startTick for the animation.
   * @param endTick     endTick for the animation.
   * @param startX      startX for the animation.
   * @param endX        endX for the animation.
   * @param startY      startY for the animation.
   * @param endY        endY for the animation.
   * @param startWidth  startWidth for the animation.
   * @param endWidth    endWidth for the animation.
   * @param startHeight startHeight for the animation.
   * @param endHeight   endHeight for the animation.
   * @param startRed    startRed for the animation.
   * @param endRed      endRed for the animation.
   * @param startGreen  startGreen for the animation.
   * @param endGreen    endGreen for the animation.
   * @param startBlue   startBlue for the animation.
   * @param endBlue     endBlue for the animation.
   * @throws IllegalArgumentException if the animation overlaps with another animation on the
   *                                  shape.
   */
  void addAnimation(int startTick, int endTick, int startX, int endX, int startY,
      int endY, int startWidth, int endWidth, int startHeight, int endHeight, int startRed,
      int endRed, int startGreen, int endGreen, int startBlue, int endBlue);

  /**
   * Returns the object ID for the shape.
   *
   * @return objectId.
   */
  String getObjectId();

  /**
   * Moves the shape at the current state of the clock. If the shape has an animation in the given
   * tick it will perform the transformation otherwise it will not do anything.
   *
   * @param currentTick the current tick of the clock.
   */
  void moveAtCurrentTick(int currentTick);

  /**
   * returns the shape.
   *
   * @return shape.
   */
  Shape getShape();

  /**
   * Adds a keyframe to the animation list.
   *
   * @param keyframeIndex index of where to add the keyframe.
   * @param startX        start X position.
   * @param endX          end x position.
   * @param startY        start Y position.
   * @param endY          end Y position.
   * @param startWidth    start width of shape.
   * @param endWidth      end width of shape.
   * @param startHeight   start height of shape.
   * @param endHeight     end height of shape.
   * @param startRed      start red color of shape.
   * @param endRed        end red color of shape.
   * @param startGreen    start Green color of shape.
   * @param endGreen      end green color of shape.
   * @param startBlue     start blue color of shape.
   * @param endBlue       end blue color of shape.
   */
  void addKeystroke(int keyframeIndex, int startX, int endX,
      int startY, int endY,
      int startWidth, int endWidth, int startHeight, int endHeight, int startRed, int endRed,
      int startGreen, int endGreen, int startBlue, int endBlue);

  /**
   * Removes a keystroke from the shape.
   *
   * @param keyframeIndex index of the keyframe to delete.
   */
  void deleteKeystroke(int keyframeIndex);

  /**
   * Returns boolean whether or not the shape becomes visible.
   *
   * @return true if shape is invisible.
   */
  boolean isInvisible();

  /**
   * Returns boolean if the shape is an oval.
   *
   * @return true if shapeType is oval.
   */
  boolean isOval();

  /**
   * Gets the characteristics for the shape on its first animation.
   *
   * @return Animation characteristics for the first animation on the shape.
   */
  AnimationOperations getShapeAtStart();

  /**
   * Returns the last tick for the animation on a shape.
   *
   * @return last tick for an animation.
   */
  int getLastTick();
}
