import java.io.FileNotFoundException;

import calculator.Calculator;

public class Main {
	public static void main(String[] args) {
		Calculator window1 = null;
		try {
			window1 = new Calculator();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window1.setVisible(true);
	}
}
