package blackjack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NewGameButton extends JButton implements ActionListener {
	
	public NewGameButton(String label) {
		super(label);
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// 새 게임 시작
		// 새 덱 제작, 손패초기화, 점수초기화, 승패값 초기화
		// 게임판 카드 돌린거 다 지우기
		// 새로 고침(게임판 초기화)
		new GameboardFrame();
	}

}