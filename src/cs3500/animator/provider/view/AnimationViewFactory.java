package cs3500.animator.provider.view;

import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationOperations;

/**
 * A Factory used to create Animation Views.
 */
public class AnimationViewFactory {

  /**
   * Creates the appropriate view given a type of view and supporting arguments
   *
   * @param type           the type of view as a string
   * @param model          the model
   * @param fileName       the name of the output file
   * @param ticksPerSecond the speed of the animation given in ticks per second (non-negative)
   * @return
   */
  public static IAnimationView createAnimationView(String type, ExcellenceAnimationOperations model,
      String fileName, int ticksPerSecond) {
    switch (type) {
      case "text":
        return new TextView(model, fileName);
      case "svg":
        return new SVGView(model, fileName, ticksPerSecond);
      case "visual":
        return new SwingView(model);
      case "edit":
        return new InteractiveView(model, ticksPerSecond);
      default:
        throw new IllegalArgumentException("View does not exist");
    }
  }


}
