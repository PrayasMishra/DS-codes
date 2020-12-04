package graphs;

import java.util.*;

public class CyclicGraph {
	private final int v;
	private final List<List<Integer>> adjacent;

	public CyclicGraph(int v) {
		this.v = v;
		adjacent = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			adjacent.add(new LinkedList<>());
		}
	}

	private void addEdge(int s, int des){ adjacent.get(s).add(des); }

	private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recurStack)
	{
		if (recurStack[i] == true)
			return true;
		else if (visited[i] == true)
			return false;
		else {
			visited[i] = true;
			recurStack[i] = true;
			List<Integer> babies = adjacent.get(i);

			for (Integer b : babies)
				if (isCyclicUtil(b, visited, recurStack))
					return true;

			recurStack[i] = false;
			return false;
		}
	}

	private boolean isCyclic() {
		boolean[] visited = new boolean[v];
		boolean[] recurStack = new boolean[v];

		for (int i = 0; i < v; i++) {
			if (isCyclicUtil(i,visited,recurStack))
				return true;
		}
		return false;
	}

	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter no of vertices...");
		CyclicGraph g1 = new CyclicGraph(sc.nextInt());

		System.out.println("add new edge? (y/n)...");
		char opt = sc.next().charAt(0);
		while(opt == 'y'|| opt == 'Y'){
			int s = sc.nextInt();
			int d = sc.nextInt();
			g1.addEdge(s,d);
			System.out.println("add new edge? (y/n)...");
			opt = sc.next().charAt(0);
		}

		if (g1.isCyclic())
			System.out.println("Graph has cycle.");
		else
			System.out.println("Graph has no cycle.");
	}
}
