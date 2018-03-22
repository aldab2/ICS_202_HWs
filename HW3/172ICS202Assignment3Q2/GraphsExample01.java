import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.traverse.*; 

public class GraphsExample01 {
	public static void main(String[] args) {
		UndirectedGraph<Integer, DefaultEdge> g = 
			new SimpleGraph<Integer, DefaultEdge>(DefaultEdge.class);

        Integer i1 = 1;
        Integer i2 = 2;
        Integer i3 = 3;
        Integer i4 = 4;
        Integer i5 = 5;

        // add the vertices
        g.addVertex(i1);
        g.addVertex(i2);
        g.addVertex(i3);
        g.addVertex(i4);
        g.addVertex(i5);
        
        g.addEdge(i1, i2);
        g.addEdge(i1, i4);
        g.addEdge(i2, i3);
        g.addEdge(i2, i4);
        g.addEdge(i2, i5);
        g.addEdge(i3, i5);
      
      	System.out.println(g.toString());
      	
      	BreadthFirstIterator bfsi = new BreadthFirstIterator(g, i1);
      	while(bfsi.hasNext())
      		System.out.println(bfsi.next());
      	
	}
}