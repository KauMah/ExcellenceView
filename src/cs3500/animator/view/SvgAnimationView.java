package cs3500.animator.view;

import cs3500.excellence.model.animation.AnimationOperations;
import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationModel;
import cs3500.excellence.model.shapeanimation.Shape.shapeType;
import cs3500.excellence.model.shapeanimation.ShapeAnimationOperations;
import java.util.ArrayList;
import java.util.List;

public class SvgAnimationView implements animator.view.SvgAnimationViewOperations {
  private List<ShapeAnimationOperations> animationList;
  private List<AnimationOperations> shapeOps;
  private int tempo;

  public SvgAnimationView (ExcellenceAnimationModel model) {
    animationList = model.getShapeAnimations();
    tempo = model.getTempo();
  }

  @Override
  public String toString() {
    String out = "<svg width=\"700\" height=\"500\" version=\"1.1\"\nxmlns=\"http://www.w3.org/2000/svg\">";
    out += "\n";
    for (ShapeAnimationOperations a: animationList) {
      switch(a.getShape().getType()) {
        case RECTANGLE :
          out += "<rect>\n";
          List<AnimationOperations> rectAnimations = a.getAnimations();
          for(AnimationOperations b: rectAnimations) {
            out += "<animate id=\"";
            out += a.getObjectId() + "\" ";
            out += "x=";
            out += b.getX() + " ";
            out += "y=";
            out += b.getY() + " ";
            out += "width=";
            out += b.getWidth() + " ";
            out += "height=";
            out += b.getHeight() + " ";
            out += "fill=rgb(";
            out += b.getRed() + ",";
            out += b.getGreen() + ",";
            out += b.getBlue() + ") ";
            out += "visibility=\"visible\" \n";
            out += "<animate attributeType=\"xml\" begin=";
            //tempo is in ticks/sec so we take the inverse an multiply by tick times 1000 to
            // get start time in ms
            out += "base.begin+" + (((1/b.getStartTick()) * tempo) * 1000);
            out += "duration=" + ((b.getEndTick() - b.getStartTick()) * 1000);
            out += "attributeName=\"x\" ";
            out += "from=\"" + b.getX() + "\"";
            out += "to=\"" + b.getEndX() + "\"";
            out += "attributeName\"y\" ";
            out += "from=\"" + b.getY() + "\"";
            out += "to=\"" + b.getEndY() + "\"";
            out += "attributeName\"height\" ";
            out += "from=\"" + b.getHeight() + "\"";
            out += "to=\"" + b.getEndHeight() + "\"";
            out += "attributeName\"width\" ";
            out += "from=\"" + b.getWidth() + "\"";
            out += "to=\"" + b.getEndWidth() + "\"";
            out += "attributeName\"fill\" ";
            out += "from=\"rgb(";
            out += b.getRed() + ",";
            out += b.getGreen() + ",";
            out += b.getBlue() + ") ";
            out += "to=\"rgb(";
            out += b.getEndRed() + ",";
            out += b.getEndGreen() + ",";
            out += b.getEndBlue() + ") ";
            out += "fill=\"freeze\"";
            out += "/>";
          }
          out += "</rect>";
          break;
        case OVAL:
          out += "<ellipse>\n";
          List<AnimationOperations> ellipseAnimations = a.getAnimations();
          for(AnimationOperations b: ellipseAnimations) {
            out += "<animate id=\"";
            out += a.getObjectId() + "\" ";
            out += "cx=";
            out += b.getX() + " ";
            out += "cy=";
            out += b.getY() + " ";
            out += "rx=";
            out += b.getWidth() + " ";
            out += "ry=";
            out += b.getHeight() + " ";
            out += "fill=rgb(";
            out += b.getRed() + ",";
            out += b.getGreen() + ",";
            out += b.getBlue() + ") ";
            out += "visibility=\"visible\" \n";
          }
          }
          break;
        default:
          throw new IllegalArgumentException("Invalid shape");
      }
    }
  }
}
