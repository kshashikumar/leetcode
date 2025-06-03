class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            int preq = prerequisites[i][1];
            int course = prerequisites[i][0];
            graph.get(preq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[numCourses];
        int t=0;

        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int preq = q.poll();
            ans[t++] =  preq;

            for(int neighbour : graph.get(preq)){
                indegree[neighbour]--;

                if(indegree[neighbour] == 0){
                    q.offer(neighbour);
                }
            }

        }

        
        return t == numCourses? ans : new int[0];
    }
}