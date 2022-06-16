import Personagens.Players.Player;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        while (flag)
        {
            System.out.println("Jogo");
            System.out.println("Pressione 1 para criar um novo personagem");
            System.out.println("Pressione 2 para escolher um personagem criado");
            System.out.println("Pressione 3 criar um novo inimigo");
            System.out.println("Pressione 3 ver os inimigos existentes");
            System.out.println("Pressione 4 criar uma nova área");
            System.out.println("Pressione 4 ver as áreas existentes");
            System.out.println("Pressione 5 para sair");
            int op = sc.nextInt();
            Player player = null;
            switch (op)
            {
                case 1:
                    while (!Utilidades.criarPersonagem());
                    System.out.println("Personagem Criado");
                    break;
                case 2:
                    while (Utilidades.escolherPersonagem()); // Banco de dados
                    break;
                case 3:
                    Utilidades.mostrarInimigos();
                    break;
                case 4:
                    Utilidades.mostrarAreas();
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
    }
}
