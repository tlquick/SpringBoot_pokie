package com.tlquick.pokie.models;

import com.tlquick.pokie.models.utils.Record;
import com.tlquick.pokie.models.utils.Symbol;

import lombok.ToString;

public class Line extends Record {
	private String result = "JJJ";

	public Line(int number) {
		super(number);
	}

	public void spin(Reels reels) {
		result = reels.getResult(number);
	}

	public int payOff() {
		int payoff = 0;
		for (Symbol symbol : Symbol.values()) {
			if (result.equals(symbol.getWin()))
				payoff = symbol.getPayoff();
		}
		return payoff;
	}
	public String toString()
	{
		return result;
	}

}
