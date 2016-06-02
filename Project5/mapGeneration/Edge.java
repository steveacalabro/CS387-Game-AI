package mapGeneration;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Edge implements Comparable<Edge> {
	private int node1;
	private int node2;
	private int weight;
	
	public Edge(int _node1, int _node2) {
		node1 = _node1;
		node2 = _node2;
		
		Random rand = new Random();
		int  n = rand.nextInt(10) + 1;
		weight = n;
	}
	
	public Edge(int _node1, int _node2, int _weight) {
		node1 = _node1;
		node2 = _node2;
		weight = _weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getNode1() {
		return node1;
	}
	
	public int getNode2() {
		return node2;
	}
	
	public String toString() {
		return Integer.toString(node1) + "->" + Integer.toString(node2) + ":" + Integer.toString(weight);
		//return getLetter(node1) + "->" + getLetter(node2) + ":" + Integer.toString(weight);
	}
	
	public int compareTo(Edge that) {
		if(this.getWeight() < that.getWeight()) {
			return this.getWeight();
		} else {
			return that.getWeight();
		}
    }
	
	public boolean equals(Edge that) {
		return (this.node1 == that.getNode1() && this.node2 == that.getNode2() && this.weight == that.getWeight());
	}
	
	public static void printEdgeList(ArrayList<Edge> edges) {
		for(int i = 0; i < edges.size(); i++) {
			System.out.println(edges.get(i).toString());
		}
	}

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
	
	public static boolean causeCycle(ArrayList<Edge> tree, Edge edge) {
		boolean node1Exists = false;
		boolean node2Exists = false;
		
		for(int i = 0; i < tree.size(); i ++) {
			if(tree.get(i).getNode1() == edge.getNode1() || tree.get(i).getNode2() == edge.getNode1()) {
				node1Exists = true;
			}
			if(tree.get(i).getNode1() == edge.getNode2() || tree.get(i).getNode2() == edge.getNode2()) {
				node2Exists = true;
			}
			
			if(node1Exists && node2Exists){
				break;
			}
		}
		
		return (node1Exists && node2Exists);
	}
	
	public static void calculateWeight(ArrayList<Edge> edges) {
		int weight = 0;
		for(int i = 0; i < edges.size(); i++) {
			weight += edges.get(i).getWeight();
		}
		
		System.out.println("Total weight: " + weight);
	}
}