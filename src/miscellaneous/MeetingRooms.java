package miscellaneous;
import java.util.Arrays;

public class MeetingRooms {
    public static int countMeetingRooms(int[][] meetings) {
        if (meetings.length == 0) {
            return 0;
        }
        int n = meetings.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];
        for (int i = 0; i < n; i++) {
            startTimes[i] = meetings[i][0];
            endTimes[i] = meetings[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);
        int roomCount = 0;
        int endPointer = 0;

        for (int start : startTimes) {
            // If a meeting starts after the earliest meeting ends, we can free up a room
            if (start >= endTimes[endPointer]) {
                endPointer++; // Move to the next meeting that ends
            } else {
                roomCount++; // Need a new room
            }
        }
        return roomCount;
    }

    public static void main(String[] args) {
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Total meeting rooms required: " + countMeetingRooms(meetings)); // Output: 2
    }
}
