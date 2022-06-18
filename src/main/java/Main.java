import Areas.Area;
import Database.AreaDB;

import java.util.Scanner;

public class Main
{
    static AreaDB areaDB = new AreaDB();

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
            switch (op)
            {
                case 1 ->
                {
                    Utilidades.criarPersonagem();
                    System.out.println("Personagem Criado");
                    System.out.println();
                }
                case 2 -> Utilidades.escolherPersonagem();
                case 3 -> Utilidades.criarInimigo();
                case 4 -> Utilidades.escolherInimigo();
                case 5 -> Utilidades.criarArea();
                case 6 ->
                {
                    int id = Utilidades.escolherArea();
                    if (id == 0) break;
                    Area area = areaDB.researchArea(id);
                    Utilidades.verArea(area);
                }
                case 7 -> flag = false;
            }
        }
    }
}
