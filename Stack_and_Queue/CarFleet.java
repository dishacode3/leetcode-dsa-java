package Stack_and_Queue;
import java.util.Arrays;

public class CarFleet {

    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        // Pair position and time to target for each car
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            // Time = (target - position) / speed
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        
        // Sort cars in descending order based on starting position
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        int fleetCount = 0;
        double currentMaxTime = 0.0;
        
        // Iterate through cars from closest to target to farthest
        for (int i = 0; i < n; i++) {
            double timeToTarget = cars[i][1];
            
            // If this car takes longer than the fleet ahead, it creates a new fleet
            if (timeToTarget > currentMaxTime) {
                fleetCount++;
                currentMaxTime = timeToTarget; // Update the bottleneck time for following cars
            }
        }
        
        return fleetCount;
    }

    public static void main(String[] args) {
        // Test Case 1
        int target1 = 12;
        int[] position1 = {10, 8, 0, 5, 3};
        int[] speed1 = {2, 4, 1, 1, 3};
        System.out.println("Output 1: " + carFleet(target1, position1, speed1)); // Expected: 3

        // Test Case 2
        int target2 = 10;
        int[] position2 = {3};
        int[] speed2 = {3};
        System.out.println("Output 2: " + carFleet(target2, position2, speed2)); // Expected: 1

        // Test Case 3
        int target3 = 100;
        int[] position3 = {0, 2, 4};
        int[] speed3 = {4, 2, 1};
        System.out.println("Output 3: " + carFleet(target3, position3, speed3)); // Expected: 1
    }
}