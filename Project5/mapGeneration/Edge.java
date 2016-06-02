package mapGeneration;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Edge implements Comparable<Edge> {
	private int node1;
	private int node2;
	private int weight;
	
	/**
	 * The default constructor
	 * @param _node1
	 * @param _node2
	 */
	public Edge(int _node1, int _node2) {
		node1 = _node1;
		node2 = _node2;
		
		Random rand = new Random();
		int  n = rand.nextInt(10) + 1;
		weight = n;
	}
	
	/**
	 * A secondary constructor for testing
	 * @param _node1
	 * @param _node2
	 * @param _weight
	 */
	public Edge(int _node1, int _node2, int _weight) {
		node1 = _node1;
		node2 = _node2;
		weight = _weight;
	}
	
	/**
	 * Gets the weight of the Edge
	 * @return
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * Gets the first node of the edge
	 * @return
	 */
	public int getNode1() {
		return node1;
	}
	
	/**
	 * Gets the second node of the edge
	 * @return
	 */
	public int getNode2() {
		return node2;
	}
	
	/**
	 * Converts the edge to a more readable string
	 */
	public String toString() {
		return Integer.toString(node1) + "->" + Integer.toString(node2) + ":" + Integer.toString(weight);
		//return getLetter(node1) + "->" + getLetter(node2) + ":" + Integer.toString(weight);
	}
	
	/**
	 * Need this to compare the weights in the comparator
	 */
	public int compareTo(Edge that) {
		if(this.getWeight() < that.getWeight()) {
			return this.getWeight();
		} else {
			return that.getWeight();
		}
    }
	
	/**
	 * Need this to check weights
	 * @param that
	 * @return
	 */
	public boolean equals(Edge that) {
		return (this.node1 == that.getNode1() && this.node2 == that.getNode2() && this.weight == that.getWeight());
	}
	
	/**
	 * Takes in a list of edges to print
	 * @param edges
	 */
	public static void printEdgeList(ArrayList<Edge> edges) {
		for(int i = 0; i < edges.size(); i++) {
			System.out.println(edges.get(i).toString());
		}
	}
	
	/**
	 * I used this in development to make things easier
	 * @param i
	 * @return
	 */
	private String getLetter(int i) {
		switch(i){
			case 0:
				return "A";
			case 1:
				return "B";
			case 2:
				return "C";
			case 3:
				return "D";
			case 4:
				return "E";
			case 5:
				return "F";
			case 6:
				return "G";
			case 7:
				return "H";
			case 8:
				return "I";
			case 9:
				return "J";
			default:
				return "";
		}
	}
	
	/**
	 * This is used to calculate the weight of the MST I had it in here to check if my things were working correctly
	 * @param edges
	 */
	public static void calculateWeight(ArrayList<Edge> edges) {
		int weight = 0;
		for(int i = 0; i < edges.size(); i++) {
			weight += edges.get(i).getWeight();
		}
		
		System.out.println("Total weight: " + weight);
	}
}
