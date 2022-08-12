import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private JButton btnPlayAgain;
	private int theNumber;
	private int numberOfTries = 0;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		
		try {
			int guess = Integer.parseInt(guessText);
			
			
			if (guess < theNumber) {
				numberOfTries = numberOfTries + 1;
				message = guess + " is too low. Try again.";
			}
			else if (guess > theNumber) {
				numberOfTries = numberOfTries + 1;
				message = guess + " is too high. Try again.";
			}
			else {
				message = guess + " is correct. You win after " + numberOfTries + " tries Let's play again!";
				btnPlayAgain.setVisible(true);
			}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();			
		}

		
	}
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
		btnPlayAgain.setVisible(false);
		lblOutput.setText("Enter a number above and click Guess!");
	}
	public GuessingGame() {
		setTitle("Udokwu's Hi-Lo Guessing Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblUdokwusGuessingGame = new JLabel("Udokwu's Guessing Game");
		lblUdokwusGuessingGame.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUdokwusGuessingGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblUdokwusGuessingGame.setBounds(6, 33, 438, 38);
		getContentPane().add(lblUdokwusGuessingGame);
		
		JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
		lblGuessANumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGuessANumber.setBounds(25, 104, 242, 26);
		getContentPane().add(lblGuessANumber);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setBounds(277, 104, 130, 26);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(156, 163, 117, 29);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(49, 226, 304, 16);
		getContentPane().add(lblOutput);
		
		btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		btnPlayAgain.setBounds(285, 163, 117, 29);
		btnPlayAgain.setVisible(false);
		getContentPane().add(btnPlayAgain);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}
