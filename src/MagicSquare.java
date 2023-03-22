public class MagicSquare {

    /**
     *
     * @param array2d
     * @return the sum of the first row in array2d.
     */
    public static int calculateCheckSum(int[][] array2d) {
        int sum = 0;
        for (int i : array2d[0]) sum+=i;
        return sum;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each row in array2d is equal to checkSum or not.
     *         Because we have already determined the sum of the first row
     *         via the method 'calculateCheckSum', this method can begin
     *         iterating from the second row.
     */
    public static boolean magicRows(int[][] array2d, int checkSum) {
        int sum = 0;
        for(int[] row : array2d){
            sum = 0;
            for(int i: row){
                sum += i;
            }
            if(sum != checkSum) return false;
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each column in array2d is equal to checkSum or not.
     */
    public static boolean magicColumns(int[][] array2d, int checkSum) {
        for(int x = 0; x<array2d[0].length; x++) {
            int sum = 0;
            for (int i = 0; i < array2d.length; i++) {
                sum += array2d[i][x];
            }
            if(sum != checkSum) return false;
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each of the two main diagonals is equal to checkSum or not.
     */
    public static boolean magicDiagonals(int[][] array2d, int checkSum) {
        int diag = 0;
        int sum = 0;
        for (int i = 0; i < array2d.length; i++){
            sum+=array2d[i][diag];
            diag++;
        }
        if(sum == checkSum) return true;
        diag = array2d.length-1;
        sum = 0;
        for(int x = array2d.length-1; x >= 0; x--){
            sum+=array2d[x][diag];
            diag--;
        }
        if(sum == checkSum) return true;
        return false;
    }

    /**
     *
     * @param array2d
     * @return whether array2d is magic or not.
     */
    public static boolean isMagic(int[][] array2d) {
        int check = calculateCheckSum(array2d);
        if ((magicRows(array2d, check) == true) && (magicColumns(array2d, check) == true) && (magicDiagonals(array2d, check) == true)) {
            return true;
        }
        return false;
    }

}
