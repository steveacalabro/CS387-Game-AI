package mapGeneration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GenerateMap {
	private static ArrayList<Integer> walls = new ArrayList<Integer>() {{
	    add(67);
	}};
	
	private static ArrayList<Integer> floors = new ArrayList<Integer>() {{
	    add(57);
	}};
	
	public static void main(String[] args) throws IOException {
		int width = 3;
		int height = 3;
		int[][] map = new int[(width*2)+1][(height*2)+1];
		
		for(int i = 0; i < (width*2)+1; i++) {
			for(int j = 0; j < (height*2)+1; j++) {
				map[i][j] = wall(0);
			}
		}
		
		//get row number
		for(int i = 0; i < width*height; i++) {
			int row = 2*(i/width)+1;
			int col = 2*(i%width)+1;
			
			map[row][col] = floor(0);
		}
		
		//The node map
		int nodeCount = 0;
		int[][] map2 = new int[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				map2[i][j] = nodeCount;
				nodeCount++;
			}
		}
		
		//Make edges
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width - 1; j++) {
				Edge e = new Edge(map2[i][j], map2[i][j+1]);
				edges.add(e);
			}
		}
		
		for(int i = 0; i < height - 1; i++) {
			for(int j = 0; j < width; j++) {
				Edge e = new Edge(map2[i][j], map2[i + 1][j]);
				edges.add(e);
			}
		}
		
		/* for testing
		edges.add(new Edge(0, 1, 8));
		edges.add(new Edge(1, 2, 5));
		edges.add(new Edge(3, 4, 2));
		edges.add(new Edge(4, 5, 3));
		edges.add(new Edge(6, 7, 10));
		edges.add(new Edge(7, 8, 4));
		edges.add(new Edge(0, 3, 8));
		edges.add(new Edge(1, 4, 9));
		edges.add(new Edge(2, 5, 9));
		edges.add(new Edge(3, 6, 1));
		edges.add(new Edge(4, 7, 7));
		edges.add(new Edge(5, 8, 6));
		*/
		
		Collections.sort(edges, new EdgeComparator());
		
		ArrayList<ArrayList<Integer>> s = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < width*height; i++) {
			ArrayList<Integer> e = new ArrayList<Integer>();
			e.add(i);
			s.add(e);
		}
		
		ArrayList<Edge> tree = new ArrayList<Edge>();
		for(int i = 0; i < edges.size(); i++) {
			Edge cur = edges.get(i);
			
			if(!s.get(cur.getNode1()).equals(s.get(cur.getNode2()))) {
				tree.add(cur);
				
				ArrayList<Integer> newList = new ArrayList<Integer>(s.get(cur.getNode1()));
				newList.addAll(s.get(cur.getNode2()));
				
				s.set(cur.getNode1(), newList);
				s.set(cur.getNode2(), newList);
				
				for(int x = 0; x < newList.size(); x++) {
					s.set(newList.get(x), newList);
				}
			}
		}

		Edge.printEdgeList(tree);
		
		int startx = -1;
		int starty = -1;
		
		//get row number
		for(int i = 0; i < tree.size(); i++) {
			Edge cur = tree.get(i);
			
			int row1 = 2*(cur.getNode1()/width)+1;
			int col1 = 2*(cur.getNode1()%width)+1;
			
			if(startx == -1) {
				startx = col1;
				starty = row1;
			}
			
			int row2 = 2*(cur.getNode2()/width)+1;
			int col2 = 2*(cur.getNode2()%width)+1;
			
			if(col2 > col1) {
				map[row1][col1+1] = floor(0);
			} else if(row2 > row1) {
				map[row1+1][col1] = floor(0);
			}
		}
		
		FileActions.createFile(startx, starty, (width*2)+1, (width*2)+1, map);
		
		System.out.println("Map Created");
	}
	
	public int[][] kruskalMap(int width, int height) {
		int[][] map = new int[width][height];
		
		return map;
	}
	
	public static int floor(int type) {
		return floors.get(type);
	}
	
	public static int wall(int type) {
		return walls.get(type);
	}
}
