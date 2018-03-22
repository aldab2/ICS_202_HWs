import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

import org.jgrapht.*;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.*; 

public class GraphsExample01 {
	private static final String GraphsExample01 = null;
	public static void main(String[] args) {
		UndirectedGraph<Integer, DefaultEdge> g = 
			new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
			
		
		UndirectedGraph<Integer, DefaultEdge> graph = 
				new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);
		
		Scanner myFile= null ;
		FileInputStream instream = null;
		try {
			instream = new FileInputStream("sample2.txt");
			myFile = new Scanner(instream);	
		}
		catch(FileNotFoundException e) {
			
			System.out.println("err found wen opening file");
		}
		
		int numOfVertices = myFile.nextInt();
		
		HashMap<Integer, Integer> vertices = new HashMap<>();
		for(int i=0;i<numOfVertices;i++) {
			int vertex = myFile.nextInt();
			int phoneCnt = myFile.nextInt();
			vertices.put(vertex, phoneCnt);
			graph.addVertex(vertex);
		}
		System.out.println(vertices);
		while(myFile.hasNextInt()) {
			int vertex1 = myFile.nextInt();
			int vertex2 = myFile.nextInt();
			graph.addEdge(vertex1, vertex2);
			//System.out.println(vertex1+"  "+ vertex2);
			
		}
		
		System.out.println(graph);
		
		
		
		myFile.close();
		Scanner myKeyb = new Scanner(System.in);
		System.out.println("Enter the warehouse: ");
		int warehouse = myKeyb.nextInt();
		myKeyb.nextLine();
		System.out.println("Enter the number of phones: ");
		int phoneCnt = myKeyb.nextInt();
		myKeyb.nextLine();
		
		
      	int i=0;
      	int hub=0;
      	int totalPhone = 0;
        BreadthFirstIterator bfsi = new BreadthFirstIterator(graph, warehouse);
        DijkstraShortestPath dsp = new DijkstraShortestPath<>(graph);
        GraphPath shortestpath =null;
        
       if(bfsi.hasNext())
    	   bfsi.next(); // Skip the fisrt one
      	while(bfsi.hasNext() && (totalPhone< phoneCnt)) {
      	
      		int newNode = (int)bfsi.next();
      		totalPhone += vertices.get(newNode);
      		shortestpath = dsp.getPath(warehouse, newNode);
      		hub = shortestpath.getLength() - 1;
      		System.out.println("Vertex "+newNode + " has "+vertices.get(newNode)+" Phones with "+hub+" Hubs");
      	
      	}
            	
	
	
	
	}
}

	
	
