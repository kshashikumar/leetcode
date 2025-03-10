public class Clone Graph
{
    // BFS traversal
     // Add elements to queue, and poll each element, in parallel add elements to map if not there to create new nodes and map them to existing neighbours
    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        Map<Node, Node> mp = new HashMap<>();

        q.add(node);

        Node root = new Node(node.val);
        mp.put(node, root);

        while (!q.isEmpty()) {

            Node inode = q.poll();

            for (Node neighbour : inode.neighbors) {

                if (!mp.containsKey(neighbour)) {
                    mp.put(neighbour, new Node(neighbour.val));
                    q.offer(neighbour);
                }

                mp.get(inode).neighbors.add(mp.get(neighbour));
            }

        }
        return root;
    }

    // DFS traversal
    public Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        for (int i = 0; i < node.neighbors.size(); i++) {
            cloneNode.neighbors.add(cloneGraph(node.neighbors.get(i)));
        }

        return cloneNode;

    }
}
