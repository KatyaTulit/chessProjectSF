public class ChessBoard {
    public ChessPiece[][] board = new ChessPiece[8][8]; // creating a field for game
    String nowPlayer;

    public ChessBoard(String nowPlayer) {
        this.nowPlayer = nowPlayer;
    }

    public String nowPlayerColor() {
        return this.nowPlayer;
    }

    public boolean moveToPosition(int startLine, int startColumn, int endLine, int endColumn) {
        if (checkPos(startLine) && checkPos(startColumn)) {

            if (!nowPlayer.equals(board[startLine][startColumn].getColor())) return false;

            if (board[startLine][startColumn].canMoveToPosition(this, startLine, startColumn, endLine, endColumn)) {

                if (board[startLine][startColumn].getSymbol().equals("K") ||  // check position for castling
                        board[startLine][startColumn].getSymbol().equals("R")) {
                    board[startLine][startColumn].check = false;
                }

                board[endLine][endColumn] = board[startLine][startColumn]; // if piece can move, we moved a piece
                board[startLine][startColumn] = null; // set null to previous cell
                this.nowPlayer = this.nowPlayerColor().equals("White") ? "Black" : "White";

                return true;
            } else return false;
        } else return false;
    }

    public void printBoard() {  //print board in console
        System.out.println("Turn " + nowPlayer);
        System.out.println();
        System.out.println("Player 2(Black)");
        System.out.println();
        System.out.println("\t0\t1\t2\t3\t4\t5\t6\t7");
        for (int i = 7; i > -1; i--) {
            System.out.print(i + "\t");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".." + "\t");
                } else {
                    System.out.print(board[i][j].getSymbol() + board[i][j].getColor().substring(0, 1).toLowerCase() + "\t");
                }
            }
            System.out.println();
            System.out.println();
        }
        System.out.println("Player 1(White)");
    }

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public boolean castling(boolean kingside) {
        int line = nowPlayer.equals("White") ? 0 : 7;

        int kingColumn = 4;
        int rookColumn = kingside ? 0 : 7;

        int newKingColumn = kingside ? 2 : 6;
        int newRookColumn = kingside ? 3 : 5;

        if (board[line][rookColumn] == null || board[line][kingColumn] == null) return false;
        if (board[line][rookColumn].getSymbol().equals("R") && board[line][kingColumn].getSymbol().equals("K") && // check that King and Rook
                checkNoPiecesInBetween(rookColumn, kingColumn, line)) {  // never moved
            if (board[line][rookColumn].getColor().equals(nowPlayer) && board[line][kingColumn].getColor().equals(nowPlayer) &&
                    board[line][rookColumn].check && board[line][kingColumn].check &&
                    !new King(nowPlayer).isUnderAttack(this, line, newKingColumn)) { // check that position not in under attack
                board[line][kingColumn] = null;
                board[line][newKingColumn] = new King(nowPlayer);  // move King
                board[line][newKingColumn].check = false;
                board[line][rookColumn] = null;
                board[line][newRookColumn] = new Rook(nowPlayer);  // move Rook
                board[line][newRookColumn].check = false;
                nowPlayer = nowPlayer.equals("White") ? "Black" : "White";  // next turn
                return true;
            } else return false;
        } else return false;
    }

    private boolean checkNoPiecesInBetween(int first, int second, int line) {

        // Check that there are no chess pieces in-between the rook and the king

        if (first > second) {
            int temp = first;
            first = second;
            second = temp;
        }

        for (int i = first+1; i < second; i++) {
            if (board[line][i] != null) {
                return false;
            }
        }

        return true;
    }
}
