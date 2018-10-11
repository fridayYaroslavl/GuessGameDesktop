package com.tarakanov.alex;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessGame extends JFrame {
	private JTextField textGuess;
	private JLabel lblOutput;
	private int theNumber, numOfTries;
	
	public GuessGame() {
		getContentPane().setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("\u0418\u0433\u0440\u0430 \"\u0423\u0433\u0430\u0434\u0430\u0439 \u0447\u0438\u0441\u043B\u043E\"");
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u0418\u0433\u0440\u0430 \"\u0423\u0433\u0430\u0434\u0430\u0439 \u0447\u0438\u0441\u043B\u043E\"");
		label.setForeground(Color.BLACK);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 22));
		label.setBounds(183, 29, 253, 54);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0447\u0438\u0441\u043B\u043E \u043E\u0442 1 \u0434\u043E 100: ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(132, 112, 253, 67);
		getContentPane().add(label_1);
		
		textGuess = new JTextField();
		textGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		textGuess.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textGuess.setBounds(397, 129, 51, 33);
		getContentPane().add(textGuess);
		textGuess.setColumns(10);
		
		JButton button = new JButton("\u041F\u0440\u043E\u0432\u0435\u0440\u0438\u0442\u044C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button.setBounds(237, 208, 145, 42);
		getContentPane().add(button);
		
		lblOutput = new JLabel("\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u0447\u0438\u0441\u043B\u043E \u0438 \u043D\u0430\u0436\u043C\u0438\u0442\u0435 \u043A\u043D\u043E\u043F\u043A\u0443 \"\u041F\u0440\u043E\u0432\u0435\u0440\u0438\u0442\u044C\"");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOutput.setBounds(40, 279, 535, 22);
		getContentPane().add(lblOutput);
	}
	
	public void checkGuess() {
		String guessText = textGuess.getText();
		String message = "";
		numOfTries++;
		try {
			int guess = Integer.parseInt(guessText);

			if (guess < theNumber)
				message = guess + " - меньше загаданного числа. Попробуй еще раз!";
			else if (guess > theNumber)
				message = guess + " - больше загаданного числа. Попробуй еще раз!";
			else {
				message = guess + " - правильное число! Угадал за " + numOfTries + " попыток!";
				newGame();
			}
		} catch (Exception e) {
			message = "Неправильный ввод! Вводите целые числа от 1 до 100";
			numOfTries--;
		} finally {
			lblOutput.setText(message);
			textGuess.requestFocus();
			textGuess.selectAll();
			textGuess.replaceSelection("");
		}
	}
	
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
		numOfTries = 0;
	}

	public static void main(String[] args) {
		GuessGame theGame = new GuessGame();
		theGame.newGame();
		theGame.setSize(new Dimension(625, 365));
		theGame.setVisible(true);

	}
}
