class Solution {

    public List<String> getNextPatterns(String temp){
        List<String> nextStates = new ArrayList<>();

        for(int i=0;i<4;i++){
            char[] charsUp = temp.toCharArray();
            char[] charsDown = temp.toCharArray();
            charsUp[i] = charsUp[i] =='9'?'0':(char)(charsUp[i]+1);
            nextStates.add(new String(charsUp));

            charsDown[i] = charsDown[i] == '0'?'9':(char)(charsDown[i]-1);
            nextStates.add(new String(charsDown));
        }
        return nextStates;
    }

    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet(Arrays.asList(deadends));

        Set<String> visited = new HashSet();
        Queue<String> q = new LinkedList<>();

        if(dead.contains("0000")) return -1;

        int moves = 0;

        q.offer("0000");
        visited.add("0000");

        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i=0;i<qSize;i++){
                String temp = q.poll();
                if(temp.equals(target)) return moves;

                for(String s: getNextPatterns(temp)){
                    if(!visited.contains(s) && !dead.contains(s)){
                        q.offer(s);
                        visited.add(s);
                    }
                }
            }

            moves++;
        }

        return -1;

    }
}