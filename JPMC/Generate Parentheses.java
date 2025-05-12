class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        backtrack(res,"",0,0,n);
        return res;
    }

    public void backtrack(List<String> res,String temp,int open, int close, int max){
        if(temp.length() == max*2){
            res.add(temp);
            return;
        }

        if(open<max){
            backtrack(res,temp+"(",open+1,close,max);
        }
        if(close<open){
            backtrack(res,temp+")",open,close+1,max);
        }
    }
}