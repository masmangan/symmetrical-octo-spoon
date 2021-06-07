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
    
    public static void main(String[] args)
    {
        String[][] board;
        String player;
        boolean done;
        int row;
        int column;
        Scanner teclado;
        
        teclado = new Scanner(System.in);
        board = init();        
        player = "x";
        
        System.out.printf("Jogo da Velha!\n\n");
        done = false;
        while (!done)
        {
            dump(board);
            System.out.printf("Jogada de: %s\n", player);
            System.out.print("Informe o valor da linha (0, 1, 2):");
            row = teclado.nextInt();
            System.out.print("Informe o valor da coluna (0, 1, 2):");
            column = teclado.nextInt();
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
    }
}
