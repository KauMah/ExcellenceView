package cs3500.animator.otherview;

import cs3500.excellence.model.animation.AnimationOperations;
import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationOperations;
import cs3500.excellence.model.shapeanimation.ShapeAnimationOperations;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class representing a text view that shows a textual description of the animation.
 */
public class TextView implements TextualView {
  private String outputFileName = "default";
  private final ExcellenceAnimationOperations model;

  /**
   * Constructor of the text view. Takes in a model and an output field name.
   * @param model the read only animation operation model
   * @param outputFileName output file name for the textual description
   */
  public TextView(ExcellenceAnimationOperations model, String outputFileName) {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null");
    }
    this.model = model;
    this.outputFileName = outputFileName;
  }

  /**
   * Creates the descriptive text for the animation.
   * @return a string of the text
   */
  public String getText() {
    StringBuilder str = new StringBuilder();
    List<String> canvasProps = new ArrayList(
            Arrays.asList(Integer.toString(model.getCanvasDimensions().get(0)),
            Integer.toString(model.getCanvasDimensions().get(1)), Integer.toString(model.getCanvasDimensions().get(2)),
            Integer.toString(model.getCanvasDimensions().get(3))));
    str.append("canvas " + String.join(" ", canvasProps) + "\n");
    List<ShapeAnimationOperations> shapes = model.getShapeAnimations();
    for (ShapeAnimationOperations s : shapes) {
      str.append("shape " + s.getObjectId() + " " + s.getShape().getType().toString().toLowerCase() + "\n");
      for (AnimationOperations a : s.getAnimations()) {
        List motions = new ArrayList(Arrays.asList(Integer.toString(a.getStartTick()),
                Integer.toString(a.getX()), Integer.toString(a.getY()),
                Integer.toString(a.getWidth()), Integer.toString(a.getHeight()),
                Integer.toString(a.getRed()),
                Integer.toString(a.getGreen()),
                Integer.toString(a.getBlue()), Integer.toString(a.getEndTick()),
                Integer.toString(a.getEndX()), Integer.toString(a.getEndY()),
                Integer.toString(a.getEndWidth()), Integer.toString(a.getEndHeight()),
                Integer.toString(a.getEndRed()), Integer.toString(a.getEndGreen()),
                Integer.toString(a.getEndBlue())));
        str.append("motion " + s.getObjectId() + " " + String.join(" ", motions) + "\n");
      }
    }
    str.deleteCharAt(str.length() - 1);
    return str.toString();
  }

  @Override
  public void write() {
    if (outputFileName.equals("default")) {
      System.out.print(getText());
    }
    else {
      try {
        FileWriter fileWriter = new FileWriter(this.outputFileName);
        fileWriter.write(getText());
        fileWriter.close();
      }
      catch (IOException e) {
        throw new IllegalArgumentException("Could not write to file.");
      }
    }
  }

  @Override
  public String getOvalAsString() {
    return "oval";
  }

  @Override
  public String getRectangleAsString() {
    return "rectangle";
  }


}
