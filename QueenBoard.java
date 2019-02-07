import java.util.ArrayList;

public class QueenBoard {
  private int[][] board;
  private ArrayList<int[]> queens;

  public QueenBoard(int size) {
    board = new int[size][size];
    queens = new ArrayList<int[]>();
  }

  private boolean addQueen(int r, int c) {
    if (board[r][c] == 0) return false;
    return true;
  }
}
