package blackjack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StayButton extends JButton implements ActionListener {
	
	ComputerPlayer computer;
	Dealer dealer;
	Hand pHand;
	Hand cHand;
	GameboardFrame gframe;
	
	public StayButton(String label, Dealer d, ComputerPlayer c, GameboardFrame g) {
		super(label);
		dealer = d;
		computer = c;
		gframe = g;
		cHand = gframe.computerHand();
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// 패 안 받고 종료
		dealer.dealTo(computer, cHand);
		gframe.update();
		
		// Test Code
		// System.out.println("정상작동합니다.");
	}

}