import java.util.Arrays;

public class TerrainSmoothing {

    public static void main(String[] args) {

        // Sample terrain 
        int[][] terrain = {
            {10, 12, 15, 14},
            {13, 99, 12, 11},
            {14, 13, 16, 15},
            {15, 17, 14, 13}
        };

        int k = 1; 

        int[][] smoothed = medianSmooth(terrain, k);

        System.out.println("Smoothed Terrain:");
        printTerrain(smoothed);
    }

    // Function to smooth out the terrain
    public static int[][] medianSmooth(int[][] terrain, int k) {
        int rows = terrain.length;
        int cols = terrain[0].length;

        int[][] smoothed = new int[rows][cols];

        // Loop through every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // Replace each cell with the median of its neighbors
                smoothed[i][j] = getMedianNeighbor(terrain, i, j, k);
            }
        }

        return smoothed;
    }

    // Function to get the median value from neighbors
    public static int getMedianNeighbor(int[][] terrain, int x, int y, int k) {
        int rows = terrain.length;
        int cols = terrain[0].length;

        int[] neighbors = new int[(2 * k + 1) * (2 * k + 1)];
        int count = 0;

        // Loop through the neighbors
        for (int dx = -k; dx <= k; dx++) {
            for (int dy = -k; dy <= k; dy++) {

                int nx = x + dx;
                int ny = y + dy;

                // Check if inside bounds
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    neighbors[count] = terrain[nx][ny];
                    count++;
                }
            }
        }
        int[] validNeighbors = Arrays.copyOf(neighbors, count);

        // Sort out the neighbors
        Arrays.sort(validNeighbors);

        // Return median
        return validNeighbors[count / 2];
    }

    // Helper function to print out the terrain
    public static void printTerrain(int[][] terrain) {
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[0].length; j++) {
                System.out.print(terrain[i][j] + "\t");
            }
            System.out.println();
        }
    }
}