class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        StringBuilder prefix = new StringBuilder();

        List<List<String>> res = new ArrayList<>();

        for(int i=0;i<searchWord.length();i++){
            prefix.append(searchWord.charAt(i));

            PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> b.compareTo(a));

            for(String product: products){
                if(product.startsWith(prefix.toString())){
                    pq.offer(product);
                    if(pq.size() > 3){
                        pq.poll();
                    }
                }
            }

            LinkedList<String> suggestions = new LinkedList<>();

            while(!pq.isEmpty()){
                suggestions.addFirst(pq.poll());
            }
            res.add(suggestions);

        }

        return res;
    }
}