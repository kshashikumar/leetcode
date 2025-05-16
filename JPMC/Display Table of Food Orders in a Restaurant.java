
class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String,Map<String,Integer>> mp = new HashMap<>();
        Set<String> s = new TreeSet<>();

        for(int i=0;i<orders.size();i++){
            String tabNo = orders.get(i).get(1);
            String dish = orders.get(i).get(2);

            mp.putIfAbsent(tabNo, new HashMap<>());
            Map<String, Integer> food = mp.get(tabNo);
            food.put(dish, food.getOrDefault(dish,0)+1);
            mp.put(tabNo,food);
            s.add(dish);
        } 

        List<List<String>> ans = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(s);

        List<String> tableNos = new ArrayList<>(mp.keySet());
        tableNos.sort((a,b) -> Integer.parseInt(a) - Integer.parseInt(b));

        ans.add(header);

        for(String table: tableNos){
            List<String> row = new ArrayList<>();
            row.add(table);
            Map<String,Integer> food = mp.get(table);
            for(String item : s){
                row.add(String.valueOf(food.getOrDefault(item,0)));
            }
            ans.add(row);
        }

        return ans;


    }
}