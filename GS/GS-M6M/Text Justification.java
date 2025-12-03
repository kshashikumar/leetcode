class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i=0;

        while(i<words.length){
            int lineLen = words[i].length();
            int j =i+1;

            // find all words in this line
            while(j<words.length && lineLen + 1 + words[j].length() <= maxWidth){
                lineLen += 1 + words[j].length();
                j++;
            }

            // the words taken for this line are [i,j-1]
            StringBuilder sb = new StringBuilder();
            int spaceslots = j-i-1;
            int totSpaces = maxWidth - (lineLen - spaceslots);

            // last word or only one word in line
            if(j == words.length || spaceslots == 0){
                for(int k = i;k<j;k++){
                    sb.append(words[k]);
                    if(k<j-1) sb.append(" ");
                }

                int remspaces = maxWidth - sb.length();
                while(remspaces-- >0) sb.append(" ");
            } else {
                int evenspaces = totSpaces/spaceslots;
                int extraspace = totSpaces%spaceslots;

                for(int k =i;k<j;k++){
                    sb.append(words[k]);

                    if(k<j-1){
                        for(int s =0;s< evenspaces + (k-i < extraspace?1:0);s++){
                            sb.append(" ");
                        }
                    }
                } 
            }

            ans.add(sb.toString());
            i=j;
        }
        return ans;
    }
}