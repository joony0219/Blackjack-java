package blackjack;

public class Starter {

	Dealer dealer;
	HumanPlayer player;
	ComputerPlayer computer;
	Hand cHand;
	Hand pHand;
	
	public void main(String[] args) {
	
		
		System.out.println("Welcome to Softopia Casino!");
		new BlackJack();
		
		// 칩 개수 초기화
		
		
		// 첫 카드 분배
		dealer.firstDeal(player, computer);

		// 추가 패 분배
//		dealer.dealTo(computer);
//		dealer.dealTo(player);
		
		
		
		// 딜러 첫카드 제외하고 전부 보여주기
		System.out.println("My Cards are: ");
		cHand.showHand(); // 지금 전부 보여줌
		// 그래픽 코드 들어갈자리 
		
		// 내 카드 보여주기
		pHand.showHand();
		// 그래픽 코드 들어갈자리 


		}
}
