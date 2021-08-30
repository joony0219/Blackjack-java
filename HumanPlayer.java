package blackjack;

import javax.swing.*;

public class HumanPlayer extends CardPlayer {
	
	private Dealer dealer;
	private Hand hand;
	//private Button button;
	
	public HumanPlayer(int max_cards, Dealer d, Hand h) {
		super(max_cards); // == CardPlayer(max_cards)
		dealer = d;
		hand = h;
	}
	
	public boolean wantsACard() {
//		String response = JOptionPane.showInputDialog("한장 더 드릴까요? (Y/N)");
//		return response.equals("Y") || response.equals("y");
		return true;
	}
}
