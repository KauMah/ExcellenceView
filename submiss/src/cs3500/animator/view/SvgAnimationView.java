package cs3500.animator.view;

import cs3500.animator.controller.ControllerType;
import cs3500.excellence.model.animation.AnimationOperations;
import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationModel;
import cs3500.excellence.model.shapeanimation.ShapeAnimationOperations;
import java.io.IOException;
import java.util.List;

/**
 * View for the svg animation.
 */
public class SvgAnimationView implements AnimationView {

  private List<ShapeAnimationOperations> animationList;
  private List<AnimationOperations> shapeOps;
  private int tempo;

  /**
   * Public constructor for the SVG animation that takes the model as a parameter.
   *
   * @param model Model used to get the animation list and them tempo.
   */
  public SvgAnimationView(ExcellenceAnimationModel model) {
    animationList = model.getShapeAnimations();
    tempo = model.getTempo();
  }

  /**
   * generates the svg.
   * @return string.
   */
  public String generateSVG() {
    String out = "<svg width=\"700\" height=\"500\" version=\"1.1\"\nxmlns=\"http://www.w3.org/2000/svg\">";
    out += "\n";
    for (ShapeAnimationOperations a : animationList) {
      switch (a.getShape().getType()) {
        case RECTANGLE:
          out += "<rect>\n";
          List<AnimationOperations> rectAnimations = a.getAnimations();
          for (AnimationOperations b : rectAnimations) {
            out += "<animate id=\"";
            out += a.getObjectId() + "\" ";
            out += "x=\"";
            out += b.getX() + "\" ";
            out += "y=\"";
            out += b.getY() + "\" ";
            out += "width=\"";
            out += b.getWidth() + "\" ";
            out += "height=\"";
            out += b.getHeight() + "\" ";
            out += "fill=\"rgb(";
            out += b.getRed() + ",";
            out += b.getGreen() + ",";
            out += b.getBlue() + ")\" ";
            out += "visibility=\"visible\"> \n";

            //tempo is in ticks/sec so we take the inverse an multiply by tick times 1000 to
            // get start time in ms
            out += "<animate attributeType=\"xml\" begin=\"";
            out += "base.begin+" + ((b.getStartTick() * (1 / tempo)) * 1000) + "ms\"";
            out += "dur=\"" + ((b.getEndTick() - b.getStartTick()) * (1 / tempo) * 1000) + "ms\"";
            out += "attributeName=\"x\" ";
            out += "from=\"" + b.getX() + "\"";
            out += "to=\"" + b.getEndX() + "\"";
            out += "fill=\"freeze\"/> \n";

            out += "<animate attributeType=\"xml\" begin=\"";
            out += "base.begin+" + ((b.getStartTick() * (1 / tempo)) * 1000) + "ms\"";
            out += "dur=\"" + ((b.getEndTick() - b.getStartTick()) * (1 / tempo) * 1000) + "ms\"";
            out += "attributeName\"y\" ";
            out += "from=\"" + b.getY() + "\"";
            out += "to=\"" + b.getEndY() + "\"";
            out += "fill=\"freeze\"/> \n";

            out += "<animate attributeType=\"xml\" begin=\"";
            out += "base.begin+" + ((b.getStartTick() * (1 / tempo)) * 1000) + "ms\"";
            out += "dur=\"" + ((b.getEndTick() - b.getStartTick()) * (1 / tempo) * 1000) + "ms\"";
            out += "attributeName\"height\" ";
            out += "from=\"" + b.getHeight() + "\"";
            out += "to=\"" + b.getEndHeight() + "\"";
            out += "fill=\"freeze\"/> \n";

            out += "<animate attributeType=\"xml\" begin=\"";
            out += "base.begin+" + ((b.getStartTick() * (1 / tempo)) * 1000) + "ms\"";
            out += "dur=\"" + ((b.getEndTick() - b.getStartTick()) * (1 / tempo) * 1000) + "ms\"";
            out += "attributeName\"width\" ";
            out += "from=\"" + b.getWidth() + "\"";
            out += "to=\"" + b.getEndWidth() + "\"";
            out += "fill=\"freeze\"/> \n";

            //not too sure abot changing color
            out += "<animate attributeType=\"xml\" begin=\"";
            out += "base.begin+" + ((b.getStartTick() * (1 / tempo)) * 1000) + "ms\"";
            out += "dur=\"" + ((b.getEndTick() - b.getStartTick()) * (1 / tempo) * 1000) + "ms\"";
            out += "attributeName\"fill\" ";
            out += "from=\"rgb(";
            out += b.getRed() + ",";
            out += b.getGreen() + ",";
            out += b.getBlue() + ")\" ";
            out += "to=\"rgb(";
            out += b.getEndRed() + ",";
            out += b.getEndGreen() + ",";
            out += b.getEndBlue() + ")\" ";
            out += "fill=\"freeze\"/> \n";
          }
          out += "</rect>";
          break;
        case OVAL:
          out += "<ellipse>\n";
          List<AnimationOperations> ellipseAnimations = a.getAnimations();
          for (AnimationOperations b : ellipseAnimations) {
            out += "<animate id=\"";
            out += a.getObjectId() + "\" ";
            out += "cx=\"";
            out += b.getX() + "\" ";
            out += "cy=\"";
            out += b.getY() + "\" ";
            out += "rx=\"";
            out += b.getWidth() + "\" ";
            out += "ry=\"";
            out += b.getHeight() + "\" ";
            out += "fill=\"rgb(";
            out += b.getRed() + ",";
            out += b.getGreen() + ",";
            out += b.getBlue() + ")\" ";
            out += "visibility=\"visible\" \n";

            out += "<animate attributeType=\"xml\" begin=\"";
            out += "base.begin+" + ((b.getStartTick() * (1 / tempo)) * 1000) + "ms\"";
            out += "dur=\"" + ((b.getEndTick() - b.getStartTick()) * (1 / tempo) * 1000) + "ms\"";
            out += "attributeName=\"cx\" ";
            out += "from=\"" + b.getX() + "\"";
            out += "to=\"" + b.getEndX() + "\"";
            out += "fill=\"freeze\"/> \n";

            out += "<animate attributeType=\"xml\" begin=\"";
            out += "base.begin+" + ((b.getStartTick() * (1 / tempo)) * 1000) + "ms\"";
            out += "dur=\"" + ((b.getEndTick() - b.getStartTick()) * (1 / tempo) * 1000) + "ms\"";
            out += "attributeName=\"cy\" ";
            out += "from=\"" + b.getY() + "\"";
            out += "to=\"" + b.getEndY() + "\"";
            out += "fill=\"freeze\"/> \n";

            out += "<animate attributeType=\"xml\" begin=\"";
            out += "base.begin+" + ((b.getStartTick() * (1 / tempo)) * 1000) + "ms\"";
            out += "dur=\"" + ((b.getEndTick() - b.getStartTick()) * (1 / tempo) * 1000) + "ms\"";
            out += "attributeName=\"rx\" ";
            out += "from=\"" + b.getWidth() + "\"";
            out += "to=\"" + b.getEndWidth() + "\"";
            out += "fill=\"freeze\"/> \n";

            out += "<animate attributeType=\"xml\" begin=\"";
            out += "base.begin+" + ((b.getStartTick() * (1 / tempo)) * 1000) + "ms\"";
            out += "dur=\"" + ((b.getEndTick() - b.getStartTick()) * (1 / tempo) * 1000) + "ms\"";
            out += "attributeName=\"ry\" ";
            out += "from=\"" + b.getHeight() + "\"";
            out += "to=\"" + b.getEndHeight() + "\"";
            out += "fill=\"freeze\"/> \n";

            //not too sure about changing color
            out += "<animate attributeType=\"xml\" begin=\"";
            out += "base.begin+" + ((b.getStartTick() * (1 / tempo)) * 1000) + "ms\"";
            out += "dur=\"" + ((b.getEndTick() - b.getStartTick()) * (1 / tempo) * 1000) + "ms\"";
            out += "attributeName\"fill\" ";
            out += "from=\"rgb(";
            out += b.getRed() + ",";
            out += b.getGreen() + ",";
            out += b.getBlue() + ")\" ";
            out += "to=\"rgb(";
            out += b.getEndRed() + ",";
            out += b.getEndGreen() + ",";
            out += b.getEndBlue() + ")\" ";
            out += "fill=\"freeze\"/> \n";
          }
          out += "</ellipse>";
          break;
        default:
          throw new IllegalArgumentException("Invalid shape");
      }
    }
    out += "</svg";
    return out;
  }

  /**
   * Sets the controller for the view.
   *
   * @param c interface for controller.
   */
  @Override
  public void setController(ControllerType c) {
    ControllerType controller;
    controller = c;
  }

  @Override
  public void display(Appendable file) {
    if (file == null) {
      throw new IllegalArgumentException("Output file is null");
    }
    try {
      file.append(generateSVG());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
