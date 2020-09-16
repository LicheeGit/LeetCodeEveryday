import java.util.HashSet;
import java.util.Set;

/**
 * @Author Lichee
 * @Date 2020/9/16 20:53
 * @Version 1.0
 * <p>
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/
 * Valid Sudoku
 */
public class ValidSudoku {
    public static void main(String args[]) {
        char[][] board = {
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','9','.','.','.','.','.','.','1'},
                {'8','.','.','.','.','.','.','.','.'},
                {'.','9','9','3','5','7','.','.','.'},
                {'.','.','.','.','.','.','.','4','.'},
                {'.','.','.','8','.','.','.','.','.'},
                {'.','1','.','.','.','.','4','.','9'},
                {'.','.','.','5','.','4','.','.','.'}
        };
        if (isValidSudoku(board)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> charMap = new HashSet<>(9);
            for (int j = 0; j < 9; j++) {
                if ('1' <= board[i][j] && board[i][j] <= '9') {
                    if (charMap.contains(board[i][j])) {
                        System.out.printf("%s[%d][%d] is contained", board[i][j], i, j);
                        return false;
                    }
                    charMap.add(board[i][j]);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            Set<Character> charMap = new HashSet<>(9);
            for (int j = 0; j < 9; j++) {
                if ('1' <= board[j][i] && board[j][i] <= '9') {
                    if (charMap.contains(board[j][i])) {
                        return false;
                    }
                    charMap.add(board[j][i]);
                }
            }
        }
        /*
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if('1'<=board[i][j] && board[i][j]<'9'){
                    for(int m=i+1;(m-i)<3&&m<9;m++){
                        for(int n=j+1;(n-j)<3&&n<9;n++){
                            if(board[i][j] == board[m][n]){
                                System.out.printf("%s[%d][%d] is equal to %s[%d][%d]",board[i][j],i,j,board[m][n],m,n);
                                return false;
                            }
                        }
                    }
                }
            }
        }*/
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> charMap = new HashSet<>(9);
                int index = 0;
                for (int m = i; (m - i) < 3 && m < 9; m++) {
                    for (int n = j; (n - j) < 3 && n < 9; n++) {
                        if ('1' <= board[m][n] && board[m][n] <= '9') {
                            if (charMap.contains(board[m][n])) {
                                System.out.printf("%s[%d][%d] is contained in 3", board[m][n], m, n);
                                return false;
                            }
                            charMap.add(board[m][n]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
