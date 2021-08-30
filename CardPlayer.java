package blackjack;

public abstract class CardPlayer implements CardPlayerBehavior {
	
	private Card[] hand;
	private int card_count;
	
	public CardPlayer(int max_cards) {
		hand = new Card[max_cards]; // 초기화된 손패
	}
	
	public abstract boolean wantsACard();
	
	public boolean receiveCard(Card c) {
		if (card_count < hand.length) {
			hand[card_count] = c;
			card_count += 1;
			return true;
		}
		else
			return false;
	}
	
	public Card[] showCards() {
		Card[] cards = new Card[card_count];
		for (int i = 0; i < card_count; i++)
			cards[i] = hand[i];
		return cards;
	}

}
