// Direitos Autorais, PUCRS/Escola Politécnica
// Início: 2021-06-04
// Atualização: 2021-06-07
// https://github.com/masmangan/symmetrical-octo-spoon

import java.util.Scanner;

/**
 * A classe TicTacToe permite jogar uma partida
 * de jogo-da-velha entre dois jogares.
 * 
 * @author Marco Mangan (marco.mangan@pucrs.br) 
 * @version 1.1 (2021-06-07)
 */
public class TicTacToe
{
    /**
     * Cria uma matriz 3x3, preenchida com espaços.
     * 
     * @return a matriz criada
     */
    public static String[][] init()
    {
        int i;
        int j;
        String[][] board = new String[3][3];
        for(i = 0; i < 3; i = i + 1) // i = 0, 1, 2
        {
            for(j = 0; j < 3; j = j + 1) // j = 0, 1, 2
            {
                board[i][j] = " ";
            }
        }    
        return board;
    }
    
    /**
     * 
     * @param
     */
    public static void dump(String[][] board)
    {
        int i;
        int j;
        for(i = 0; i < 3; i = i + 1) // i = 0, 1, 2
        {
            System.out.print("|");
            for(j = 0; j < 3; j = j + 1) // j = 0, 1, 2
            {
                System.out.print(board[i][j]);
            }
            System.out.println("|");
        }        
    }
    
    public static boolean fimDeJogo(String[][] board)
    {        
        return vitoria(board, "x") || vitoria(board, "o") || cheio(board);
    }
   
    public static boolean vitoria(String[][] board, String player)
    {
        int i;
        int j;
        for(i = 0; i < 3; i = i + 1) // i = 0, 1, 2
        {
            // player fechou linha i!
            if (board[i][0].equals(player) && 
                board[i][1].equals(player) && 
                board[i][2].equals(player))
            {
                return true;
            }
        }
        
        for(j = 0; j < 3; j = j + 1) // i = 0, 1, 2
        {        
            // player fechou coluna j!
            if (board[0][j].equals(player) && 
                board[1][j].equals(player) && 
                board[2][j].equals(player))
            {
                return true;
            }
        }
        //  diagonais!!!!
        if (board[0][0].equals(player) && 
                board[1][1].equals(player) && 
                board[2][2].equals(player))
                return true;
        if (board[0][2].equals(player) && 
                board[1][1].equals(player) && 
                board[2][0].equals(player))
                return true;                
        return false;
    }

    public static boolean cheio(String[][] board)
    {
        boolean temEspaco;
        int i;
        int j;       
        temEspaco = false;
        for(i = 0; i < 3; i = i + 1) // i = 0, 1, 2
        {
            for(j = 0; j < 3; j = j + 1) // j = 0, 1, 2
            {
                if (board[i][j].equals(" "))
                {
                    temEspaco = true;
                }
            }
        }    
        return !temEspaco;
    }

    public static void main(String[] args)
    {
        String[][] board;
        String player;
        int row;
        int column;
        Scanner teclado;
        
        teclado = new Scanner(System.in);
        board = init();        
        player = "x";
        
        System.out.printf("Jogo da Velha!\n\n");
        while (!fimDeJogo(board))
        {
            dump(board);
            System.out.printf("Jogada de: %s\n", player);
            System.out.print("Informe o valor da linha (0, 1, 2): ");
            row = teclado.nextInt();
            while (!(row >= 0 && row <= 2))
            {
                System.out.print("\tValor inválido. Digite novamente: ");
                row = teclado.nextInt();
            }
            // garantia: row >= 0 && row <= 2
            System.out.print("Informe o valor da coluna (0, 1, 2): ");
            column = teclado.nextInt();
            while (!(column >= 0 && column <= 2))
            {
                System.out.print("\tValor inválido. Digite novamente: ");
                column = teclado.nextInt();
            }
            if (board[row][column].equals(" "))
            {
                board[row][column] = player;
            }
            if (player.equals("x"))
            {
                player = "o";
            } 
            else 
            {
                player = "x";        
            }
        }        
        teclado.close();
        dump(board);
        System.out.print("**Fim de jogo**\n");
    }
}
