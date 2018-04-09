package com.target.barrenland;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.lang.ArrayIndexOutOfBoundsException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class InputLoader {

	private static final Logger LOGGER = LogManager.getLogger(InputLoader.class);

	/**
	 * This method is used to parse a String variable to Integer
	 * 
	 * @param text
	 * @return
	 * 
	 * @throws Exception
	 */
	public static Integer tryParse(String text) throws Exception {
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Barren boundary coordinates are not integers.");
		}
	}

	/**
	 * This method is used to read the Inputs
	 * 
	 * @param input
	 * @param myfarm
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public static void readInput(String input, Farm myfarm) throws Exception {

		LOGGER.info("Method: readInput(), Stage : Started");
		LinkedList<Integer[]> allBarrenLands = new LinkedList<Integer[]>();
		String[] parts = input.split(",");

		for (String s : parts) {
			s = s.replace("\"", "");
			s = s.replaceAll("“|”", "");
			s = s.replaceAll("\\{|\\}", "");
			s = s.replaceAll("^ ", "");
			if (!s.isEmpty()) {
				String[] coord = s.split(" ");
				if (coord.length < 4) {
					// when 4 co-ordinates are not provided throw Exception
					LOGGER.error("Exception while reading the input values");
					throw new ArrayIndexOutOfBoundsException("Please provide all 4 co-ordinates");
				}
				if (tryParse(coord[0]) >= 0 && tryParse(coord[1]) >= 0 && tryParse(coord[2]) >= 0
						&& tryParse(coord[3]) >= 0 && tryParse(coord[0]) < myfarm.X_MAX
						&& tryParse(coord[2]) < myfarm.X_MAX && tryParse(coord[1]) < myfarm.Y_MAX
						&& tryParse(coord[3]) < myfarm.Y_MAX) {
					Integer[] temp = { tryParse(coord[0]), tryParse(coord[1]), tryParse(coord[2]), tryParse(coord[3]) };
					allBarrenLands.add(temp);
				} else {
					// when co-ordinates are out of the Max X and Y boundary
					LOGGER.error("Exception while reading the input values");
					throw new Exception("Barren Land OutOfBound");
				}
			}
		}
		myfarm.setAllBarrenLands(allBarrenLands);
		LOGGER.info("Method: readInput(), Stage : Ended");
	}

	public static void readFromSTDIN(Farm myFarm, BufferedReader br) throws Exception {
		System.out.println("ENTER THE CO-ORDINATE INPUTS AS BELOW GIVEN FORMAT FOR BARREN LANDS");
		System.out.println("{\" X11 Y11 X21 Y21\",\" X12 Y12 X22 Y22\", ......... } ");
		String s = br.readLine();
		readInput(s, myFarm);
	}

}
