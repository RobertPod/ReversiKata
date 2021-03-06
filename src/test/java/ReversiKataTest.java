import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ReversiKataTest {

//   B . . . . . . .
//   . . . . . . . .
//   . . . . . . . .
//   . . . B W . . .
//   . . . W B . . .
//   . . . . . . . .
//   . . . . . . . .
//   . . . . . . . .
    @Test
    void shouldNotBeAddedInSeparation() {
        // given
        int[][] board = startBoard(8);
        ReversiKata rk = new ReversiKata(board);
        // when
        board[0][0] = 2;
        // then
        assertThat(rk.checkForCorrectMove(board)).isFalse();
    }

//   . . . . . . . .
//   . . . . . . . .
//   . . . . . . . .
//   . . . B W . . .
//   . . B W B . . .
//   . . . . . . . .
//   . . . . . . . .
//   . . . . . . . .
    @Test
    void shouldBeAddedToExistingOnes() {
        // given
        int[][] board = startBoard(8);
        ReversiKata rk = new ReversiKata(board);
        // when
        board[4][2] = 2;
        // then
        assertThat(rk.checkForCorrectMove(board)).isTrue();
    }

//   . . . . . . . .
//   . . . . . . . .
//   . . . . . . . .
//   . . . B W . . .
//   . . . W B . . .
//   . . . . . B . .
//   . . . . . . . .
//   . . . . . . . .
    @Test
    void shouldNewPawnBeInContactWithDifferentColor() {
        // given
        int[][] board = startBoard(8);
        ReversiKata rk = new ReversiKata(board);
        // when
        board[5][5] = 2;
        // then
        assertThat(rk.checkForCorrectMove(board)).isFalse();
    }

    private int[][] startBoard(int boardSize) {
        int[][] board = new int[boardSize][boardSize];
        board[3][3] = 1;
        board[4][4] = 1;
        board[3][4] = -1;
        board[4][3] = -1;
        return board;
    }
}