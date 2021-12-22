package calculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import out.PrintFile;

public class Calculate {
	private PrintFile pf = new PrintFile();
	CalculateVariable calvar = new CalculateVariable();

	BigDecimal c = null;
	BigDecimal d = null;

	public void setFirstvar(String first) {
		calvar.setFirst(first);
	}

	public void setSecondvar(String second) {
		calvar.setSecond(second);
	}

	public int getcalMode() {
		return calvar.getMode();
	}

	public void setcalMode(int mode) {
		calvar.setMode(mode);
	}

	public void setAction(boolean success) {
		calvar.setSuccess(success);
	}

	public BigDecimal getcalResult() {
		return calvar.getResult();
	}

	public void closePw() {
		pf.closePw();
	}

	public BigDecimal Percent(BigDecimal n) {
		return n.divide(BigDecimal.TEN);
	}

	public BigDecimal Factorial(BigDecimal n) {
		if (n.compareTo(BigDecimal.ONE) != 1)
			return n;
		else
			return Factorial(n.subtract(BigDecimal.ONE)).multiply(n);
	}

	public BigDecimal Sin(double n) {
		return BigDecimal.valueOf(Math.sin(n)).setScale(15, RoundingMode.HALF_EVEN);
	}
	
	public BigDecimal Cos(double n) {
		return BigDecimal.valueOf(Math.cos(n)).setScale(15, RoundingMode.HALF_EVEN);
	}
	
	public BigDecimal Tan(double n) {
		return BigDecimal.valueOf(Math.tan(n)).setScale(15, RoundingMode.HALF_EVEN);
	}
	
	public BigDecimal Root(double n) {
		return BigDecimal.valueOf(Math.sqrt(n)).setScale(15, RoundingMode.HALF_EVEN);
	}
	
	public BigDecimal Pie(BigDecimal n) {
		BigDecimal pie = new BigDecimal("3.14159265359");
		return n.multiply(pie);
	}
	
	public BigDecimal Fractions(BigDecimal n) {
		return n.divide(n.multiply(n), MathContext.DECIMAL64);
	}
	
	public BigDecimal Pow(BigDecimal n) {
		return n.multiply(n);
	}
	
	public BigDecimal Log(double n) {
		return BigDecimal.valueOf(Math.log(n)).setScale(15, RoundingMode.HALF_EVEN);
	}
	
	public int result() {
		pf.setwriteFile(calvar.getFirst());
		c = new BigDecimal(calvar.getFirst());
		d = new BigDecimal(calvar.getSecond());

		if (calvar.getMode() == 1) {
			calvar.setResult(c.add(d));
			pf.setwriteFile(pf.getwriteFile() + " + ");
		}

		else if (calvar.getMode() == 2) {

			calvar.setResult(c.subtract(d));
			pf.setwriteFile(pf.getwriteFile() + " - ");
		}

		else if (calvar.getMode() == 3) {
			calvar.setResult(c.multiply(d));
			pf.setwriteFile(pf.getwriteFile() + " x ");
		}

		else if (calvar.getMode() == 4) {
			calvar.setResult(c.divide(d, MathContext.DECIMAL64));
			pf.setwriteFile(pf.getwriteFile() + " \u00F7 ");
		}

		pf.setwriteFile(pf.getwriteFile() + d.toString());
		if (calvar.isSuccess() == true) {
			pf.setwriteFile(pf.getwriteFile() + " = " + calvar.getResult().toString());
			pf.writeFile();
			pf.setwriteFile("");
		}
		return 0;
	}
}
