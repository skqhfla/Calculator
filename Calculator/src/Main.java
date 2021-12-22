import java.io.FileNotFoundException;

import Design.Design;

public class Main {
	public static void main(String[] args) {
		Design window1 = null;
		try {
			window1 = new Design();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window1.setVisible(true);
	}
}
