import java.util.ArrayList;

public class QueenBoard {
  private int[][] board;
  private boolean empty;

  public QueenBoard(int size) {
    board = new int[size][size];
    empty = true;
  }

  public boolean addQueen(int r, int c) {
    if (board[r][c] != 0) return false;
    board[r][c]--;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (r - c == i - j
        || (r == i) != (c == j)) {
          if (board[i][j] < 0) {
            board[i][j]--;
          } else {
            board[i][j]++;
          }
        }
      }
    }
    return true;
  }

  public String toString() {
    String ans = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        ans += (board[i][j] + " ");
      }
      ans += '\n';
    }
    return ans;
  }

  public static void main(String[] args) {
    QueenBoard test = new QueenBoard(8);
    System.out.println(test + "\n\n");
    System.out.println(test.addQueen(0,0));
    System.out.println(test + "\n\n");
    System.out.println(test.addQueen(0,1));
    System.out.println(test + "\n\n");
    System.out.println(test.addQueen(5,4));
    System.out.println(test + "\n\n");
  }
}
