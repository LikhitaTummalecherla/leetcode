import java.util.*;

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Min-heap for available rooms (sorted by room number)
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }

        // Min-heap for ongoing meetings: (endTime, roomNumber)
        PriorityQueue<long[]> occupiedRooms = new PriorityQueue<>((a, b) -> 
            a[0] != b[0] ? Long.compare(a[0], b[0]) : Integer.compare((int)a[1], (int)b[1])
        );

        int[] roomCount = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            // Free up rooms that have ended by current start time
            while (!occupiedRooms.isEmpty() && occupiedRooms.peek()[0] <= start) {
                availableRooms.offer((int) occupiedRooms.poll()[1]);
            }

            if (!availableRooms.isEmpty()) {
                // Use the lowest-numbered available room
                int room = availableRooms.poll();
                occupiedRooms.offer(new long[]{end, room});
                roomCount[room]++;
            } else {
                // Delay the meeting - assign to earliest finishing room
                long[] earliest = occupiedRooms.poll();
                long newStart = earliest[0];
                int room = (int) earliest[1];
                long duration = end - start;
                occupiedRooms.offer(new long[]{newStart + duration, room});
                roomCount[room]++;
            }
        }

        // Find the room with the most meetings
        int maxMeetings = 0;
        int resultRoom = 0;
        for (int i = 0; i < n; i++) {
            if (roomCount[i] > maxMeetings) {
                maxMeetings = roomCount[i];
                resultRoom = i;
            }
        }

        return resultRoom;
    }
}