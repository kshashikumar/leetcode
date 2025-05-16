class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String min =s;

        q.offer(s);
        visited.add(s);

        while(!q.isEmpty()){
            String cur = q.poll();
            if(cur.compareTo(min) < 0){
                min = cur;
            }

            char[] chArr = cur.toCharArray();
            for(int i=1;i<chArr.length;i=i+2){
                chArr[i] = (char)(((chArr[i] - '0' +a)%10)+'0');
            }

            String temp = new String(chArr);
            if(visited.add(temp)){
                q.offer(temp);
            }

            String temp2 = cur.substring(cur.length()-b) + cur.substring(0,cur.length()-b);
            if(visited.add(temp2)){
                q.offer(temp2);
            }

        }

        return min;

    }
}