package blackjack;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

public class GameboardFrame extends JFrame {
	
	private JLabel computerlabel = new JLabel("Computer");
	private JLabel playerlabel = new JLabel("Player");;
	private JLabel scoreboard;
	private BlackJack blackjack;
	private int gamescore;
	Dealer dealer;
	ComputerPlayer computer;
	HumanPlayer player;
	GameboardFrame gframe;
	Hand cHand;
	Hand pHand;
	String pHandString;

	
	public GameboardFrame() {
		blackjack = new BlackJack();
		player = blackjack.whoIsPlayer();
		dealer = blackjack.whoIsDealer();
		computer = blackjack.whoIsComputer();
		cHand = blackjack.computerHand(); // 2장이 들어가있음
		pHand = blackjack.playerHand();
		gframe = this;
		
		Card newcard1 = dealer.newcard1Return();
		Card newcard2 = dealer.newcard2Return();
		Card newcard3 = dealer.newcard3Return();
		
		System.out.println("---현재 갖고 있는 카드---\n"
				+ dealer.newcardSuit(newcard1) + dealer.newcardInt(newcard1) + "\n"
				+ dealer.newcardSuit(newcard2) + dealer.newcardInt(newcard2));
		System.out.println("---상대가 공개한 카드---\n"
				+ dealer.newcardSuit(newcard3) + dealer.newcardInt(newcard3));
		
		
//		Card[] copycardlist = new Card[2];
//		System.arraycopy(player.showCards(), 0, copycardlist, 0, 2);
//		for (Card cardlist : copycardlist) {
//			System.out.println(cardlist);
//		}
		
		// 컴퓨터 패 보여주기
		// System.out.println("상대의 패: " + Arrays.toString(computer.showCards()));
		
		scoreboard = new JLabel("ScoreBoard");
		
		JPanel north = new JPanel(new FlowLayout());
		north.add(new NewGameButton("New Game"));
		north.add(new ExitButton("Exit"));
		
		JPanel south = new JPanel(new FlowLayout());
		//south.add(new CountButton("Count", count, this)); 
		south.add(new StayButton("Stay", dealer, computer, gframe));
		south.add(new HitButton("Hit", dealer, player, gframe));
		
		// computer
		JPanel east = new JPanel(new FlowLayout());
		east.add(computerlabel);
		
		// player
		JPanel west = new JPanel(new FlowLayout());
		west.add(playerlabel);
		
		JPanel center = new JPanel(new FlowLayout());
		center.add(scoreboard);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(north, BorderLayout.NORTH);
		cp.add(south, BorderLayout.SOUTH);
		cp.add(west, BorderLayout.WEST);
		cp.add(east, BorderLayout.EAST);
		cp.add(center, BorderLayout.CENTER);
		
		setTitle("BlackJack");
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}

	public void updateMyCard() {
		Card c1 = dealer.newcard1Return();
		Card c2 = dealer.newcard2Return();
		playerlabel.setText("Player" + "\n" + "---지금 들고 있는 카드---"
				+ dealer.newcardSuit(c1) + " " + dealer.newcardInt(c1) + "\n"
				+ dealer.newcardSuit(c2) + " " + dealer.newcardInt(c2));
		playerlabel.repaint();
	}
	
	public void update() {
//		label.setText("count = " + count.countOf());
		// scoreboard.setText("test test test");
		// 플레이어/컴퓨터 패 갱신해서 보여주기
		
		
		// 누가 이겼나?
		// 2면 블랙잭으로 이김, 1이면 이김, 0이면 비김, -1이면 졌음
		int winner = blackjack.whoisWinner();
		
		// 점수는 얼만가?
		gamescore += blackjack.finalScore();
		if (winner == 2) {
			scoreboard.setText("축하합니다! 블랙잭으로 이겼습니다."
					+ "\n" + "점수: " + gamescore);
		}
		else if (winner == 1) {
			scoreboard.setText("축하합니다! 이겼습니다."
					+ "\n" + "점수: " + gamescore);
		}
		else if (winner == 0) {
			scoreboard.setText("비겼습니다."
					+ "\n" + "점수: " + gamescore);
		}
		else {
			scoreboard.setText("졌습니다."
					+ "\n" + "점수: " + gamescore);
		}
		scoreboard.repaint();
	}

	public Hand computerHand() {
		return cHand;
	}
	
	public Hand playerHand() {
		return pHand;
	}
	

//	public String playerHandString() {
//		return pHand.toString();
//	}


	public static void main(String[] args) {
		new GameboardFrame();
	}
}
	