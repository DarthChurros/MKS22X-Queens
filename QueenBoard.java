import java.util.ArrayList;

public class QueenBoard {
  private int[][] board;

  public QueenBoard(int size) {
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c) {
    if (board[r][c] != 0) return false;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (r - c == i - j
        || board.length - r - c == board.length - i - j
        || r == i
        || c == j) {
          board[i][j]++;
        }
      }
    }
  board[r][c] = -1;
  return true;
  }

  private boolean removeQueen(int r, int c) {
    if (board[r][c] >= 0) return false;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (r - c == i - j
        || board.length - r - c == board.length - i - j
        || r == i
        || c == j) {
          board[i][j]--;
        }
      }
    }
  board[r][c] = 0;
  return true;
  }

  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != 0) {
          throw new IllegalStateException("Board must be empty to solve!");
        }
      }
    }
    return solve(0);
  }

  private boolean solve(int row) {
    if (row == board.length) {
      return true;
    }
    for (int col = 0; col < board[row].length; col++) {
      if (addQueen(row, col)) {
        if(solve(row + 1)) return true;
        removeQueen(row, col);
      }
    }
    return false;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != 0) {
          throw new IllegalStateException("Board must be empty to solve!");
        }
      }
    }
    return count(0);
  }

  private int count(int row) {
    if (row == board.length) {
      return 1;
    }
    int solutions = 0;
    for (int col = 0; col < board[row].length; col++) {
      if (addQueen(row, col)) {
        solutions += count(row + 1);
        removeQueen(row, col);
      }
    }
    return solutions;
  }

  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  */
  public String toString() {
    String ans = "";
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == -1) {
          ans += "Q ";
        } else {
          ans += "_ ";
        }
      }
      ans += '\n';
    }
    return ans;
  }

  public static void main(String[] args) {
    QueenBoard test;
    /*
    System.out.println(test.addQueen(4,3));
    System.out.println(test);
    System.out.println(test.addQueen(6,2));
    System.out.println(test);
    System.out.println(test.removeQueen(4,3));
    System.out.println(test);
    System.out.println(test.removeQueen(6,2));
    System.out.println(test);
    System.out.println(test.solve());
    System.out.println(test);
    */
    for (int i = 1; i < 9; i++) {
      test = new QueenBoard(i);
      System.out.println("solutions to "+i+": "+test.countSolutions());
      System.out.println(test);
    }
  }
}
