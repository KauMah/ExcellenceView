package cs3500.animator.view;

import cs3500.animator.controller.ControllerType;
import cs3500.excellence.model.shapeanimation.Shape;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * Class representing the visual animation view for the animation.
 */
public class VisualAnimationView extends JFrame implements AnimationView {
  private ControllerType controller;
  private final AnimationPanel panel;


  /**
   * Public constructor for the visual animation view.
   *
   * @param tempo tempo of the animation.
   */
  public VisualAnimationView(Double tempo, List<Shape> shape) {
    super();

    AnimationPanel panel;
    List<Shape> shapes;

    shapes = shape;
    this.setTitle("Animation");
    this.setSize(700, 700);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    panel = new AnimationPanel(shapes);
    panel.setPreferredSize(new Dimension(700, 700));

    JScrollPane scrollPane = new JScrollPane(panel);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
    scrollPane.setBounds(50, 30, 300, 50);

    this.add(scrollPane, BorderLayout.CENTER);

    this.pack();
  }

  @Override
  public void setController(ControllerType c) {

  }

  @Override
  public void display(Appendable file) {

  }
}
