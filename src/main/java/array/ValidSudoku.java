package array;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        boolean ret = true;

        Map<Character, Integer> map;
        for (int i = 0; i < board.length; i++) {
            map = new HashMap<>();
            for (int j = 0; j < board[i].length; j++) {
                int row = i;
                int col = j;
                if(board[row][col] != '.') {
                    map.put(board[row][col], map.getOrDefault(board[row][col], 0) + 1);
                }
                ret = isValidMap(map);

                if (ret == false)
                    return ret;
            }
        }

        for (int i = 0; i < board.length; i++) {
            map = new HashMap<>();
            for (int j = 0; j < board[i].length; j++) {
                int row = j;
                int col = i;
                if(board[row][col] != '.') {
                    map.put(board[row][col], map.getOrDefault(board[row][col], 0) + 1);
                }
                ret = isValidMap(map);

                if (ret == false)
                    return ret;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map = new HashMap<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int row = 3 * i + k;
                        int col = 3 * j + l;
                        if(board[row][col] != '.') {
                            map.put(board[row][col], map.getOrDefault(board[row][col], 0) + 1);
                        }
                    }
                }
                ret = isValidMap(map);

                if (ret == false)
                    return ret;
            }
        }

        return ret;
    }

    public static boolean isValidMap(Map<Character, Integer> map) {
        for(Map.Entry el : map.entrySet()) {
            if ( Integer.parseInt(el.getValue().toString()) > 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] trueBoard = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        char[][] board = new char[][] {
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}};

        System.out.println(isValidSudoku(board));
    }
}
