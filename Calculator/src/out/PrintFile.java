package out;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintFile {
	private static String path = "C:\\Users\\user\\Calculator\\out.txt";
	private PrintWriter pw = null;
	WriteFile wf = new WriteFile();

	public PrintWriter getPw() {
		return pw;
	}

	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}

	public void closePw() {
		pw.close();
	}

	public void writeFile() {
		pw.println(WriteFile.getFile());
		System.out.println(WriteFile.getFile());
	}

	public PrintFile() {
		try {
			pw = new PrintWriter(new FileWriter(path,true));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
