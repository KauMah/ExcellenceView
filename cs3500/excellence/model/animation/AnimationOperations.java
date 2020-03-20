package cs3500.excellence.model.animation;


/**
 * An interface that details the operations that can occur on an animation.
 */
public interface AnimationOperations {

  /**
   * Returns the objectId for the animation.
   *
   * @return objectId string.
   */
  String getObjectId();

  /**
   * Returns the start tick for the animation.
   *
   * @return startTick.
   */
  int getStartTick();

  /**
   * Returns the end tick for the animation.
   *
   * @return endTick.
   */
  int getEndTick();

  /**
   * Returns the change in height for each clock tick.
   *
   * @return Change in height per clock tick.
   */
  int getHeightChange();

  /**
   * Returns the change in width for each clock tick.
   *
   * @return Change in width per clock tick.
   */
  int getWidthChange();

  /**
   * Returns the change in X position per clock tick.
   *
   * @return change in X per clock tick.
   */
  int getXChange();

  /**
   * Returns the change in Y position per clock tick.
   *
   * @return change in Y per clock tick.
   */
  int getYChange();

  /**
   * Return the change in red color per clock tick.
   *
   * @return change in red per clock tick.
   */
  int getRedChange();

  /**
   * Return the change in green color per clock tick.
   *
   * @return change in green per clock tick.
   */
  int getGreenChange();

  /**
   * Returns the change in blue color per clock tick.
   *
   * @return change in blue per clock tick.
   */
  int getBlueChange();

  /**
   * Returns the starting red color.
   *
   * @return starting red color.
   */
  int getRed();

  /**
   * Return teh starting blue color.
   *
   * @return starting blue color.
   */
  int getBlue();

  /**
   * Return starting green color.
   *
   * @return starting green color.
   */
  int getGreen();

  /**
   * starting X position.
   *
   * @return the starting x position.
   */
  int getX();

  /**
   * Returns starting Y position.
   *
   * @return starting y position.
   */
  int getY();

  /**
   * Returns starting width.
   *
   * @return starting width.
   */
  int getWidth();

  /**
   * returns starting height.
   *
   * @return starting height.
   */
  int getHeight();
}
