package blackjack;

public class ComputerPlayer extends CardPlayer {
	
	private Dealer dealer;
	private Hand hand;
	
	public ComputerPlayer(int max_cards, Dealer d, Hand h) {
		super(max_cards); // == CardPlayer(max_cards)
		dealer = d;
		hand = h;	
	}
	
	public boolean wantsACard() {
		// 16점 이하면 카드 한장 추가
		// 16점 이하면 true 리턴 / 아니면 false 리턴
		return dealer.countScore(this.showCards()) <= 16;
		
	}
}
