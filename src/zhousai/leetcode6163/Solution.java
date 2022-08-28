package zhousai.leetcode6163;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    int m = 401, n = (int) 1e4;
    int idxRow = 0, idxCol = 0;
    int[] heRow = new int[m], neRow = new int[n], eRow = new int[n], inDegreeRow = new int[m];
    int[] heCol = new int[m], neCol = new int[n], eCol = new int[n], inDegreeCol = new int[m];

    boolean[] visRow = new boolean[m], visCol = new boolean[m];

    void addRow(int a, int b) {
        eRow[idxRow] = b;
        neRow[idxRow] = heRow[a];
        heRow[a] = idxRow++;
        inDegreeRow[b]++;
        visRow[a] = true;
        visRow[b] = true;
    }

    void addCol(int a, int b) {
        eCol[idxCol] = b;
        neCol[idxCol] = heCol[a];
        heCol[a] = idxCol++;
        inDegreeCol[b]++;
        visCol[a] = true;
        visCol[b] = true;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Arrays.fill(heRow, -1);
        Arrays.fill(heCol, -1);
        int[][] ans = new int[k][k];
        for (int[] row : rowConditions) {
            addRow(row[0], row[1]);
        }
        for (int[] col : colConditions) {
            addCol(col[0], col[1]);
        }
        Deque<Integer> rowDeque = new ArrayDeque<>();
        int visRowNum = 0, visColNum = 0;
        for (int i = 1; i <= k; i++) {
            if (visRow[i] && inDegreeRow[i] == 0) {
                rowDeque.addLast(i);
            }
            if (visRow[i]) {
                visRowNum++;
            }
        }
        int[] numsRow = new int[k + 1];
        Arrays.fill(numsRow, -1);
        int rowSeq = 0, rowPollNum = 0;
        while (!rowDeque.isEmpty()) {
            int poll = rowDeque.pollFirst();
            rowPollNum++;
            numsRow[poll] = rowSeq++;
            for (int i = heRow[poll]; i != -1; i = neRow[i]) {
                int j = eRow[i];
                if (--inDegreeRow[j] == 0) {
                    rowDeque.addLast(j);
                }
            }
        }
        if (rowPollNum != visRowNum) {
            return new int[0][0];
        }
        Deque<Integer> colDeque = new ArrayDeque<>();
        for (int i = 1; i <= k; i++) {
            if (visCol[i] && inDegreeCol[i] == 0) {
                colDeque.addLast(i);
            }
            if (visCol[i]) {
                visColNum++;
            }
        }
        int[] numsCol = new int[k + 1];
        Arrays.fill(numsCol, -1);
        int colSeq = 0, colPollNum = 0;
        while (!colDeque.isEmpty()) {
            int poll = colDeque.pollFirst();
            colPollNum++;
            numsCol[poll] = colSeq++;
            for (int i = heCol[poll]; i != -1; i = neCol[i]) {
                int j = eCol[i];
                if (--inDegreeCol[j] == 0) {
                    colDeque.addLast(j);
                }
            }
        }
        if (visColNum != colPollNum) {
            return new int[0][0];
        }
        for (int i = 1; i <= k; i++) {
            int row = numsRow[i], col = numsCol[i];
            if (row == -1) {
                row = rowPollNum++;
            }
            if (col == -1) {
                col = colPollNum++;
            }
            ans[row][col] = i;
        }
        return ans;
    }
}