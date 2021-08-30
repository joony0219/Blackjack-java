package blackjack;

public class Dealer {
	
	private CardDeck deck;
	Hand hand;
	Hand cHand;
	Hand pHand;
	GameboardFrame gframe;
	Card newcard;
	Card newcard1;
	Card newcard2;
	Card newcard3;
	Card newcard4;
	
	
	public Dealer() {
		deck = new CardDeck();
		newcard1 = deck.newCard();
		newcard2 = deck.newCard();
		newcard3 = deck.newCard();
		newcard4 = deck.newCard();
	}
	
	public void firstDeal(CardPlayerBehavior p1, CardPlayerBehavior p2) {
		p1.receiveCard(newcard1);
		p2.receiveCard(newcard2);
		p1.receiveCard(newcard3);
		p2.receiveCard(newcard4);
	}
	
	public Card newcard1Return() {
		return newcard1;
	}
	public Card newcard2Return() {
		return newcard2;
	}
	public Card newcard3Return() {
		return newcard3;
	}
	public Card newcard4Return() {
		return newcard4;
	}
	public Card newcardReturn() {
		return newcard;
	}
	public String newcardSuit(Card c) {
		return c.getSuit();
	}
	
	public int newcardInt(Card c) {
		return c.getRank();
	}
	

	public void dealTo(CardPlayerBehavior p, Hand chand) {
		cHand = chand;
		while (p.wantsACard()) {
			Card c = deck.newCard();
			p.receiveCard(c);
		}
	}
	
	public void dealToPlayer(CardPlayerBehavior p) {
		newcard = deck.newCard();
		p.receiveCard(newcard);
	}
	
	public int countScore(Card[] hand) {
		int score = 0;
		int number_of_aces = 0;
		for (int i = 0; i < hand.length; i++) {
			int rank = hand[i].getRank();
			if (rank == 1) {
				score += 11;
				number_of_aces += 1;
			} else if (rank == 10 || rank == 11 || rank == 12 || rank == 13) {
				score += 10;
			}
			else
				score += rank;
		}
		
		while (score > 21 &&  number_of_aces > 0) {
			score -= 10;
			number_of_aces -= 1;
		}
		return score;
	}
	
	public int whoWin(int playerScore, int computerScore) {
		
		int win;
		// 2 = 플레이어 블랙잭, 1 = 이김, 0 = 비김, -1 = 졌음
		
		if (playerScore == 21) {
			win = 2;
		}
		else {
			if (computerScore > 21) {
				win = 1;
			}
			else if (computerScore == playerScore) {
				win = 0;
			}
			else if (computerScore < playerScore) {
				win = 1;
			}
			else {
				win = -1;
			}
		}
		return win;
	}
}
