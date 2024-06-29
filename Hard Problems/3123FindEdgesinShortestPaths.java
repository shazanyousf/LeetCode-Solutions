class Solution {
    class Edge{
        int node;
        int weight;
        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public boolean[] findAnswer(int n, int[][] edges) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge: edges) {
            graph.get(edge[0]).add(new Edge(edge[1], edge[2]));
            graph.get(edge[1]).add(new Edge(edge[0], edge[2]));
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.offer(new Edge(0, 0));
        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int currentNode = current.node;
            int currentWeight = current.weight;
            if(currentWeight > dist[currentNode]) {
                continue;
            }
            for(Edge neighbor: graph.get(currentNode)) {
                if(dist[currentNode] + neighbor.weight < dist[neighbor.node]) {
                    dist[neighbor.node] = dist[currentNode] + neighbor.weight;
                    pq.offer(new Edge(neighbor.node, dist[neighbor.node]));
                }
            }
        }
        Set<String> shortestPathEdges = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n - 1);
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            for(Edge neighbor: graph.get(currentNode)) {
                if(dist[currentNode] - neighbor.weight == dist[neighbor.node]) {
                    String edge = neighbor.node + ":" + currentNode;
                    shortestPathEdges.add(edge);
                    queue.add(neighbor.node);
                }
            }
        }
        boolean[] answer = new boolean[edges.length];
        for(int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            String edgeForward = edge[0] + ":" + edge[1];
            String edgeBackward = edge[1] + ":" + edge[0];;
            if(shortestPathEdges.contains(edgeForward) || shortestPathEdges.contains(edgeBackward)) {
                answer[i] = true;
            }
        }
        return answer;
    }
}