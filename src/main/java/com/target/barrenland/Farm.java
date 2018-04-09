package com.target.barrenland;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 	POJO Class which stores all the field values
 * 
 * @author likhithkumarmatta
 *
 */
public class Farm {
	
    //  Assign x and y coordinates values given in problem statement
    public final static int X_MAX = 400;
    public final static int Y_MAX = 600;
    
    // Create Linked List to store barren land coordinates
    LinkedList<Integer[]> allBarrenLands = new LinkedList<>();
    
    // create queue to hold coordinates while iterating to find fertile land
    LinkedList<Integer[]> queue = new LinkedList<>(); // what does queue do?
    
    // create HashMap names areasMap to find area of fertile land againist barren land
    HashMap<Integer, Integer> areasMap = new HashMap<>();
    
    // creating farm as array
    int farmLand[][] = new int[X_MAX][Y_MAX];

	public LinkedList<Integer[]> getAllBarrenLands() {
		return allBarrenLands;
	}

	public void setAllBarrenLands(LinkedList<Integer[]> allBarrenLands) {
		this.allBarrenLands = allBarrenLands;
	}

	public LinkedList<Integer[]> getQueue() {
		return queue;
	}

	public void setQueue(LinkedList<Integer[]> queue) {
		this.queue = queue;
	}

	public HashMap<Integer, Integer> getAreasMap() {
		return areasMap;
	}

	public void setAreasMap(HashMap<Integer, Integer> areasMap) {
		this.areasMap = areasMap;
	}

	public int[][] getFarmLand() {
		return farmLand;
	}

	public void setFarmLand(int[][] farmLand) {
		this.farmLand = farmLand;
	}

	public static int getxMax() {
		return X_MAX;
	}

	public static int getyMax() {
		return Y_MAX;
	}
    
    
}
