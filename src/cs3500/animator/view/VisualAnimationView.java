package cs3500.animator.view;

import cs3500.excellence.model.shapeanimation.Shape;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class VisualAnimationView extends JFrame implements
    animator.view.AnimationView {
    private AnimationPanel panel;
    private List<Shape> shapes;

    public VisualAnimationView(Double tempo, List<Shape> shapes) {
      super();

      this.shapes = shapes;
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
}
