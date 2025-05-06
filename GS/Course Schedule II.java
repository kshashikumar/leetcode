class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] preq:prerequisites){
            int course = preq[0], req = preq[1];

            graph.get(req).add(course);
            indegree[course]++;
        }

        int[] order = new int[numCourses];
        int idx =0;

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int course = q.poll();

            order[idx++] = course;

            for(int t:graph.get(course)){
                indegree[t]--;
                if(indegree[t] == 0){
                    q.offer(t);
                }
            } 

        }

        if( idx == numCourses ){
            return order;
        } 
        return new int[0];

    }
}