package com.tlquick.pokie.models;

import com.tlquick.pokie.models.utils.Record;
import com.tlquick.pokie.models.utils.Records;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Reels extends Records {
	public Reels(int number, int lines) {
		super();
		records = IntStream.range(0, number).mapToObj(i -> new Reel(i, lines))
				.collect(Collectors.toCollection(LinkedList::new));
	}

	public void spin() {
		for (Record reel : records) {
			((Reel) reel).spin();
		}
	}

	public String getResult(int line) {
		return records.stream().map(x -> ((Reel) x).getResult(line))
				.collect(Collectors.joining(""));
	}
}
