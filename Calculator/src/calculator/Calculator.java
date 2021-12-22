package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.MathContext;

import javax.swing.JFrame;
import javax.swing.JTextField;

import out.PrintFile;
import out.WriteFile;

@SuppressWarnings("serial")
public class Calculator extends JFrame implements ActionListener {
	private JTextField textField;
	private String first = "";
	private int mode;
	private boolean isSuccess = false;
	private BigDecimal result;
	private PrintFile pf = new PrintFile();

	public Calculator() throws FileNotFoundException {
		getContentPane().setBackground(Color.BLACK);
		setTitle("Calculator");
		setSize(240, 300);
		setBackground(Color.BLACK);

		addWindowListener(new WindowDestroyer());

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 10, 45, 55, 55, 40, 10, 0 };
		gridBagLayout.rowHeights = new int[] { 15, 47, 8, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		// 입력창
		textField = new JTextField();
		textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		textField.setFont(new Font("Dialog", Font.PLAIN, 25));
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		// 초기화
		RoundedButton button_reset = new RoundedButton("AC");
		button_reset.setFont(new Font("Dialog", Font.BOLD, 12));
		button_reset.setForeground(new Color(0, 0, 0));
		button_reset.setBackground(new Color(153, 153, 153));
		GridBagConstraints gbc_button_reset = new GridBagConstraints();
		gbc_button_reset.fill = GridBagConstraints.BOTH;
		gbc_button_reset.insets = new Insets(0, 0, 5, 5);
		gbc_button_reset.gridx = 1;
		gbc_button_reset.gridy = 3;
		getContentPane().add(button_reset, gbc_button_reset);

		// 한글자 지우기
		RoundedButton button_delete = new RoundedButton("Del");
		button_delete.setFont(new Font("Dialog", Font.BOLD, 12));
		button_delete.setForeground(new Color(0, 0, 0));
		button_delete.setBackground(new Color(153, 153, 153));
		GridBagConstraints gbc_button_delete = new GridBagConstraints();
		gbc_button_delete.fill = GridBagConstraints.BOTH;
		gbc_button_delete.insets = new Insets(0, 0, 5, 5);
		gbc_button_delete.gridx = 2;
		gbc_button_delete.gridy = 3;
		getContentPane().add(button_delete, gbc_button_delete);

		// 퍼센트
		RoundedButton button_percent = new RoundedButton("%");
		button_percent.setFont(new Font("Dialog", Font.BOLD, 12));
		button_percent.setForeground(new Color(0, 0, 0));
		button_percent.setBackground(new Color(153, 153, 153));
		GridBagConstraints gbc_button_percent = new GridBagConstraints();
		gbc_button_percent.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_percent.insets = new Insets(0, 0, 5, 5);
		gbc_button_percent.gridx = 3;
		gbc_button_percent.gridy = 3;
		getContentPane().add(button_percent, gbc_button_percent);
		button_percent.addActionListener(this);

		// 더하기
		RoundedButton button_add = new RoundedButton("+");
		button_add.setFont(new Font("Dialog", Font.BOLD, 12));
		button_add.setForeground(new Color(255, 255, 255));
		button_add.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_add = new GridBagConstraints();
		gbc_button_add.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_add.insets = new Insets(0, 0, 5, 5);
		gbc_button_add.gridx = 4;
		gbc_button_add.gridy = 6;
		getContentPane().add(button_add, gbc_button_add);

		// 빼기
		RoundedButton button_subtract = new RoundedButton("-");
		button_subtract.setFont(new Font("Dialog", Font.BOLD, 12));
		button_subtract.setForeground(new Color(255, 255, 255));
		button_subtract.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_subtract = new GridBagConstraints();
		gbc_button_subtract.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_subtract.insets = new Insets(0, 0, 5, 5);
		gbc_button_subtract.gridx = 4;
		gbc_button_subtract.gridy = 5;
		getContentPane().add(button_subtract, gbc_button_subtract);

		// 곱하기
		RoundedButton button_multiply = new RoundedButton("x");
		button_multiply.setFont(new Font("Dialog", Font.BOLD, 12));
		button_multiply.setForeground(new Color(255, 255, 255));
		button_multiply.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_multiply = new GridBagConstraints();
		gbc_button_multiply.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_multiply.insets = new Insets(0, 0, 5, 5);
		gbc_button_multiply.gridx = 4;
		gbc_button_multiply.gridy = 4;
		getContentPane().add(button_multiply, gbc_button_multiply);

		// 나누기
		RoundedButton button_divide = new RoundedButton("\u00F7");
		button_divide.setFont(new Font("Dialog", Font.BOLD, 12));
		button_divide.setForeground(new Color(255, 255, 255));
		button_divide.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_divide = new GridBagConstraints();
		gbc_button_divide.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_divide.insets = new Insets(0, 0, 5, 5);
		gbc_button_divide.gridx = 4;
		gbc_button_divide.gridy = 3;
		getContentPane().add(button_divide, gbc_button_divide);

		// 결과
		RoundedButton button_result = new RoundedButton("=");
		button_result.setFont(new Font("Dialog", Font.BOLD, 12));
		button_result.setForeground(new Color(255, 255, 255));
		button_result.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_result = new GridBagConstraints();
		gbc_button_result.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_result.insets = new Insets(0, 0, 0, 5);
		gbc_button_result.gridx = 4;
		gbc_button_result.gridy = 7;
		getContentPane().add(button_result, gbc_button_result);

		// 숫자 더하기
		RoundedButton button_0 = new RoundedButton("0");
		button_0.setFont(new Font("Dialog", Font.BOLD, 12));
		button_0.setForeground(new Color(255, 255, 255));
		button_0.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_0 = new GridBagConstraints();
		gbc_button_0.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_0.gridwidth = 2;
		gbc_button_0.insets = new Insets(0, 0, 0, 5);
		gbc_button_0.gridx = 1;
		gbc_button_0.gridy = 7;
		getContentPane().add(button_0, gbc_button_0);

		RoundedButton button_1 = new RoundedButton("1");
		button_1.setFont(new Font("Dialog", Font.BOLD, 12));
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 6;
		getContentPane().add(button_1, gbc_button_1);

		RoundedButton button_2 = new RoundedButton("2");
		button_2.setFont(new Font("Dialog", Font.BOLD, 12));
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 2;
		gbc_button_2.gridy = 6;
		getContentPane().add(button_2, gbc_button_2);

		RoundedButton button_3 = new RoundedButton("3");
		button_3.setFont(new Font("Dialog", Font.BOLD, 12));
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 3;
		gbc_button_3.gridy = 6;
		getContentPane().add(button_3, gbc_button_3);

		RoundedButton button_4 = new RoundedButton("4");
		button_4.setFont(new Font("Dialog", Font.BOLD, 12));
		button_4.setForeground(new Color(255, 255, 255));
		button_4.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 1;
		gbc_button_4.gridy = 5;
		getContentPane().add(button_4, gbc_button_4);

		RoundedButton button_5 = new RoundedButton("5");
		button_5.setFont(new Font("Dialog", Font.BOLD, 12));
		button_5.setForeground(new Color(255, 255, 255));
		button_5.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 2;
		gbc_button_5.gridy = 5;
		getContentPane().add(button_5, gbc_button_5);

		RoundedButton button_6 = new RoundedButton("6");
		button_6.setFont(new Font("Dialog", Font.BOLD, 12));
		button_6.setForeground(new Color(255, 255, 255));
		button_6.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 3;
		gbc_button_6.gridy = 5;
		getContentPane().add(button_6, gbc_button_6);

		RoundedButton button_7 = new RoundedButton("7");
		button_7.setFont(new Font("Dialog", Font.BOLD, 12));
		button_7.setForeground(new Color(255, 255, 255));
		button_7.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 1;
		gbc_button_7.gridy = 4;
		getContentPane().add(button_7, gbc_button_7);

		RoundedButton button_8 = new RoundedButton("8");
		button_8.setFont(new Font("Dialog", Font.BOLD, 12));
		button_8.setForeground(new Color(255, 255, 255));
		button_8.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_8.insets = new Insets(0, 0, 5, 5);
		gbc_button_8.gridx = 2;
		gbc_button_8.gridy = 4;
		getContentPane().add(button_8, gbc_button_8);

		RoundedButton button_9 = new RoundedButton("9");
		button_9.setFont(new Font("Dialog", Font.BOLD, 12));
		button_9.setForeground(new Color(255, 255, 255));
		button_9.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_9.insets = new Insets(0, 0, 5, 5);
		gbc_button_9.gridx = 3;
		gbc_button_9.gridy = 4;
		getContentPane().add(button_9, gbc_button_9);

		RoundedButton button_dot = new RoundedButton(".");
		button_dot.setFont(new Font("Dialog", Font.BOLD, 12));
		button_dot.setForeground(new Color(255, 255, 255));
		button_dot.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_dot = new GridBagConstraints();
		gbc_button_dot.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_dot.insets = new Insets(0, 0, 0, 5);
		gbc_button_dot.gridx = 3;
		gbc_button_dot.gridy = 7;
		getContentPane().add(button_dot, gbc_button_dot);

		button_reset.addActionListener(this);
		button_percent.addActionListener(this);
		button_delete.addActionListener(this);
		button_divide.addActionListener(this);
		button_multiply.addActionListener(this);
		button_subtract.addActionListener(this);
		button_result.addActionListener(this);
		button_add.addActionListener(this);
		button_0.addActionListener(this);
		button_1.addActionListener(this);
		button_2.addActionListener(this);
		button_3.addActionListener(this);
		button_4.addActionListener(this);
		button_5.addActionListener(this);
		button_6.addActionListener(this);
		button_7.addActionListener(this);
		button_8.addActionListener(this);
		button_9.addActionListener(this);
		button_dot.addActionListener(this);
	}

	public class WindowDestroyer extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			pf.closePw();
			System.out.println("시스템 종료");
			System.exit(0); // 시스템 종료
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			tryingCorrectNumberFormats(e);
		} catch (NumberFormatException e2) {
			textField.setText("Error: Reenter Number.");
		}

	}

	public int result() {
		WriteFile.setFile(first);
		BigDecimal c = new BigDecimal(first);
		BigDecimal d = new BigDecimal(textField.getText());

		if (mode == 1) {
			result = c.add(d);
			WriteFile.setFile(WriteFile.getFile() + " + ");
		}

		else if (mode == 2) {
			result = c.subtract(d);
			WriteFile.setFile(WriteFile.getFile() + " - ");
		}

		else if (mode == 3) {
			result = c.multiply(d);
			WriteFile.setFile(WriteFile.getFile() + " x ");
		}

		else if (mode == 4) {
			result = c.divide(d, MathContext.DECIMAL32);
			WriteFile.setFile(WriteFile.getFile() + " \u00F7 ");
		}

		WriteFile.setFile(WriteFile.getFile() + d.toString());
		if (isSuccess == true) {
			WriteFile.setFile(WriteFile.getFile() + " = " + result.toString());
			pf.writeFile();
			WriteFile.setFile("");
		}
		textField.setText(result.toString());

		return 0;
	}
	
	public void addString() {
		first = textField.getText();
		textField.setText("");
	}

	private void tryingCorrectNumberFormats(ActionEvent e) {
		this.setBackground(Color.red);
		if (e.getActionCommand().equals("AC")) {
			textField.setText("");
		} else if (e.getActionCommand().equals("Del")) {
			String text = textField.getText();
			textField.setText(text.substring(0, text.length() - 1));
		} else if (e.getActionCommand().equals("+")) {
			if (mode == 0) {
				addString();
				mode = 1;
			} else {
				mode = result();
			}
		} else if (e.getActionCommand().equals("-")) {
			if (mode == 0) {
				addString();
				mode = 2;
			} else {
				mode = result();
			}
		} else if (e.getActionCommand().equals("x")) {
			if (mode == 0) {
				addString();
				mode = 3;
			} else {
				mode = result();
			}
		} else if (e.getActionCommand().equals("\u00F7")) {
			if (mode == 0) {
				addString();
				mode = 4;
			} else {
				mode = result();
			}
		} else if (e.getActionCommand().equals("=")) {
			if (mode == 0) {
				textField.setText(textField.getText());
			} else {
				isSuccess = true;
				mode = result();
				isSuccess = false;
			}
		} else if (e.getActionCommand().equals("%")) {
			BigDecimal c = new BigDecimal(textField.getText());
			BigDecimal d = new BigDecimal(String.valueOf(10.0));
			System.out.println("befor " + c + "\n" + d);
			c = c.divide(d);
			textField.setText(c.toString());
			System.out.println("after " + c + "\n" + d);
		} else {
			String text = textField.getText();
			text += e.getActionCommand();
			textField.setText(text);
		}
	}
}