package com.target.barrenland;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 	Helper class to perform all the calculations 
 * 
 * @author likhithkumarmatta
 *
 */
public class FertileLandHelper {

	private static final Logger LOGGER = LogManager.getLogger(FertileLandHelper.class);

	/**
	 * This method is used to Set as 1 all nodes inside a barren rectangle
	 * 
	 * @param myFarm
	 */
	public static void colorBarrenFarm(Farm myFarm) {
		LOGGER.info("Method: colorBarrenFarm(), Stage : Started");

		ListIterator<Integer[]> iterator = myFarm.getAllBarrenLands().listIterator();
		int farmLand[][] = myFarm.getFarmLand();
		while (iterator.hasNext()) {

			Integer[] barrenblock = iterator.next();
			for (int i = barrenblock[0]; i <= barrenblock[2]; i++)
				for (int j = barrenblock[1]; j <= barrenblock[3]; j++)
					farmLand[i][j] = 1;
		}
		LOGGER.info("Method: colorBarrenFarm(), Stage : Ended");

	}

	/**
	 * This method is used to set array values with 0 inititially
	 * 
	 * @param myFarm
	 */
	public static void clearColoMatrix(Farm myFarm) {
		LOGGER.info("Method: clearColoMatrix(), Stage : Started");
		int farmLand[][] = myFarm.getFarmLand();
		for (int i = 0; i < myFarm.X_MAX; i++) {
			for (int j = 0; j < myFarm.Y_MAX; j++) {
				farmLand[i][j] = 0;
			}
		}
        LOGGER.info("Method: clearColoMatrix(), Stage : Ended");
	}

	/**
	 * 	This method is used to Add node to the queue to be be inspected
	 * @param i
	 * @param j
	 * @param myFarm
	 */
	public static void addQueue(int i, int j, Farm myFarm) {
//		LOGGER.info("Method: addQueue(), Stage : Started");
		int farmLand[][] = myFarm.getFarmLand();
		LinkedList<Integer[]> queue = myFarm.getQueue();

		if (farmLand[i][j] == 0) {
			queue.add(new Integer[] { i, j });
		}
//        LOGGER.info("Method: addQueue(), Stage : Ended");
	}

	/***
	 * 
	 * This method is used to Get fertile land out of barran land.
	 * 
	 * This is a type of BFS for disconnected components. We will traverse through
	 * the "Graph" giving the same color to all connected components. We will keep
	 * track of how many nodes each component has, and this will be the final area.
	 *
	 * @param myFarm
	 *            input is the farm
	 */
	@SuppressWarnings("static-access")
	public static void getFertileLands(Farm myFarm) {
		LOGGER.info("Method: getFertileLands(), Stage : Started");

		// better explanation of i, j, and the BFS algorithm
		int land = 1;
		int i = 0;
		int j = 0;
		int farmLand[][] = myFarm.getFarmLand();
		LinkedList<Integer[]> queue = myFarm.getQueue();
		HashMap<Integer, Integer> areasMap = myFarm.getAreasMap();

		while (i < myFarm.X_MAX && j < myFarm.Y_MAX) {

			if (queue.isEmpty()) {
				Integer node[] = { i, j };

				// If node[i][j] has not been visited add to queue
				// As the queue was empty, this is a new fertile land

				if (farmLand[i][j] == 0) {
					land++;
					areasMap.put(land, 0);
					queue.add(node);
				}

				// Make sure we pass through all the Land
				if (i == (myFarm.X_MAX - 1)) {
					i = 0;
					j++;
				} else
					i++;
			}

			if (!queue.isEmpty()) {
				Integer node[] = queue.pop();

				int x = node[0];
				int y = node[1];

				// To add fertile neighbours into the queue
				if (farmLand[x][y] == 0) {
					if (x > 0)
						addQueue(x - 1, y, myFarm);
					if (x < (myFarm.X_MAX - 1))
						addQueue(x + 1, y, myFarm);
					if (y > 0)
						addQueue(x, y - 1, myFarm);
					if (y < (myFarm.Y_MAX - 1))
						addQueue(x, y + 1, myFarm);

					farmLand[x][y] = land;
					areasMap.put(land, (areasMap.get(land) + 1));
				}
			}
		}
        LOGGER.info("Method: getFertileLands(), Stage : Ended");
	}

	/**
	 * This method is used to print the output
	 * 
	 * @param myFarm
	 * @return fertile land
	 */
	public static String printOutput(Farm myFarm) {
		HashMap<Integer, Integer> areasMap = myFarm.getAreasMap();
		int[] result = new int[areasMap.values().size()];
		int i = 0;

		for (Map.Entry<Integer, Integer> entry : areasMap.entrySet()) {
			result[i] = entry.getValue();
			i++;
		}

		Arrays.sort(result);
		return (Arrays.toString(result)).replaceAll("\\[|\\]|,", "");
	}
}
