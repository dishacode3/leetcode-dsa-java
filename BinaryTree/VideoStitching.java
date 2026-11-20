package BinaryTree;

import java.util.Arrays;

public class VideoStitching {

    public static int videoStitching(int[][] clips, int time) {

        Arrays.sort(clips, (a, b) -> a[0] - b[0]);

        int count = 0;
        int currentEnd = 0;
        int farthest = 0;
        int i = 0;

        while (currentEnd < time) {

            while (i < clips.length && clips[i][0] <= currentEnd) {
                farthest = Math.max(farthest, clips[i][1]);
                i++;
            }

            if (farthest == currentEnd) {
                return -1;
            }

            count++;
            currentEnd = farthest;
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] clips = {
            {0,2}, {4,6}, {8,10},
            {1,9}, {1,5}, {5,9}
        };

        int time = 10;

        int result = videoStitching(clips, time);

        System.out.println("Minimum number of clips: " + result);
    }
}
