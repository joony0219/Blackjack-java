package blackjack;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;

public class HitButton extends JButton implements ActionListener {
	
	Dealer dealer;
	HumanPlayer player;
	GameboardFrame gframe;
	Card newcard;
	
	public HitButton(String label, Dealer d, HumanPlayer p, GameboardFrame gf) {
		super(label);
		dealer = d;
		player = p;
		gframe = gf;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// 새 패 받아와서 보여주기
		dealer.dealToPlayer(player);
		newcard = dealer.newcardReturn();
		System.out.println("---새로 받은 카드---\n" + dealer.newcardSuit(newcard) + dealer.newcardInt(newcard));
	}


}