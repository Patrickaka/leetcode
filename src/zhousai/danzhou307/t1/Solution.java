package zhousai.danzhou307.t1;

class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int res;
        int energySum = 0;
        for (int e : energy) {
            energySum += e;
        }
        res = Math.max((energySum - initialEnergy + 1), 0);
        for (int ex : experience) {
            if (initialExperience > ex) {
                initialExperience += ex;
            } else {
                res += ex - initialExperience + 1;
                initialExperience += (ex - initialExperience + 1 + ex);
            }
        }
        return res;
    }
}