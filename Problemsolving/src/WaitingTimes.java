//https://leetcode.com/problems/average-waiting-time/description/
//Difficulty: Medium

public class WaitingTimes {

    public static void main(String[] args) {
        WaitingTimes waitingTimes = new WaitingTimes();
        int[][] customers = {{5, 2}, {5, 4}, {10, 3}, {20, 1}};
        System.out.println(waitingTimes.averageWaitingTime(customers));
    }

    public double averageWaitingTime(int[][] customers) {
        double endTime = 0, waitTime = 0;
        for (int[] customer : customers) {
            endTime = Math.max(endTime, customer[0]);
            endTime += customer[1];
            waitTime += endTime - customer[0];
        }

        return waitTime / customers.length;
    }
}
