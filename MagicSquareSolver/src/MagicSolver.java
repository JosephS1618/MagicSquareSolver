public class MagicSolver {
    private String[][] square;
    private int[] missing;
    private int dimension;
    private int magicSum;

    public MagicSolver(String[][] square, int[] missing) {
        this.square = square;
        this.missing = missing;
        this.dimension = square.length;
    }

    public String solve() {
        if (solveRecursively(0)) {
            return printSquare();
        } else {
            return "No solution found!";
        }
    }

    private boolean solveRecursively(int index) {
        if (index == missing.length) {
            return checkMagicSquare();
        }

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                // Check for an empty spot
                if (square[i][j].equals("x")) {
                    String original = square[i][j];
                    square[i][j] = String.valueOf(missing[index]); // Place the missing number
                    if (solveRecursively(index + 1)) { // Recursive call
                        return true;
                    }
                    square[i][j] = original; // Backtrack
                }
            }
        }
        return false; // No valid placement found
    }

    public boolean checkMagicSquare() {
        int n = square.length;
        magicSum = sumRow( 0); // Assume the sum of the first row is the "magic sum"

        // Check all rows
        for (int i = 1; i < n; i++) {
            if (sumRow( i) != magicSum) {
                return false;
            }
        }

        // Check all columns
        for (int j = 0; j < n; j++) {
            if (sumColumn( j) != magicSum) {
                return false;
            }
        }

        // Check main diagonal
        if (sumMainDiagonal() != magicSum) {
            return false;
        }

        // Check secondary diagonal
        if (sumSecondaryDiagonal() != magicSum) {
            return false;
        }

        return true; // If all rows, columns, and diagonals are equal
    }

    private int sumRow(int row) {
        int sum = 0;
        for (int j = 0; j < square.length; j++) {
            sum += Integer.parseInt(square[row][j]);
        }
        return sum;
    }

    private int sumColumn(int col) {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += Integer.parseInt(square[i][col]);
        }
        return sum;
    }

    private int sumMainDiagonal() {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += Integer.parseInt(square[i][i]);
        }
        return sum;
    }

    private int sumSecondaryDiagonal() {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += Integer.parseInt(square[i][square.length - 1 - i]);
        }
        return sum;
    }


    private String printSquare() {
        StringBuilder sb = new StringBuilder("Completed Magic Square:\n");
        for (String[] row : square) {
            for (String value : row) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        sb.append("Magic Sum: ").append(magicSum);
        return sb.toString();
    }
}
