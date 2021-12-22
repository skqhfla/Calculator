package Design;

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

import javax.swing.JFrame;
import javax.swing.JTextField;

import calculator.Calculate;
import out.PrintFile;
import javax.swing.JButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Design extends JFrame implements ActionListener {
	Calculate cal = new Calculate();
	private JTextField textField;

	public Design() throws FileNotFoundException {
		getContentPane().setBackground(Color.BLACK);
		setTitle("Calculator");
		setSize(375, 300);
		setBackground(Color.BLACK);

		addWindowListener(new WindowDestroyer());

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 10, 55, 55, 55, 55, 55, 55, 10, 0 };
		gridBagLayout.rowHeights = new int[] { 15, 50, 10, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Dialog", Font.PLAIN, 25));
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.BLACK);
		textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 6;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		// 초기화
		RoundedButton button_reset = new RoundedButton("AC");
		button_reset.setFont(new Font("Dialog", Font.BOLD, 12));
		button_reset.setForeground(Color.BLACK);
		button_reset.setBackground(new Color(153, 153, 153));
		GridBagConstraints gbc_button_reset = new GridBagConstraints();
		gbc_button_reset.fill = GridBagConstraints.BOTH;
		gbc_button_reset.insets = new Insets(0, 0, 5, 5);
		gbc_button_reset.gridx = 3;
		gbc_button_reset.gridy = 3;
		getContentPane().add(button_reset, gbc_button_reset);

		// 한글자 지우기
		RoundedButton button_delete = new RoundedButton("Del");
		button_delete.setFont(new Font("Dialog", Font.BOLD, 12));
		button_delete.setForeground(Color.BLACK);
		button_delete.setBackground(new Color(153, 153, 153));
		GridBagConstraints gbc_button_delete = new GridBagConstraints();
		gbc_button_delete.fill = GridBagConstraints.BOTH;
		gbc_button_delete.insets = new Insets(0, 0, 5, 5);
		gbc_button_delete.gridx = 4;
		gbc_button_delete.gridy = 3;
		getContentPane().add(button_delete, gbc_button_delete);

		// 퍼센트
		RoundedButton button_percent = new RoundedButton("%");
		button_percent.setFont(new Font("Dialog", Font.BOLD, 12));
		button_percent.setForeground(Color.BLACK);
		button_percent.setBackground(new Color(153, 153, 153));
		GridBagConstraints gbc_button_percent = new GridBagConstraints();
		gbc_button_percent.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_percent.insets = new Insets(0, 0, 5, 5);
		gbc_button_percent.gridx = 5;
		gbc_button_percent.gridy = 3;
		getContentPane().add(button_percent, gbc_button_percent);
		button_percent.addActionListener(this);

		// 루트
		RoundedButton button_root = new RoundedButton("\u221Ax");
		button_root.setFont(new Font("Dialog", Font.BOLD, 12));
		button_root.setForeground(Color.WHITE);
		button_root.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_root = new GridBagConstraints();
		gbc_button_root.fill = GridBagConstraints.BOTH;
		gbc_button_root.insets = new Insets(0, 0, 5, 5);
		gbc_button_root.gridx = 1;
		gbc_button_root.gridy = 4;
		getContentPane().add(button_root, gbc_button_root);

		// 파이
		RoundedButton button_pie = new RoundedButton("\u03C0");
		button_pie.setFont(new Font("Dialog", Font.BOLD, 12));
		button_pie.setForeground(Color.WHITE);
		button_pie.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_pie = new GridBagConstraints();
		gbc_button_pie.fill = GridBagConstraints.BOTH;
		gbc_button_pie.insets = new Insets(0, 0, 0, 5);
		gbc_button_pie.gridx = 1;
		gbc_button_pie.gridy = 7;
		getContentPane().add(button_pie, gbc_button_pie);

		// 팩토리얼
		RoundedButton button_factorial = new RoundedButton("x!");
		button_factorial.setFont(new Font("Dialog", Font.BOLD, 12));
		button_factorial.setForeground(Color.WHITE);
		button_factorial.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_factorial = new GridBagConstraints();
		gbc_button_factorial.fill = GridBagConstraints.BOTH;
		gbc_button_factorial.insets = new Insets(0, 0, 5, 5);
		gbc_button_factorial.gridx = 2;
		gbc_button_factorial.gridy = 4;
		getContentPane().add(button_factorial, gbc_button_factorial);
		button_factorial.addActionListener(this);

		// 분수
		RoundedButton button_fractions = new RoundedButton("1/x");
		button_fractions.setFont(new Font("Dialog", Font.BOLD, 12));
		button_fractions.setForeground(Color.WHITE);
		button_fractions.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_fractions = new GridBagConstraints();
		gbc_button_fractions.fill = GridBagConstraints.BOTH;
		gbc_button_fractions.insets = new Insets(0, 0, 5, 5);
		gbc_button_fractions.gridx = 1;
		gbc_button_fractions.gridy = 5;
		getContentPane().add(button_fractions, gbc_button_fractions);

		// 로그
		RoundedButton buttton_log = new RoundedButton("log");
		buttton_log.setFont(new Font("Dialog", Font.BOLD, 12));
		buttton_log.setForeground(Color.WHITE);
		buttton_log.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_buttton_log = new GridBagConstraints();
		gbc_buttton_log.fill = GridBagConstraints.BOTH;
		gbc_buttton_log.insets = new Insets(0, 0, 5, 5);
		gbc_buttton_log.gridx = 1;
		gbc_buttton_log.gridy = 6;
		getContentPane().add(buttton_log, gbc_buttton_log);

		// 제곱
		RoundedButton button_pow = new RoundedButton("x\u00B2");
		button_pow.setFont(new Font("Dialog", Font.BOLD, 12));
		button_pow.setForeground(Color.WHITE);
		button_pow.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_pow = new GridBagConstraints();
		gbc_button_pow.fill = GridBagConstraints.BOTH;
		gbc_button_pow.insets = new Insets(0, 0, 5, 5);
		gbc_button_pow.gridx = 1;
		gbc_button_pow.gridy = 3;
		getContentPane().add(button_pow, gbc_button_pow);

		// 절대값
		RoundedButton button_abs = new RoundedButton("abs");
		button_abs.setFont(new Font("Dialog", Font.BOLD, 12));
		button_abs.setForeground(Color.WHITE);
		button_abs.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_abs = new GridBagConstraints();
		gbc_button_abs.fill = GridBagConstraints.BOTH;
		gbc_button_abs.insets = new Insets(0, 0, 5, 5);
		gbc_button_abs.gridx = 2;
		gbc_button_abs.gridy = 3;
		getContentPane().add(button_abs, gbc_button_abs);

		// 사인
		RoundedButton button_sin = new RoundedButton("sin");
		button_sin.setFont(new Font("Dialog", Font.BOLD, 12));
		button_sin.setForeground(Color.WHITE);
		button_sin.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_sin = new GridBagConstraints();
		gbc_button_sin.fill = GridBagConstraints.BOTH;
		gbc_button_sin.insets = new Insets(0, 0, 5, 5);
		gbc_button_sin.gridx = 2;
		gbc_button_sin.gridy = 5;
		getContentPane().add(button_sin, gbc_button_sin);
		button_sin.addActionListener(this);
		
		// 코사인
		RoundedButton button_cos = new RoundedButton("cos");
		button_cos.setFont(new Font("Dialog", Font.BOLD, 12));
		button_cos.setForeground(Color.WHITE);
		button_cos.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_cos = new GridBagConstraints();
		gbc_button_cos.fill = GridBagConstraints.BOTH;
		gbc_button_cos.insets = new Insets(0, 0, 5, 5);
		gbc_button_cos.gridx = 2;
		gbc_button_cos.gridy = 6;
		getContentPane().add(button_cos, gbc_button_cos);
		button_cos.addActionListener(this);

		// 탄젠트
		RoundedButton button_tan = new RoundedButton("tan");
		button_tan.setFont(new Font("Dialog", Font.BOLD, 12));
		button_tan.setForeground(Color.WHITE);
		button_tan.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_tan = new GridBagConstraints();
		gbc_button_tan.fill = GridBagConstraints.BOTH;
		gbc_button_tan.insets = new Insets(0, 0, 0, 5);
		gbc_button_tan.gridx = 2;
		gbc_button_tan.gridy = 7;
		getContentPane().add(button_tan, gbc_button_tan);
		button_tan.addActionListener(this);

		// 더하기
		RoundedButton button_add = new RoundedButton("+");
		button_add.setFont(new Font("Dialog", Font.BOLD, 12));
		button_add.setForeground(Color.WHITE);
		button_add.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_add = new GridBagConstraints();
		gbc_button_add.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_add.insets = new Insets(0, 0, 5, 5);
		gbc_button_add.gridx = 6;
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
		gbc_button_subtract.gridx = 6;
		gbc_button_subtract.gridy = 5;
		getContentPane().add(button_subtract, gbc_button_subtract);

		// 곱하기
		RoundedButton button_multiply = new RoundedButton("x");
		button_multiply.setFont(new Font("Dialog", Font.BOLD, 12));
		button_multiply.setForeground(Color.WHITE);
		button_multiply.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_multiply = new GridBagConstraints();
		gbc_button_multiply.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_multiply.insets = new Insets(0, 0, 5, 5);
		gbc_button_multiply.gridx = 6;
		gbc_button_multiply.gridy = 4;
		getContentPane().add(button_multiply, gbc_button_multiply);

		// 나누기
		RoundedButton button_divide = new RoundedButton("\u00F7");
		button_divide.setFont(new Font("Dialog", Font.BOLD, 12));
		button_divide.setForeground(Color.WHITE);
		button_divide.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_divide = new GridBagConstraints();
		gbc_button_divide.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_divide.insets = new Insets(0, 0, 5, 5);
		gbc_button_divide.gridx = 6;
		gbc_button_divide.gridy = 3;
		getContentPane().add(button_divide, gbc_button_divide);

		// 결과
		RoundedButton button_result = new RoundedButton("=");
		button_result.setFont(new Font("Dialog", Font.BOLD, 12));
		button_result.setForeground(Color.WHITE);
		button_result.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_button_result = new GridBagConstraints();
		gbc_button_result.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_result.insets = new Insets(0, 0, 0, 5);
		gbc_button_result.gridx = 6;
		gbc_button_result.gridy = 7;
		getContentPane().add(button_result, gbc_button_result);

		// 숫자 더하기
		RoundedButton button_0 = new RoundedButton("0");
		button_0.setFont(new Font("Dialog", Font.BOLD, 12));
		button_0.setForeground(Color.WHITE);
		button_0.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_0 = new GridBagConstraints();
		gbc_button_0.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_0.gridwidth = 2;
		gbc_button_0.insets = new Insets(0, 0, 0, 5);
		gbc_button_0.gridx = 3;
		gbc_button_0.gridy = 7;
		getContentPane().add(button_0, gbc_button_0);

		RoundedButton button_1 = new RoundedButton("1");
		button_1.setFont(new Font("Dialog", Font.BOLD, 12));
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 3;
		gbc_button_1.gridy = 6;
		getContentPane().add(button_1, gbc_button_1);

		RoundedButton button_2 = new RoundedButton("2");
		button_2.setFont(new Font("Dialog", Font.BOLD, 12));
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2.gridx = 4;
		gbc_button_2.gridy = 6;
		getContentPane().add(button_2, gbc_button_2);

		RoundedButton button_3 = new RoundedButton("3");
		button_3.setFont(new Font("Dialog", Font.BOLD, 12));
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_3.insets = new Insets(0, 0, 5, 5);
		gbc_button_3.gridx = 5;
		gbc_button_3.gridy = 6;
		getContentPane().add(button_3, gbc_button_3);

		RoundedButton button_4 = new RoundedButton("4");
		button_4.setFont(new Font("Dialog", Font.BOLD, 12));
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_4.insets = new Insets(0, 0, 5, 5);
		gbc_button_4.gridx = 3;
		gbc_button_4.gridy = 5;
		getContentPane().add(button_4, gbc_button_4);

		RoundedButton button_5 = new RoundedButton("5");
		button_5.setFont(new Font("Dialog", Font.BOLD, 12));
		button_5.setForeground(Color.WHITE);
		button_5.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_5.insets = new Insets(0, 0, 5, 5);
		gbc_button_5.gridx = 4;
		gbc_button_5.gridy = 5;
		getContentPane().add(button_5, gbc_button_5);

		RoundedButton button_6 = new RoundedButton("6");
		button_6.setFont(new Font("Dialog", Font.BOLD, 12));
		button_6.setForeground(Color.WHITE);
		button_6.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_6.insets = new Insets(0, 0, 5, 5);
		gbc_button_6.gridx = 5;
		gbc_button_6.gridy = 5;
		getContentPane().add(button_6, gbc_button_6);

		RoundedButton button_7 = new RoundedButton("7");
		button_7.setFont(new Font("Dialog", Font.BOLD, 12));
		button_7.setForeground(Color.WHITE);
		button_7.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_7.insets = new Insets(0, 0, 5, 5);
		gbc_button_7.gridx = 3;
		gbc_button_7.gridy = 4;
		getContentPane().add(button_7, gbc_button_7);

		RoundedButton button_8 = new RoundedButton("8");
		button_8.setFont(new Font("Dialog", Font.BOLD, 12));
		button_8.setForeground(Color.WHITE);
		button_8.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_8 = new GridBagConstraints();
		gbc_button_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_8.insets = new Insets(0, 0, 5, 5);
		gbc_button_8.gridx = 4;
		gbc_button_8.gridy = 4;
		getContentPane().add(button_8, gbc_button_8);

		RoundedButton button_9 = new RoundedButton("9");
		button_9.setFont(new Font("Dialog", Font.BOLD, 12));
		button_9.setForeground(Color.WHITE);
		button_9.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_9 = new GridBagConstraints();
		gbc_button_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_9.insets = new Insets(0, 0, 5, 5);
		gbc_button_9.gridx = 5;
		gbc_button_9.gridy = 4;
		getContentPane().add(button_9, gbc_button_9);

		RoundedButton button_dot = new RoundedButton(".");
		button_dot.setFont(new Font("Dialog", Font.BOLD, 12));
		button_dot.setForeground(Color.WHITE);
		button_dot.setBackground(new Color(51, 51, 51));
		GridBagConstraints gbc_button_dot = new GridBagConstraints();
		gbc_button_dot.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_dot.insets = new Insets(0, 0, 0, 5);
		gbc_button_dot.gridx = 5;
		gbc_button_dot.gridy = 7;
		getContentPane().add(button_dot, gbc_button_dot);

		button_reset.addActionListener(this);
		button_percent.addActionListener(this);
		button_root.addActionListener(this);
		button_pie.addActionListener(this);
		button_fractions.addActionListener(this);
		buttton_log.addActionListener(this);
		button_pow.addActionListener(this);
		button_abs.addActionListener(this);
		button_delete.addActionListener(this);
		button_add.addActionListener(this);
		button_subtract.addActionListener(this);
		button_multiply.addActionListener(this);
		button_divide.addActionListener(this);
		button_result.addActionListener(this);
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
			cal.closePw();
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

	public void addString() {
		cal.setFirstvar(textField.getText());
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
			if (cal.getcalMode() == 0) {
				addString();
				cal.setcalMode(1);
			} else {
				cal.setcalMode(cal.result());
			}
		} else if (e.getActionCommand().equals("-")) {
			if (cal.getcalMode() == 0) {
				addString();
				cal.setcalMode(2);
			} else {
				cal.setcalMode(cal.result());
			}
		} else if (e.getActionCommand().equals("x")) {
			if (cal.getcalMode() == 0) {
				addString();
				cal.setcalMode(3);
			} else {
				cal.setcalMode(cal.result());
			}
		} else if (e.getActionCommand().equals("\u00F7")) {
			if (cal.getcalMode() == 0) {
				addString();
				cal.setcalMode(4);
			} else {
				cal.setcalMode(cal.result());
			}
		} else if (e.getActionCommand().equals("=")) {
			if (cal.getcalMode() == 0) {
				textField.setText(textField.getText());
			} else {
				cal.setAction(true);
				cal.setSecondvar(textField.getText());
				cal.setcalMode(cal.result());
				textField.setText(cal.getcalResult().toString());
				cal.setAction(false);
			}
		} else if (e.getActionCommand().equals("%")) {
			BigDecimal number = new BigDecimal(textField.getText());
			textField.setText(cal.Percent(number).toString());
		} else if (e.getActionCommand().equals("x!")) {
			BigDecimal number = new BigDecimal(textField.getText());
			textField.setText(cal.Factorial(number).toString());
		} else if (e.getActionCommand().equals("sin")) {
			double number = Double.parseDouble(textField.getText());
			textField.setText(cal.Sin(number).toString());
		} else if (e.getActionCommand().equals("cos")) {
			double number = Double.parseDouble(textField.getText());
			textField.setText(cal.Cos(number).toString());
		} else if (e.getActionCommand().equals("tan")) {
			double number = Double.parseDouble(textField.getText());
			textField.setText(cal.Tan(number).toString());
		} else if (e.getActionCommand().equals("abs")) {
			BigDecimal number = new BigDecimal(textField.getText()).abs();
			textField.setText(number.toString());
		} else if (e.getActionCommand().equals("\u221Ax")) {
			double number = Double.parseDouble(textField.getText());
			textField.setText(cal.Root(number).toString());
		} else if (e.getActionCommand().equals("\u03C0")) {
			BigDecimal number = new BigDecimal(textField.getText());
			textField.setText(cal.Pie(number).toString());
		} else if (e.getActionCommand().equals("1/x")) {
			BigDecimal number = new BigDecimal(textField.getText());
			textField.setText(cal.Fractions(number).toString());
		} else if (e.getActionCommand().equals("log")) {
			double number = Double.parseDouble(textField.getText());
			textField.setText(cal.Log(number).toString());
		} else if (e.getActionCommand().equals("x\u00B2")) {
			BigDecimal number = new BigDecimal(textField.getText());
			textField.setText(cal.Pow(number).toString());
		} else {
			String text = textField.getText();
			text += e.getActionCommand();
			textField.setText(text);
		}
	}
}