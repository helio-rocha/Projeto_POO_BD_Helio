import Database.PlayerDB;
import Personagens.Players.Arqueiro;
import Personagens.Players.Guerreiro;
import Personagens.Players.Mago;
import Personagens.Players.Player;

import java.util.Scanner;

public class Utilidades
{
    static Scanner sc = new Scanner(System.in);
    static PlayerDB playerDB = new PlayerDB();

    public static boolean criarPersonagem()
    {
        Scanner sc = new Scanner(System.in);
        Player player;
        System.out.println("Pressione 1 para criar um arqueiro");
        System.out.println("Pressione 2 para criar um guerreiro");
        System.out.println("Pressione 3 para criar um mago");
        int op = sc.nextInt();
        System.out.println("Entre com o nome do personagem");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.println("das");
        switch (op)
        {
            case 1:
                player = new Arqueiro(nome);
                playerDB.insertPlayer(player);
                // Adiciona no banco
                return true;
            case 2:
                player = new Guerreiro(nome);
                // Adiciona no banco
                return true;
            case 3:
                player = new Mago(nome);
                // Adiciona no banco
                return true;
            default:
                System.out.println("Número inválido");
                return false;
        }
    }
    public static boolean escolherPersonagem()
    {
        // Select personagens
//        for (int i = 0; i < ; i++)
//        {
//            System.out.println("Pressione " + (i+1) + " para acessar o personagem " + personagem(i));
//        }
        System.out.println("Pressione length+1 para voltar");
        int op = sc.nextInt();
        if (op==2) return false; // == Length+1
        Player player=null; // Pegar banco
        verPersonagem(player);
        return true;
    }

    public static void verPersonagem(Player player)
    {
        System.out.println("Pressione 1 para mostrar os status do personagem");
        System.out.println("Pressione 2 para alterar o nome do personagem");
        System.out.println("Pressione 3 para mostrar o inventário do personagem");
        System.out.println("Pressione 4 para deletar o personagem");
        System.out.println("Pressione 5 para forjar arma");
        System.out.println("Pressione 6 para sair");
        int op = sc.nextInt();
        switch (op)
        {
            case 1:
                player.printStatus();
                break;
            case 2:
                System.out.println("Entre com o nome");
                String nome = sc.nextLine();
                player.mudaNome(nome);
                break;
            case 3:
                player.mostraInventario();
                break;
            case 4:
                Utilidades.deletar(player);
                //sair
                break;
            case 5:
                System.out.println("Entre com o nome da arma");
                String nomeArma = sc.nextLine();
                System.out.println("Entre com o dano da arma");
                int dano = sc.nextInt();
                player.criarArma(nomeArma,dano);
            case 6:
                //sair;
                break;
            default:
                System.out.println("Número Inválido");
                break;
        }
    }

    public static void mostrarInimigos()
    {
        // Select Inimigos
    }

    public static void mostrarAreas()
    {
        // Select Áreas
    }

    public static void deletar(Player player)
    {
        // Tira do BD
    }

}
