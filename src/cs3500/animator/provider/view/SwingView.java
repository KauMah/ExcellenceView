package cs3500.animator.provider.view;

import cs3500.excellence.model.excellenceanimation.ExcellenceAnimationOperations;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * The class representing a visual view of the animation. Draws and plays the animation in a
 * window.
 */
public class SwingView extends JFrame implements VisualView {

  /**
   * Constructor of the swing view.
   *
   * @param m A read-only animation model with the existing shapes and actions
   */
  public SwingView(ExcellenceAnimationOperations m) {
    super();
    ExcellenceAnimationOperations model = m;
    this.setTitle("Animation!");
    this.setSize(
        new Dimension(model.getCanvasDimensions().get(2), model.getCanvasDimensions().get(3)));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    AnimationPanel animationPanel = new AnimationPanel(model);
    animationPanel.setPreferredSize(new Dimension(model.getCanvasDimensions().get(2),
        model.getCanvasDimensions().get(3)));
    animationPanel
        .setLocation(model.getCanvasDimensions().get(0), model.getCanvasDimensions().get(1));
    this.add(new JScrollPane(animationPanel), null);
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    this.add(buttonPanel, BorderLayout.SOUTH);

    JButton quitButton = new JButton("Quit");
    quitButton.addActionListener((ActionEvent e) -> {
      System.exit(0);
    });
    buttonPanel.add(quitButton);

    this.pack();
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  @Override
  public void refresh() {
    this.repaint();
  }

}
