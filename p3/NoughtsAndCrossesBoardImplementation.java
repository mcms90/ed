package tresenraya;

public class NoughtsAndCrossesBoardImplementation implements NoughtsAndCrossesBoard {

    Color[][] board;

    /**
     * Constructor por defecto. 
     * Crea el tablero por defecto con el que empezamos a jugar.
     * Primero creamos el tablero con casillas vacías y luego colocamos las fichas
     * rojas y blancas en sus respectivas posiciones.
     * 
     * @author Mª Carmen
     */
    public NoughtsAndCrossesBoardImplementation() {
        this.board = new Color[3][3];
        
        for (int x = 0; x < 3; x++)
            for (int y = 0; y < 3; y++)
                board[x][y] = Color.VOID;
                
        board[0][0] = Color.RED;
        board[0][2] = Color.RED;
        board[1][1] = Color.RED;
        board[2][0] = Color.WHITE;
        board[0][1] = Color.WHITE;
        board[2][2] = Color.WHITE;   
    }
    
    /**
     * Función que dice si el juego ha acabdo o no.
     * @return true si el juego ha acabado, false en caso contrario.
     */
    @Override
    public boolean isGameOver() {
        
        if(board[0][0] != Color.VOID && board[0][0] == board[0][1] && board[0][1] == board[0][2])
            return true;
        if(board[1][0] != Color.VOID && board[1][0] == board[1][1] && board[1][1] == board[1][2])
            return true;
        if(board[2][0] != Color.VOID && board[2][0] == board[2][1] && board[2][1] == board[2][2])
            return true;
        if(board[0][0] != Color.VOID && board[0][0] == board[1][0] && board[1][0] == board[2][0])
            return true;
        if(board[0][1] != Color.VOID && board[0][1] == board[1][1] && board[1][1] == board[2][1])
            return true;
        if(board[0][2] != Color.VOID && board[0][2] == board[1][2] && board[1][2] == board[2][2])
            return true;
        if(board[0][0] != Color.VOID && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return true;
        if(board[0][2] != Color.VOID && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return true;
      
        return false;
        
    }

    /**
     * Esta función intenta mover la ficha desde la posición de origen a la posición
     * de destino.
     * @param fromX Posición X de la ficha que queremos mover
     * @param fromY Posición Y de la ficha que queremos mover
     * @param toX Posición X a la cual queremos mover la ficha
     * @param toY Posición Y a la cual queremos mover la ficha
     * @return true si se pudo mover, false en caso contrario
     */
    @Override
    public boolean movePiece(int fromX, int fromY, int toX, int toY) {
        if(canMovePieceAt(fromX,fromY) && toX >= 0 && toX < 3 && toY >= 0 && toY < 3 && board[toX][toY] == Color.VOID){
            board[toX][toY] = board[fromX][fromY];
            board[fromX][fromY] = Color.VOID;
            return true;
        }
        else
            return false;
    }

    /**
    * Función que nos devuelve el color de la ficha en la posición indicada
    * @param x Valor X de la posición donde queremos saber si hay una ficha
    * @param y Valor Y de la posición donde queremos saber si hay una ficha
    * @return Color de la ficha que hay en la celda indicada, si no hay ficha 
    * la función devolverá VOID
    */
    @Override
    public Color getPieceAt(int x, int y) {
        if(x < 0 || x > 2 || y < 0 || y > 2)
            return null;
        
        return board[x][y];
    }

    /**
    * Función que nos devuelve si se puede mover la ficha en la posicion x, y
     * @param x Valor X de la posición donde queremos saber si se puede mover
     * @param y Valor Y de la posición donde queremos saber si se puede mover
     * @return true si se puede mover la ficha, false en caso contrario
     */
    @Override
    public boolean canMovePieceAt(int x, int y) {
        if(x < 0 || x > 2 || y < 0 || y > 2 || getPieceAt(x,y) == Color.VOID)
            return false;
        else
            return true;
    }
    
}