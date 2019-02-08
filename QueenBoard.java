import java.util.ArrayList;

public class QueenBoard {
  private int[][] board;
  private boolean empty;

  public QueenBoard(int size) {
    board = new int[size][size];
    empty = true;
  }

  private boolean addQueen(int r, int c) {
    if (board[r][c] != 0) return false;
    board[r][c]--;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
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
}
