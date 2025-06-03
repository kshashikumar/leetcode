class Solution {

    public List<String> getNextMoves(String temp){
        List<String> ans = new ArrayList<>();

        for(int i=0;i<4;i++){
            char[] cUp = temp.toCharArray();
            char[] cDown = temp.toCharArray();

            cUp[i] = cUp[i] == '9'? '0': (char)(cUp[i]+1);
            ans.add(new String(cUp));

            cDown[i] = cDown[i] == '0'? '9': (char)(cDown[i]-1);
            ans.add(new String(cDown));
        }

        return ans;

    }

    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        if(deads.contains("0000")) return -1;

        q.offer("0000");
        visited.add("0000");
        int moves =0;

        while(!q.isEmpty()){
            int qSize = q.size();

            for(int i=0;i<qSize;i++){
                String temp = q.poll();

                if(temp.equals(target)) return moves;

                for(String neighbour: getNextMoves(temp)){
                    if(!visited.contains(neighbour) && !deads.contains(neighbour)){
                        q.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}