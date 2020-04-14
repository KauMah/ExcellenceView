package cs3500.animator.otherview;

import cs3500.excellence.model.animation.AnimationOperations;
import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationOperations;
import cs3500.excellence.model.shapeanimation.ShapeAnimationOperations;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * A view that constructs an svg file based on an animation model.
 */
public class SVGView implements TextualView {

  private int ticksPerSecond = 1;
  private String outputFileName = "default";
  private final ExcellenceAnimationOperations model;
  private final StringBuilder str = new StringBuilder();

  /**
   * Constructs an SVGView that will output to a file.
   *
   * @param model          the read-only animation model
   * @param outputFileName the name of the output file
   * @param ticksPerSecond ticks per second (speed)
   */
  public SVGView(ExcellenceAnimationOperations model, String outputFileName, int ticksPerSecond) {

    if (model == null) {
      throw new IllegalArgumentException("Model name cannot be null");
    }
    if (ticksPerSecond <= 0) {
      throw new IllegalArgumentException("Ticks per second cannot be zero or negative");
    }

    this.model = model;
    this.outputFileName = outputFileName;
    this.ticksPerSecond = ticksPerSecond;
  }

  @Override
  public String getText() {
    str.append(
        "<svg viewbox=\"" + model.getCanvasDimensions().get(0) + " " + model.getCanvasDimensions()
            .get(1)
            + " " + model.getCanvasDimensions().get(2) + " " + model.getCanvasDimensions().get(3)
            + "\" version=\"1.1\"\n"
            + "     xmlns=\"http://www.w3.org/2000/svg\">" + "\n");
    List<ShapeAnimationOperations> shapes = model.getShapeAnimations();

    for (ShapeAnimationOperations s : shapes) {
      AnimationOperations start = s.getAnimations().get(0);
      str.append("<" + s.getShape().toString() + " id=\"" + s.getObjectId()
          + "\" " + this.getXLabel(s) + "=\"" + s.getShapeAtStart().getX() + "\" "
          + this.getYLabel(s) + "=\""
          + s.getShapeAtStart().getY() + "\" " + this.getWidthLabel(s) + "=\""
          + s.getShapeAtStart().getWidth() + "\" " + this.getHeightLabel(s) + "=\""
          + s.getShapeAtStart().getHeight()
          + "\" fill=\"" + s.getShapeAtStart().getStartColor().toString() + "\" visibility=\"");
      Boolean isHidden = false;
      if (!s.getAnimations().isEmpty() && s.getAnimations().get(0).getStartTick() > 1) {
        isHidden = true;
        str.append("hidden");
      } else {
        str.append("visible");
      }

      str.append("\" >\n");
      if (isHidden) {
        String fill = s.getAnimations().size() >= 1 ? "freeze" : "remove";
        str.append("\t<animate attributeType=\"xml\" begin=\"" + this.getMsFromTick(1)
            + "ms\" dur=\"" + getMsFromTick(s.getAnimations().get(0).getStartTick() - 1)
            + "ms\" attributeName=\"visibility\" from=\"hidden\" "
            + "to=\"visible\" fill=\"" + fill + "\"/>\n");
      }

      boolean isLast = false;

      for (int i = 0; i < s.getAnimations().size(); i++) {
        if (i == s.getAnimations().size() - 1) {
          isLast = true;
        }
        appendAnimationSpecificXML(s.getAnimations().get(i), s, isLast);
      }
      str.append("</" + s.getAnimations() + ">\n");
    }
    str.append("</svg>");
    return str.toString();
  }

  /**
   * Gets the label corresponding to the shape's x position, based on which shape it is.
   *
   * @param s the shape
   * @return the label corresponding to the shape's x position
   */
  private String getXLabel(ShapeAnimationOperations s) {
    return s.getShape().toString().equals(this.getOvalAsString())
        ? "cx" : "x";
  }

  /**
   * Gets the label corresponding to the shape's y position, based on which shape it is.
   *
   * @param s the shape
   * @return the label corresponding to the shape's y position
   */
  private String getYLabel(ShapeAnimationOperations s) {
    return s.getShape().toString().equals(this.getOvalAsString())
        ? "cy" : "y";
  }

  /**
   * Gets the label corresponding to the shape's width, based on which shape it is.
   *
   * @param s the shape
   * @return the label corresponding to the shape's width
   */
  private String getWidthLabel(ShapeAnimationOperations s) {
    return s.getShape().toString().equals(this.getOvalAsString())
        ? "rx" : "width";
  }

  /**
   * Gets the label corresponding to the shape's height, based on which shape it is.
   *
   * @param s the shape
   * @return the label corresponding to the shape's height
   */
  private String getHeightLabel(ShapeAnimationOperations s) {
    return s.getShape().toString().equals(this.getOvalAsString())
        ? "ry" : "height";
  }

  @Override
  public String getOvalAsString() {
    return "ellipse";
  }

  @Override
  public String getRectangleAsString() {
    return "rect";
  }

  @Override
  public void write() {
    if (outputFileName.equals("default")) {
      System.out.print(getText());
    } else {
      try {
        FileWriter fileWriter = new FileWriter(this.outputFileName);
        fileWriter.write(getText());
        fileWriter.close();
      } catch (IOException e) {
        throw new IllegalArgumentException("Could not write to file.");
      }
    }
  }

  /**
   * Gets a string representation of the tick in ms.
   *
   * @param tick the tick
   * @return a string representation of the duration in ms
   */
  private String getMsFromTick(int tick) {
    Float seconds = (float) tick / ticksPerSecond;
    Float ms = seconds * 1000;
    return String.format("%.1f", ms);
  }

  /**
   * Gets a string representation of the duration in ms.
   *
   * @param action the action
   * @return a string representation of the duration in ms
   */
  private String getDuration(AnimationOperations action) {
    int tickDuration = action.getEndTick() - action.getStartTick();
    return getMsFromTick(tickDuration);
  }

  /**
   * Appends the proper animation tags to the text, corresponding to the given action.
   *
   * @param a      the action
   * @param s      the animated shape
   * @param isLast whether the action is the last in the shape's list of actions
   */
  private void appendAnimationSpecificXML(AnimationOperations a, ShapeAnimationOperations s,
      boolean isLast) {
    String fill;
    if (isLast && s.getAnimations().get(s.getAnimations().size() - 1).getEndTick() == model
        .getLastTick()) {
      fill = "remove";
    } else {
      fill = "freeze";
    }

    if (!a.getStartColor().equals(a.getEndColor())) {
      str.append("\t<animate attributeType=\"xml\" begin=\"" + getMsFromTick(a.getStartTick())
          + "ms\" dur=\"" + getDuration(a)
          + "ms\" attributeName=\"fill\" from=\"" + a.getStartColor().toString()
          + "\" to=\"" + a.getEndColor().toString() + "\" fill=\"" + fill + "\"/>\n");
    }
    if (a.getHeight() != a.getEndHeight()) {
      str.append("\t<animate attributeType=\"xml\" begin=\"" + getMsFromTick(a.getStartTick())
          + "ms\" dur=\"" + getDuration(a)
          + "ms\" attributeName=\"" + this.getHeightLabel(s) + "\" from=\""
          + a.getHeight() + "\" to=\""
          + a.getEndHeight() + "\" fill=\"" + fill + "\"/>\n");
    }
    if (a.getWidth() != a.getEndWidth()) {
      str.append("\t<animate attributeType=\"xml\" begin=\"" + getMsFromTick(a.getStartTick())
          + "ms\" dur=\"" + getDuration(a)
          + "ms\" attributeName=\"" + this.getWidthLabel(s) + "\" from=\""
          + a.getWidth() + "\" to=\""
          + a.getEndWidth() + "\" fill=\"" + fill + "\"/>\n");
    }
    if (a.getX() != a.getEndX()) {
      str.append("\t<animate attributeType=\"xml\" begin=\"" + getMsFromTick(a.getStartTick())
          + "ms\" dur=\"" + getDuration(a)
          + "ms\" attributeName=\"" + this.getXLabel(s) + "\" from=\""
          + a.getX() + "\" to=\""
          + a.getEndX() + "\" fill=\"" + fill + "\"/>\n");
    }
    if (a.getY() != a.getEndY()) {
      str.append("\t<animate attributeType=\"xml\" begin=\"" + getMsFromTick(a.getStartTick())
          + "ms\" dur=\"" + getDuration(a)
          + "ms\" attributeName=\"" + this.getYLabel(s) + "\" from=\""
          + a.getY() + "\" to=\""
          + a.getEndY() + "\" fill=\"" + fill + "\"/>\n");
    }
    if (isLast && s.getAnimations().get(s.getAnimations().size() - 1).getEndTick() < model
        .getLastTick()) {
      str.append("\t<animate attributeType=\"xml\" begin=\"" + this.getMsFromTick(a.getEndTick())
          + "ms\" dur=\"0.1ms\" attributeName=\"visibility\" from=\"visible\" "
          + "to=\"hidden\" fill=\"freeze\"/>\n");
    }
  }
}
