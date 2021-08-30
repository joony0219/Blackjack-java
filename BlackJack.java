package blackjack;

public class BlackJack {
	
	private HumanPlayer player;
	private ComputerPlayer computer;
	private Dealer dealer;
	private Hand pHand;
	private Hand cHand;
	private int finalscore;
	private int winnerscore;
	private int computerScore;
	private int playerScore;
	Card[] computerCard;
	Card[] playerCard;
	
public BlackJack() {
	
	dealer = new Dealer();
	cHand = new Hand(11);
	pHand = new Hand(11);
	computer = new ComputerPlayer(11, dealer, cHand);
	player = new HumanPlayer(11, dealer, pHand);
	finalscore = 0;
	winnerscore = 0;
	computerScore = 0;
	playerScore = 0;
	dealer.firstDeal(player, computer);
	computerCard = computer.showCards();
	playerCard = player.showCards();
}

	public Dealer whoIsDealer() {
		return dealer;
	}
	public ComputerPlayer whoIsComputer() {
		return computer;
	}
	public HumanPlayer whoIsPlayer() {
		return player;
	}
	public Hand computerHand() {
		return cHand;
	}
	public Hand playerHand() {
		return pHand;
	}
	
	public int whoisWinner() {
		
		// 카드들의 합을 계산
		computerScore = dealer.countScore(computerCard);
		playerScore = dealer.countScore(playerCard);
		
		//승패판정
		int winnerscore = dealer.whoWin(playerScore, computerScore); // 누가 이겼는지 알려주는 값
		
		return winnerscore;
	}
	
	public int finalScore() {
		
		// 카드들의 합을 계산
		computerScore = dealer.countScore(computerCard);
		playerScore = dealer.countScore(playerCard);
		
		//점수 증가
		int gamescore = dealer.whoWin(playerScore, computerScore);
		finalscore += gamescore; // 해당 판의 점수
		
		return finalscore;
	}
	
	// 예시
	/* 블랙잭으로 한번 이긴 후 진 상황
	 * finalscore = +2 -1 = 1 / 무한대로 늘거나 줄 수 있음 (최종점수)
	 * winnerscore = -1 / 무조건 2 아니면 1 아니면 0 아니면 -1 (상태값)
	 */

}
