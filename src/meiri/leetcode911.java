package meiri;

class TopVotedCandidate {

    int[] persons;
    int[] times;
    int[] index;

    public TopVotedCandidate(int[] persons, int[] times) {
        int size = times.length;
        int[] index = new int[size];
        int[] person = new int[size];
        int max = 0;
        for (int i = 0; i < size; i++) {
            person[persons[i]]++;
            if (person[persons[i]] >= max) {
                max = person[persons[i]];
                index[i] = persons[i];
            } else{
                index[i] = index[i - 1];
            }
        }
        this.persons = persons;
        this.times = times;
        this.index = index;
    }

    public int q(int t) {
        int l = 0, r = times.length - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (times[m] <= t) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return index[l];
    }

    public static void main(String[] args) {
        int[] persons = {0, 1, 1, 0, 0, 1, 0};
        int[] times = {0, 5, 10, 15, 20, 25, 30};
        TopVotedCandidate obj = new TopVotedCandidate(persons, times);
        int param_1 = obj.q(15);
        System.out.println(param_1);
    }
}
