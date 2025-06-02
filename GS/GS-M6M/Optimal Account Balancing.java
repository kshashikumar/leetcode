class Solution {

    public int dfs(int start, List<Integer> debts){
        int n = debts.size();

        while(start < n && debts.get(start) == 0){
            start++;
        }

        if(start == n){
            return 0;
        }

        int minTxns = Integer.MAX_VALUE;

        for(int i = start+1;i< debts.size();i++){
            int curDebt = debts.get(i);
            int startDebt = debts.get(start);

            if(curDebt * startDebt < 0){
                debts.set(i, curDebt + startDebt);
                int txns = 1 + dfs(start+1,debts);
                minTxns = Math.min(minTxns, txns);
                debts.set(i, curDebt);

                if(curDebt + startDebt == 0){
                    break;
                }
            }

        }

        return minTxns;
    }

    public int minTransfers(int[][] transactions) {
        Map<Integer,Integer> mp = new HashMap<>();

        for(int[] txn : transactions){
            mp.put(txn[0], mp.getOrDefault(txn[0],0)-txn[2]);
            mp.put(txn[1], mp.getOrDefault(txn[1],0)+txn[2]);    
        }

        List<Integer> debts = new ArrayList<>();
        for(int debt: mp.values()){
            if(debt != 0){
                debts.add(debt);
            }
        }
        return dfs(0,debts);
    }
}