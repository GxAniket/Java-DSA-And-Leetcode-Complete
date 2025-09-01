import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // PriorityQueue to store classes, ordered by the gain they provide
        // The element in the PQ is an array: [gain, passed_students, total_students]
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Calculate initial gain for each class and add to PQ
        for (int[] cls : classes) {
            double p = (double) cls[0];
            double t = (double) cls[1];
            
            // Gain is the increase in ratio: (p+1)/(t+1) - p/t = (t - p) / (t * (t+1))
            double gain = (t - p) / (t * (t + 1));
            pq.offer(new double[]{gain, p, t});
        }

        // Distribute extra students greedily
        for (int i = 0; i < extraStudents; i++) {
            double[] topClass = pq.poll();
            
            // Current stats of the class with the highest gain
            double p = topClass[1];
            double t = topClass[2];

            // Add one student
            p++;
            t++;
            
            // Calculate the new gain for this updated class and add back to PQ
            double newGain = (t - p) / (t * (t + 1));
            pq.offer(new double[]{newGain, p, t});
        }

        // Calculate the final average ratio
        double totalRatioSum = 0.0;
        while (!pq.isEmpty()) {
            double[] cls = pq.poll();
            totalRatioSum += cls[1] / cls[2];
        }

        return totalRatioSum / classes.length;
    }
}
