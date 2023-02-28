package com.tlquick.pokie.models.utils;

import java.util.LinkedList;
import java.util.stream.Collectors;

import jakarta.persistence.MappedSuperclass;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@MappedSuperclass
public class Records {
	protected LinkedList<Record> records = new LinkedList<>();
	protected String result = "";

	public void spin() {
		resetSpin();
	}

	public String getResult() {
		return records.stream().map(n -> n.toString()).collect(Collectors.joining("\n"));
	}

	protected void resetSpin() {
		result = "";
	}

	public int size() {
		return records.size();
	}

	public String toString() {
		return result;
	}
}
