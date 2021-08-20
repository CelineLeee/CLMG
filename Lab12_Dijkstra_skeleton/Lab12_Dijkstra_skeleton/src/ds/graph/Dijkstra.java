package ds.graph;

import ds.queue.DistanceQueue;

public class Dijkstra {
    private DistanceQueue distQueue;
    private int[] prev;
    private double[] D;
    private Graph G;

    public Dijkstra(Graph G) {
    	D = new double[G.n()];
    	distQueue = new DistanceQueue(G.n());
    	prev = new int[G.n()];
    	this.G= G;
    }

    public void calculateShortestPath(Graph G, int start) {
        // Fill your code
    }

    private void printPathToEnd(Graph G, int end) {
		int v = end;
		StringBuffer ss = new StringBuffer();

		// Fill your code


    	System.out.println(ss.reverse().toString());
    }
    
    public void printAllPath(Graph G, int src) {    		
		// Fill your code
    }

    public int minVertex(Graph G) {
    	// Fill your code
    }
}
