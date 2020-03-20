package cs3500.excellence.model.shapeanimation;

import cs3500.excellence.model.animation.AnimationOperations;
import cs3500.excellence.model.AnimationState;
import java.util.List;

/**
 * An interface that represents the
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

}
