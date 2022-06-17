import Areas.Area;
import Armas.Arma;
import Database.AreaDB;
import Database.ArmaDB;
import Database.InimigoDB;
import Database.PlayerDB;
import Personagens.Inimigos.Inimigo;
import Personagens.Players.Player;

import java.util.Scanner;

public class Main
{
    static PlayerDB playerDB = new PlayerDB();
    static ArmaDB armaDB = new ArmaDB();

    static AreaDB areaDB = new AreaDB();

    static InimigoDB inimigoDB = new InimigoDB();
    public static void main(String[] args)
    {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        while (flag)
        {
            System.out.println("Pressione 1 para criar um novo personagem");
            System.out.println("Pressione 2 para escolher um personagem criado");
            System.out.println("Pressione 3 criar um novo inimigo");
            System.out.println("Pressione 4 ver os inimigos existentes");
            System.out.println("Pressione 5 criar uma nova area");
            System.out.println("Pressione 6 ver as areas existentes");
            System.out.println("Pressione 7 para sair");
            int op = sc.nextInt();
            Player player = null;
            switch (op)
            {
                case 1:
                    Utilidades.criarPersonagem();
                    System.out.println("Personagem Criado");
                    System.out.println();
                    break;
                case 2:
                    Utilidades.escolherPersonagem(); // Banco de dados
                    break;
                case 3:
                    Utilidades.criarInimigo();
                    break;
                case 4:
                    Utilidades.escolherInimigo();
                    break;
                case 5:
                    Utilidades.criarArea();
                    break;
                case 6:
                    int id = Utilidades.escolherArea();
                    if (id==0) break;
                    Area area = areaDB.researchArea(id); // Pegar banco
                    Utilidades.verArea(area);
                    break;
                case 7:
                    flag = false;
                    break;
            }
        }
    }
}
