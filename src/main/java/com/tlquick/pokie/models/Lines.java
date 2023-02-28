package com.tlquick.pokie.models;

import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import com.tlquick.pokie.models.utils.Records;
import com.tlquick.pokie.models.utils.Symbol;

import jakarta.persistence.Transient;

@Component
public class Lines extends Records {

	private final int NUMBER_OF_REELS = 3;
	private final int NUMBER_OF_LINES = 3;
	@Transient
	private Reels reels;

	public Lines() {
		records = IntStream.range(0, NUMBER_OF_LINES).mapToObj(i -> new Line(i))
				.collect(Collectors.toCollection(LinkedList::new));
		reels = new Reels(NUMBER_OF_REELS, NUMBER_OF_LINES);
	}

	public void spin() {
		resetSpin();
		reels.spin();
		result = records.stream().peek(x -> ((Line) x).spin(reels)).map(n -> n.toString())
				.collect(Collectors.joining("\n"));
	}

	public String getResult(int number) {
		return ((Line) records.get(number)).toString();
	}

	public String getResult() {
		return result;
	}

	public String[][] getResultImages() {
		String[][] images = new String[NUMBER_OF_LINES][NUMBER_OF_REELS];
		// tokenise and set all chars to images
		for (int i = 0; i < NUMBER_OF_LINES; i++)// for each line
		{
			String lineResult = getResult(i); // has 3 reel results - use charAt()
			for (int j = 0; j < lineResult.length(); j++) {
				images[i][j] = getImage("" + lineResult.charAt(j));
			}
		}
		return images;
	}

	public String getImage(String result)// lookup symbol and find the image to show
	{
		String image = "";
		Optional<Symbol> found = Stream.of(Symbol.values()).filter(d -> d.getName().equals(result)).findFirst();
		if (found.isPresent())
			return found.get().getImage();
		else
			return image;

	}

	public int payOff(int betLines) {
		int payoff = records.stream().filter(x -> ((Line) x).getNumber() < betLines).map(x -> ((Line) x).payOff())
				.reduce(0, Integer::sum);
		return payoff;

	}
}
