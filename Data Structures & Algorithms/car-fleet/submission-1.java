
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[] times = new double[n];
        
        // Calculate the time to reach the target for each car
        for (int i = 0; i < n; i++) {
            times[i] = (double) (target - position[i]) / speed[i];
        }

        // Sort cars based on their positions in descending order (farthest car first)
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> position[b] - position[a]); // Sort based on position
        
        // Use a stack to track the number of fleets
        Stack<Double> stack = new Stack<>();
        
        // Traverse from the car closest to the destination
        for (int i = 0; i < n; i++) {
            int index = indices[i];
            // If the stack is empty or the current car's time is greater than the last car's time in the stack
            if (stack.isEmpty() || times[index] > stack.peek()) {
                stack.push(times[index]); // This car forms a new fleet
            }
        }
        
        // The size of the stack represents the number of fleets
        return stack.size();
    }
}
