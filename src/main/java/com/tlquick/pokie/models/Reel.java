package com.tlquick.pokie.models;

import java.util.Collections;
import java.util.LinkedList;

import com.tlquick.pokie.models.utils.Icon;
import com.tlquick.pokie.models.utils.Record;
import com.tlquick.pokie.models.utils.Symbol;

public class Reel extends Record {
	private final int REEL_SIZE = 64;
	private int betLines[];// used to store result for each line
	private LinkedList<Icon> icons = new LinkedList<>();

	public Reel(int number, int lines) {
		super(number);
		betLines = new int[lines];
		build();
	}

	protected void build() {
		int j = 0;
		for (Symbol symbol : Symbol.values()) {
			for (int i = 0; i < symbol.getNumber(); i++) {
				icons.add(new Icon(j++, symbol.getName()));
			}
		}
		Collections.shuffle(icons);// randomise the order of icons
	}

	public void spin() {
		int random = (int) (Math.random() * REEL_SIZE);
		for (int i = 0; i < betLines.length; i++) {
			if (random > REEL_SIZE - 1)// need to check end of list
				random = 0;
			else
				betLines[i] = random;
			random++;
		}
	}

	public String getResult(int line) {
		Icon icon = icons.get(betLines[line]);
		return icon.getName();
	}
}
