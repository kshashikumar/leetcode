class Solution {

    public int dfs(int start,List<Integer> debts){

        int n = debts.size();
        while(start<n && debts.get(start) == 0){
            start++;
        }

        if(start == n){
            return 0;
        }


        int minTxns = Integer.MAX_VALUE;

        for(int i=start+1; i<debts.size() ;i++){

            int debtStart = debts.get(start), curdebt = debts.get(i);

            if(debtStart*curdebt < 0){
                debts.set(i,curdebt+debtStart);
                int txns  = 1+dfs(start+1,debts);
                minTxns = Math.min(minTxns,txns);
                debts.set(i,curdebt);

                if(curdebt+debtStart == 0) break;
            }
        }

        return minTxns;

    }

    public int minTransfers(int[][] transactions) {
        Map<Integer,Integer> mp = new HashMap<>();

        for(int[] txn : transactions){
            mp.put(txn[0],mp.getOrDefault(txn[0],0) - txn[2]);
            mp.put(txn[1],mp.getOrDefault(txn[1],0) + txn[2]);
        }

        List<Integer> debts = new ArrayList<>();

        for(int k : mp.keySet()){
            if(mp.get(k) !=0){
                debts.add(mp.get(k));
            }
        }

        return dfs(0,debts);
    }
}