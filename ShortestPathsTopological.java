import java.util.Arrays;
import java.util.Stack;

public class ShortestPathsTopological {
    private int[] parent;
    private int s;
    private double[] dist;

    public ShortestPathsTopological(WeightedDigraph G, int s) {

        this.s = s;
        this.parent = new int[G.V()];
        this.dist = new double[G.V()];

        for (int i = 0; i < this.dist.length; i++) {
            this.dist[i] = Double.POSITIVE_INFINITY;
        }
        this.dist[this.s] = 0;

        TopologicalWD twd = new TopologicalWD(G);
        twd.dfs(this.s);
        Stack<Integer> order = twd.order();
        while (!order.isEmpty()) {
            int v = order.pop();
            for (DirectedEdge vw : G.incident(v)) {
                relax(vw);
            }
        }
    }

    public void relax(DirectedEdge e) {

        if (this.dist[e.to()] > this.dist[e.from()] + e.weight()) {
            this.parent[e.to()] = e.from();
            this.dist[e.to()] = this.dist[e.from()] + e.weight();
        }
    }

    public boolean hasPathTo(int v) {
        return parent[v] >= 0;
    }

    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int w = v; w != s; w = parent[w]) {
            path.push(w);
        }
        path.push(s);
        return path;
    }
}

