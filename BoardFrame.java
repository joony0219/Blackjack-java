package blackjack;

import java.awt.*;
import javax.swing.*;

public class BoardFrame extends JFrame {
	private JLabel label = new JLabel("count = 0");
	private JPanel drawing;
	
	public BoardFrame(JPanel panel) {
		
		drawing = panel;
		
		JPanel north = new JPanel(new FlowLayout());
		north.add(label);
		
		JPanel south = new JPanel(new FlowLayout());
		south.add(new CountButton("Count", count, this)); 
		south.add(new ExitButton("Exit"));
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(north, BorderLayout.NORTH);
		cp.add(drawing, BorderLayout.CENTER);
		cp.add(south, BorderLayout.SOUTH);
		
		setTitle("Counter");
		setSize(200,280);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	/** update - 뷰 갱신 */
	public void update() {
		label.setText("count = " + count.countOf());
		drawing.repaint();
	}
}
