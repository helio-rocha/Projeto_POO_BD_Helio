import Areas.Area;
import Armas.Arma;
import Database.AreaDB;
import Database.ArmaDB;
import Database.InimigoDB;
import Database.PlayerDB;
import Inimigos.Inimigo;
import Players.Player;

import java.util.Scanner;

public class Utilidades
{
    private static Scanner sc = new Scanner(System.in);
    private static PlayerDB playerDB = new PlayerDB();
    private static ArmaDB armaDB = new ArmaDB();

    private static AreaDB areaDB = new AreaDB();

    private static InimigoDB inimigoDB = new InimigoDB();

    public static void criarPersonagem() // Talvez alterar Atributos
    {
            String nome;
            Scanner sc = new Scanner(System.in);
            Player player;
            System.out.println("Entre com o nome do personagem");
            nome = sc.nextLine();
            player = new Player(nome);
            playerDB.insertPlayer(player);
    }
    public static void escolherPersonagem()
    {
        boolean flag = true;
        int op = 0;
        while (flag)
        {
            int[] ids = playerDB.researchAllPlayers();
            System.out.println("Pressione o ID do player para acessar suas informacoes");
            System.out.println("Pressione 0 para voltar");
            op = sc.nextInt();
            System.out.println();
            boolean a = false;
            if (op == 0) return; // == Length+1
            for (int id : ids)
            {
                if (op == id)
                {
                    flag = false;
                    a = true;
                    break;
                }
            }
            if (!a) System.out.println("Numero invalido");
        }
            Player player = playerDB.researchPlayer(op); // Pegar banco
            verPersonagem(player);
    }

    public static void verPersonagem(Player player)
    {
        boolean flag = true;
        while (flag)
        {
            System.out.println("Pressione 1 para mostrar os status do personagem");
            System.out.println("Pressione 2 para alterar o nome do personagem");
            System.out.println("Pressione 3 para mostrar o inventario do personagem");
            System.out.println("Pressione 4 para deletar o personagem");
            System.out.println("Pressione 5 para forjar arma");
            System.out.println("Pressione 6 para sair");
            int op = sc.nextInt();
            switch (op)
            {
                case 1 -> player.printStatus();
                case 2 ->
                {
                    System.out.println();
                    System.out.println("Entre com o nome");
                    sc.nextLine();
                    String nome = sc.nextLine();
                    player.setNome(nome);
                    playerDB.mudaNomePlayer(player.getId(), nome);
                    System.out.println();
                    System.out.println("Nome mudado com sucesso");
                    System.out.println();
                }
                case 3 -> Utilidades.escolherArma(player);
                case 4 ->
                {
                    playerDB.deletaPlayer(player.getId());
                    System.out.println();
                    System.out.println("Player apagado com sucesso");
                    System.out.println();
                    flag = false;
                }
                case 5 ->
                {
                    sc.nextLine();
                    System.out.println("Entre com o nome da arma");
                    String nomeArma = sc.nextLine();
                    System.out.println("Entre com o dano da arma");
                    int dano = sc.nextInt();
                    Arma arma = new Arma(nomeArma, dano);
                    System.out.println();
                    armaDB.criarArma(arma, player.getId());
                    System.out.println();
                }
                case 6 -> flag = false;
                default ->
                {
                    System.out.println();
                    System.out.println("Numero Invalido");
                    System.out.println();
                }
            }
        }
    }

    public static void escolherArma(Player player)
    {
        boolean flag = true;
        while (flag)
        {
            int[] ids = playerDB.researchInventario(player.getId());
            System.out.println();
            System.out.println("Pressione o ID da arma para acessar suas informacoes");
            System.out.println("Pressione 0 para voltar");
            int op = sc.nextInt();
            System.out.println();
            boolean a = false;
            if (op == 0) return; // == Length+1
            for (int j : ids)
            {
                if (op == j)
                {
                    flag = false;
                    a = true;
                    break;
                }
            }
            if (!a) System.out.println("Numero invalido");
            else
            {
                Arma arma = armaDB.researchArma(op); // Pegar banco
                verArma(arma,player);
            }
        }
    }

    private static void verArma(Arma arma, Player player)
    {
        boolean flag = true;
        while (flag)
        {
            System.out.println();
            System.out.println("Pressione 1 para mostrar os status da arma");
            System.out.println("Pressione 2 para alterar o nome da arma");
            if (arma.isIs_equipado()) System.out.println("Pressione 3 para desequipar a arma");
            else System.out.println("Pressione 3 para equipar a arma");
            System.out.println("Pressione 4 para dropar a arma");
            System.out.println("Pressione 5 para sair");
            int op = sc.nextInt();
            System.out.println();
            switch (op)
            {
                case 1:
                    arma.printStatus();
                    break;
                case 2:
                    System.out.println("Entre com o nome");
                    sc.nextLine();
                    System.out.println();
                    String nome = sc.nextLine();
                    arma.setNome(nome);
                    armaDB.mudaNomeArma(arma.getId(), nome);
                    System.out.println("Nome da arma mudado com sucesso");
                    System.out.println();
                    break;
                case 3:
                    if (arma.isIs_equipado())
                    {
                        arma.setIs_equipado(false);
                        armaDB.desequipaArma(arma.getId());
                        player.setDanototal(player.getDanoBase());
                        player.setArma(null);
                    }
                    else
                    {
                        if (player.getArma() != null)
                        {
                            armaDB.desequipaArma(player.getArma().getId());
                        }
                        player.setArma(arma);
                        player.setDanototal(player.getDanoBase()+arma.getDano());
                        armaDB.equipaArma(arma.getId(),arma.getDano());
                        arma.setIs_equipado(true);
                    }
                    break;
                case 4:
                    armaDB.deletaArma(arma.getId());
                    System.out.println();
                    System.out.println("Arma dropada com sucesso");
                    System.out.println();
                    flag = false;
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Numero Invalido");
                    System.out.println();
                    break;
            }
        }
    }
    public static void criarInimigo()
    {
        sc.nextLine();
        System.out.println("Entre com o nome do inimigo");
        String nomeInimigo = sc.nextLine();
        System.out.println("Entre com o dano do inimigo");
        int dano = sc.nextInt();
        System.out.println("Entre com a vida do inimigo");
        int vida = sc.nextInt();
        System.out.println();
        Inimigo inimigo = new Inimigo(nomeInimigo, dano,vida);
        inimigoDB.criarInimigo(inimigo);
        System.out.println("Inimigo criado com sucesso");
        System.out.println();
    }

    public static void escolherInimigo()
    {
        boolean flag = true;
        int op;
        while (flag)
        {
            int[] ids = inimigoDB.researchAllInimigos();
            System.out.println();
            System.out.println("Pressione o ID do inimigo para acessar suas informacoes");
            System.out.println("Pressione 0 para voltar");
            op = sc.nextInt();
            System.out.println();
            boolean a = false;
            if (op == 0) return; // == Length+1
            for (int id : ids)
            {
                if (op == id)
                {
                    flag = false;
                    a = true;
                    break;
                }
            }
            if (!a) System.out.println("Numero invalido");
            else
            {
                Inimigo inimigo = inimigoDB.researchInimigo(op);
                System.out.println();// Pegar banco
                verInimigo(inimigo);
            }
        }
    }

    private static void verInimigo(Inimigo inimigo)
    {
        boolean flag = true;
        while (flag)
        {
            System.out.println("Pressione 1 para mostrar os status da inimigo");
            System.out.println("Pressione 2 para alterar o nome da inimigo");
            System.out.println("Pressione 3 para adicionar o inimigo a uma area");
            System.out.println("Pressione 4 para remover o inimigo de uma area");
            System.out.println("Pressione 5 para deletar o inimigo");
            System.out.println("Pressione 6 para sair");
            int areaId;
            int op = sc.nextInt();
            System.out.println();
            switch (op)
            {
                case 1 ->
                {
                    inimigo.printStatus();
                    System.out.println();
                    areaDB.researchAreaInimigo(inimigo.getId());
                }
                case 2 ->
                {
                    System.out.println("Entre com o nome");
                    sc.nextLine();
                    System.out.println();
                    String nome = sc.nextLine();
                    inimigo.setNome(nome);
                    inimigoDB.mudaNomeInimigo(inimigo.getId(), nome);
                    System.out.println();
                    System.out.println("Nome mudado com sucesso");
                    System.out.println();
                }
                case 3 ->
                {
                    areaId = Utilidades.escolherAreaNesta(inimigo.getId());//mostrar somente as que ele nao esta
                    if (areaId == 0) break;
                    inimigoDB.addInimigoArea(inimigo.getId(), areaId);
                    System.out.println();
                    System.out.println("Inimigo adicionado na area");
                    System.out.println();
                }
                case 4 ->
                {
                    areaId = Utilidades.escolherAreaEsta(inimigo.getId()); //mostrar somente as que ele esta
                    if (areaId == 0) break;
                    inimigoDB.DeleteInimigoArea(inimigo.getId(), areaId);
                    System.out.println();
                    System.out.println("Inimigo deletado da area");
                    System.out.println();
                }
                case 5 ->
                {
                    inimigoDB.deleteInimigo(inimigo.getId());
                    System.out.println();
                    System.out.println("Inimigo deletado");
                    System.out.println();
                    flag = false;
                }
                case 6 -> flag = false;
                default ->
                {
                    System.out.println();
                    System.out.println("Numero Invalido");
                    System.out.println();
                }
            }
        }
    }

    private static int escolherAreaEsta(int id)
    {
        boolean flag = true;
        int op = 0;
        while (flag)
        {
            int[] ids = areaDB.researchAllAreasEsta(id);
            System.out.println();
            System.out.println("Pressione o ID da area para adicionar o inimigo a essa area");
            System.out.println("Pressione 0 para voltar");
            op = sc.nextInt();
            System.out.println();
            boolean a = false;
            if (op == 0) return op;
            for (int j : ids)
            {
                if (op == j)
                {
                    flag = false;
                    a = true;
                    break;
                }
            }
            if (!a) System.out.println("Numero invalido");
        }
        return op;
    }

    private static int escolherAreaNesta(int id)
    {
        boolean flag = true;
        int op = 0;
        while (flag)
        {
            int[] ids = areaDB.researchAllAreasNEsta(id);
            System.out.println();
            System.out.println("Pressione o ID da area para adicionar o inimigo a essa area");
            System.out.println("Pressione 0 para voltar");
            op = sc.nextInt();
            System.out.println();
            boolean a = false;
            if (op == 0) return op;
            for (int j : ids)
            {
                if (op == j)
                {
                    flag = false;
                    a = true;
                    break;
                }
            }
            if (!a) System.out.println("Numero invalido");
        }
        return op;
    }

    public static int escolherArea()
    {
        boolean flag = true;
        int op = 0;
        while (flag)
        {
            int[] ids = areaDB.researchAllAreas();
            System.out.println();
            System.out.println("Pressione o ID da area para adicionar o inimigo a essa area");
            System.out.println("Pressione 0 para voltar");
            op = sc.nextInt();
            System.out.println();
            boolean a = false;
            if (op == 0) return op;
            for (int id : ids)
            {
                if (op == id)
                {
                    flag = false;
                    a = true;
                    break;
                }
            }
            if (!a) System.out.println("Numero invalido");
        }
        return op;
    }

    public static void criarArea()
    {
        sc.nextLine();
        System.out.println();
        System.out.println("Entre com o nome da area");
        String nomeArea = sc.nextLine();
        System.out.println();
        Area area = new Area(nomeArea);
        areaDB.criarArea(area);
        System.out.println("Area criada");
        System.out.println();
    }

    public static void verArea(Area area)
    {
        boolean flag = true;
        while (flag)
        {
            System.out.println();
            System.out.println("Pressione 1 para mostrar os status da area");
            System.out.println("Pressione 2 para alterar o nome da area");
            System.out.println("Pressione 3 para adicionar um inimigo a area");
            System.out.println("Pressione 4 para remover um inimigo da area");
            System.out.println("Pressione 5 para deletar a area");
            System.out.println("Pressione 6 para sair");
            int inimigoId;
            int op = sc.nextInt();
            System.out.println();
            switch (op)
            {
                case 1 ->
                {
                    area.printStatus();
                    System.out.println();
                }
                case 2 ->
                {
                    System.out.println("Entre com o nome");
                    sc.nextLine();
                    String nome = sc.nextLine();
                    System.out.println();
                    area.setNome(nome);
                    areaDB.mudaNomeArea(area.getId(), nome);
                    System.out.println("Nome da area mudado");
                }
                case 3 ->
                {
                    inimigoId = Utilidades.escolherInimigoNesta(area.getId());
                    if (inimigoId == 0) break;
                    inimigoDB.addInimigoArea(inimigoId, area.getId());
                    area.setInimigos(inimigoDB.researchInimigosArea(area.getId()));
                    System.out.println();
                    System.out.println("Inimigo adicionado na area");
                    System.out.println();
                }
                case 4 ->
                {
                    inimigoId = Utilidades.escolherInimigoEsta(area.getId()); //mostrar somente as que ele esta
                    inimigoDB.DeleteInimigoArea(inimigoId, area.getId());
                    area.setInimigos(inimigoDB.researchInimigosArea(area.getId()));
                    System.out.println();
                    System.out.println("Inimigo deletado da area");
                    System.out.println();
                }
                case 5 ->
                {
                    areaDB.deleteArea(area.getId());
                    System.out.println();
                    System.out.println("area deletada");
                    System.out.println();
                    flag = false;
                }
                case 6 -> flag = false;
                default ->
                {
                    System.out.println("Numero Invalido");
                    System.out.println();
                }
            }
        }
    }

    private static int escolherInimigoEsta(int id)
    {
        boolean flag = true;
        int op = 0;
        while (flag)
        {
            int[] ids = inimigoDB.researchAllInimigosEsta(id);
            System.out.println();
            System.out.println("Pressione o ID da area para adicionar o inimigo a essa area");
            System.out.println("Pressione 0 para voltar");
            op = sc.nextInt();
            System.out.println();
            boolean a = false;
            if (op == 0) return op;
            for (int j : ids)
            {
                if (op == j)
                {
                    flag = false;
                    a = true;
                    break;
                }
            }
            if (!a) System.out.println("Numero invalido");
        }
        return op;
    }

    private static int escolherInimigoNesta(int id)
    {
        boolean flag = true;
        int op = 0;
        while (flag)
        {
            int[] ids = inimigoDB.researchAllInimigosNEsta(id);
            System.out.println();
            System.out.println("Pressione o ID da area para adicionar o inimigo a essa area");
            System.out.println("Pressione 0 para voltar");
            op = sc.nextInt();
            System.out.println();
            boolean a = false;
            for (int j : ids)
            {
                if (op == j || op == 0)
                {
                    flag = false;
                    a = true;
                    break;
                }
            }
            if (!a) System.out.println("Numero invalido");
        }
        return op;
    }
}
