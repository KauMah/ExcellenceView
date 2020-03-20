package cs3500.excellence.model.animation;

import java.util.Objects;

/**
 * A model to represent a simple animation of any object in terms or position, size, and color.
 */
public class AnimationModel implements AnimationOperations {

  private final String objectId;

  private final int startTick;
  private final int endTick;

  private final int startX;
  private final int endX;
  private final int startY;
  private final int endY;

  private final int startWidth;
  private final int endWidth;
  private final int startHeight;
  private final int endHeight;

  private final int startRed;
  private final int endRed;
  private final int startGreen;
  private final int endGreen;
  private final int startBlue;
  private final int endBlue;

  private final int stepAmt;

  /**
   * Public constructor for an AnimationModel. Sets the parameters for the given animation.
   *
   * @param startTick   Start time of the animation.
   * @param endTick     End time of the animation.
   * @param startX      Starting X position of the shape in the animation.
   * @param endX        Final X position of the shape in the animation.
   * @param startY      Starting Y position of the shape in the animation.
   * @param endY        Final Y position of the shape in the animation.
   * @param startWidth  Starting width of the shape in the animation.
   * @param endWidth    Final width of the shape in the animation.
   * @param startHeight Starting height of the shape in the animation.
   * @param endHeight   Final height of the shape in the animation.
   * @param startRed    Starting red color of the shape in the animation.
   * @param endRed      Final red color of the shape in the animation.
   * @param startGreen  Starting green color of the shape in the animation.
   * @param endGreen    Final green color of the shape in the animation.
   * @param startBlue   Starting blue color of the shape in the animation.
   * @param endBlue     Final blue color of the shape in the animation.
   * @throws IllegalArgumentException if the startTick is greater than the end tick or if any of the
   *                                  dimension parameters are less than 0 or if any of the color
   *                                  parameters are not valid meaning they are between 0 and 255
   *                                  inclusive.
   */
  public AnimationModel(String objectId, int startTick, int endTick, int startX, int endX,
      int startY,
      int endY, int startWidth, int endWidth, int startHeight, int endHeight, int startRed,
      int endRed, int startGreen, int endGreen, int startBlue, int endBlue) {

    if (startTick > endTick || startTick < 1 || endTick < 1
        //We need to accommodate negative positions for objects moving offscreen
        //|| startX < 0 || endX < 0 || startY < 0 || endY < 0
        || startWidth < 0 || endWidth < 0 || startHeight < 0 || endHeight < 0
        || !isValidColor(startRed) || !isValidColor(endRed)
        || !isValidColor(startGreen) || !isValidColor(endGreen)
        || !isValidColor(startBlue) || !isValidColor(endBlue)) {
      throw new IllegalArgumentException("Invalid parameters");
    }

    this.objectId = objectId;
    this.startTick = startTick;
    this.endTick = endTick;
    this.startX = startX;
    this.endX = endX;
    this.startY = startY;
    this.endY = endY;
    this.startWidth = startWidth;
    this.endWidth = endWidth;
    this.startHeight = startHeight;
    this.endHeight = endHeight;
    this.startRed = startRed;
    this.endRed = endRed;
    this.startGreen = startGreen;
    this.endGreen = endGreen;
    this.startBlue = startBlue;
    this.endBlue = endBlue;

    this.stepAmt = endTick - startTick;
  }

  @Override
  public String getObjectId() {
    return objectId;
  }

  @Override
  public int getStartTick() {
    return startTick;
  }

  @Override
  public int getEndTick() {
    return endTick;
  }

  @Override
  public int getHeightChange() {
    return (endHeight - startHeight) / stepAmt;
  }

  @Override
  public int getWidthChange() {
    return (endWidth - startWidth) / stepAmt;
  }

  @Override
  public int getXChange() {
    return (endX - startX) / stepAmt;
  }

  @Override
  public int getYChange() {
    return (endY - startY) / stepAmt;
  }

  @Override
  public int getRedChange() {
    return (endRed - startRed) / stepAmt;
  }

  @Override
  public int getGreenChange() {
    return (endGreen - startGreen) / stepAmt;
  }

  @Override
  public int getBlueChange() {
    return (endBlue - startBlue) / stepAmt;
  }

  @Override
  public int getRed() {
    return startRed;
  }

  @Override
  public int getBlue() {
    return startBlue;
  }

  @Override
  public int getGreen() {
    return startGreen;
  }

  @Override
  public int getX() {
    return startX;
  }

  @Override
  public int getY() {
    return startY;
  }

  @Override
  public int getWidth() {
    return startWidth;
  }

  @Override
  public int getHeight() {
    return startHeight;
  }

  @Override
  public String toString() {
    return startTick + " " + startX + " " + startY
        + " " + startWidth + " " + startHeight + " " + startRed + " " + startGreen + " "
        + startBlue + "   " + endTick + " " + endX + " " + endY + " " + endWidth + " "
        + endHeight + " " + endRed + " " + endGreen + " " + endBlue + "\n";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (!(obj instanceof AnimationModel)) {
      return false;
    }

    AnimationModel a = (AnimationModel) obj;

    return a.objectId.equals(objectId) && a.startTick == startTick && a.startX == startX
        && a.startY == startY && a.startWidth == startWidth && a.startHeight == startHeight
        && a.startRed == startRed && a.startGreen == startGreen && a.startBlue == startBlue
        && a.endTick == endTick && a.endX == endX
        && a.endY == endY && a.endWidth == endWidth && a.endHeight == endHeight
        && a.endRed == endRed && a.endGreen == endGreen && a.endBlue == endBlue;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.toString());
  }

  private boolean isValidColor(int color) {
    return color >= 0 && color < 256;
  }

}
