package cs3500.animator.otherview;

import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationOperations;

/**
 * A Factory used to create Animation Views.
 */
public class AnimationViewFactory {

  public static IAnimationView createAnimationView(String type, ExcellenceAnimationOperations model,
      String fileName, int ticksPerSecond) {
    switch (type) {
      case "text":
        return new TextView(model, fileName);
        break;
      case "svg":
        return new SVGView(model, fileName, ticksPerSecond);
        break;
      case "visual":
        return new SwingView(model);
        break;
      case "edit":
        return new InteractiveView(model, ticksPerSecond);
        break;
      default:
        throw new IllegalArgumentException("View does not exist");
    }
  }



}
