package com.target.barrenland;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Main class which prints all the fertile land area in square meters
 * 
 * @author likhithkumarmatta
 *
 */
public class BarrenLandProcessor {

	private static final Logger LOGGER = LogManager.getLogger(BarrenLandProcessor.class);

	public static void main(String[] args) throws IOException {

		Farm myFarm = new Farm();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String iterate = null;
		String repeated = new String(new char[50]).replace("\0", "*");

		do {
			try {
				LOGGER.info("Method: main(), Stage : Started");
				InputLoader.readFromSTDIN(myFarm, br);

			} catch (Exception e) {
				LOGGER.error("Execption while reading the input from STD. INPUT", e);
				System.exit(1);
			}

			FertileLandHelper.clearColoMatrix(myFarm);
			FertileLandHelper.colorBarrenFarm(myFarm);
			FertileLandHelper.getFertileLands(myFarm);

			LOGGER.info(repeated);
			LOGGER.info(FertileLandHelper.printOutput(myFarm));
			LOGGER.info(repeated);
			LOGGER.info("Method: main(), Stage : Ended");

			System.out.println("Do you want to continue: (Y/ N): ");
			iterate = br.readLine();

		} while (iterate.equalsIgnoreCase("Y"));
	}

}
