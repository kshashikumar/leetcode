class Solution {
    public long minTime(int[] skill, int[] mana) {
        long[] done = new long[skill.length];

        for(int i=0;i<mana.length;i++){
            done[0] = done[0] + (skill[0] * mana[i]);

            for(int j=0;j<skill.length-1;j++){
                done[j+1] = Math.max(done[j+1],done[j]) + (skill[j+1] * mana[i]);
            }

            for(int j = skill.length-1;j>0;j--){
                done[j-1] = done[j] - (skill[j] *mana[i]);
            }
        }
        return done[skill.length-1];
    }
}