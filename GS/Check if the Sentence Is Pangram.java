public class Check if the Sentence Is Pangram {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<26) return false;
        Set<Character> s = new HashSet<>();

        for(int i=0;i<sentence.length();i++){
            s.add(sentence.charAt(i));
        }

        return s.size() == 26;
    }

    // Optimal
    public boolean checkIfPangram(String sentence) {
        if(sentence.length()<26) return false;

        for(char ch='a';ch<='z';ch++){
            if(sentence.indexOf(ch)<0){
                return false;
            }
        }

        return true;
    }
}
