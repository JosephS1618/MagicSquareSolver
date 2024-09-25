public class Main {
    public static void main(String[] args) {
        int DIMENSION = 4;

        // Missing values from the square.
        int[] missing = {11, -4, -7, -16, -13, -34, -19};

        String[] data1 = {
                "x", "-31", "-28", "2",
                "-22", "x", "x", "x",
                "-10", "x", "x", "-1",
                "-25", "5", "8", "x"
        };

        String[] data2 = {
                "x", "12", "x", "x",
                "2", "x", "8", "x",
                "0", "x", "10", "24",
                "28", "x", "14", "4"
        };

        // Create an array with the dimensions
        String[][] square = new String[DIMENSION][DIMENSION];
        int index = 0;

        // Fill the array with the data from the magic square
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                square[i][j] = data1[index];
                index++;
            }
        }

        // Print the magic square
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }

        MagicSolver ms = new MagicSolver(square, missing);
        System.out.println(ms.solve());
    }
}