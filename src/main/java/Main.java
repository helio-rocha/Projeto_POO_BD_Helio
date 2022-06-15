import Personagens.Players.Arqueiro;
import Personagens.Players.Guerreiro;
import Personagens.Players.Mago;
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
            System.out.println("Pressione 1 para criar um Novo Personagem");
            System.out.println("Pressione 2 para escolher um personagem criado");
            int op = sc.nextInt();
            Player player = null;
            switch (op)
            {
                case 1:
                    System.out.println("Pressione 1 para criar um arqueiro");
                    System.out.println("Pressione 2 para criar um guerreiro");
                    System.out.println("Pressione 3 para criar um mago");
                    op = sc.nextInt();
                    System.out.println("Entre com o nome do personagem");
                    switch (op)
                    {
                        case 1:
                            player = new Arqueiro(sc.nextLine());
                            break;
                        case 2:
                            player = new Guerreiro(sc.nextLine());
                            break;
                        case 3:
                            player = new Mago(sc.nextLine());
                            sc.nextInt();
                            break;
                        default:
                            System.out.println("Número inválido");
                            break;
                    }
                case 2:
                    // Banco de dados
            }
            System.out.println("Pressione 1 se deseja ir batalhar");
            System.out.println("Pressione 2 se deseja ver os status");
            System.out.println("Pressione 3 se deseja sair");
            op = sc.nextInt();
            switch (op)
            {
                case 1:
                    System.out.println("Selecione a área em que deseja batalhar");
                    //op = sc.nextInt();
                    break;
                case 2:
                    if (player!=null) player.printStatus();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Número inválido");
                    break;
            }

        }
    }
}
