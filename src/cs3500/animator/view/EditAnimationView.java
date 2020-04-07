package cs3500.animator.view;

import cs3500.excellence.model.shapeanimation.Shape;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;

/**
 * A class to represent an editable visual animation
 */
public class EditAnimationView extends VisualAnimationView implements AnimationView{
  private JButton beg;
  private JButton rew;
  private JButton pausePlay;
  private JButton ffw;
  private JButton end;
  private JButton repeat;

  /**
   * Public constructor for the visual animation view.
   *
   * @param tempo  tempo of the animation.
   * @param shapes List of shapes to be animated.
   */
  public EditAnimationView(Double tempo, List<Shape> shapes) {
    super(tempo, shapes);

    beg = new JButton("Skip to beginning");
    beg.setActionCommand("beg");
    this.add(beg);
    rew = new JButton("Rewind");
    rew.setActionCommand("rew");
    this.add(rew);
    pausePlay = new JButton("Play/Pause");
    pausePlay.setActionCommand("pausePlay");
    this.add(pausePlay);
    ffw = new JButton("Fastforward");
    ffw.setActionCommand("ffw");
    this.add(ffw);
    end = new JButton("Skip to end");
    end.setActionCommand("end");
    this.add(end);
    repeat = new JButton("Repeat");
    repeat.setActionCommand("repeat");
    this.add(repeat);

    pack();
  }

  @Override
  public void setListener(ActionListener listener) {
    beg.addActionListener(listener);
    rew.addActionListener(listener);
    pausePlay.addActionListener(listener);
    ffw.addActionListener(listener);
    end.addActionListener(listener);
    repeat.addActionListener(listener);
  }

  /**
   * Display this view.
   */
  @Override
  public void display() {
    this.setVisible(true);
  }
}
