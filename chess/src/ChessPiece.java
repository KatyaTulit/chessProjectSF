abstract public class ChessPiece {
    protected String color;
    protected boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    abstract public String getColor();

    abstract public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    abstract public String getSymbol();

    public boolean checkPos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    public boolean destinationSameTeam(ChessBoard chessBoard, int toLine, int toColumn) {
        return chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].color.equals(getColor());
    }

}
