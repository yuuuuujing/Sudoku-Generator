public class SudokuGenerator
{
    public static int[][] board = new int[9][9];
    public static void main(String[] args)
    {
        int[] firstRow = randomRow();
        fillBoard(board, firstRow);
        printBoard(board);
    }
    
    public static int[] randomRow() {
    int[] a = new int[9];

    for (int i = 0; i < 9; i++) {
        int random = (int) (Math.random() * 9) + 1;
        boolean newNum = false;

        while (!newNum) {
            boolean duplicate = false;
            for (int j = 0; j < i; j++) {
                if (random == a[j]) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                newNum = true;
            } else {
                random = (int) (Math.random() * 9) + 1;
            }
        }

        a[i] = random;
    }

    return a;
    }
    
    public static int[] shiftRow(int[] row, int shift){
        int[] temp = new int[row.length];
        for (int i = 0; i < row.length; i++){
            temp[(i+shift) % row.length] = row[i];
        }
        return temp;
    }
    
    public static void fillBoard(int[][] board, int[] firstRow){
        board[0] = firstRow;
        for (int j = 1; j < 9; j++){
            int shift = 3;
            if (j % 3 == 0){
                shift = 1;
            }
            int[] nextRow = shiftRow(board[j-1], shift);
            board[j] = nextRow;
        }
    }
    
    public static void printBoard(int[][] board) {
    System.out.println("+-------+-------+-------+");
    for (int i = 0; i < 9; i++) {
        System.out.print("| ");
        
        for (int j = 0; j < 9; j++) {
            System.out.print(board[i][j] + " ");
            if ((j + 1) % 3 == 0) {
                System.out.print("| ");
            }
        }
        System.out.println();

        if ((i + 1) % 3 == 0) {
            System.out.println("+-------+-------+-------+");
        }
    }
}
    
}