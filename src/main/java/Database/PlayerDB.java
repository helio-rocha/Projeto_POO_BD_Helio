package Database;

import Personagens.Players.Player;

import java.sql.SQLException;

public class PlayerDB extends Database
{
    public boolean insertPlayer(Player player){
        connect();
        String sql = "INSERT INTO player VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            int id = researchId()+1;
            System.out.println(id);
            pst.setString(1, String.valueOf(id));      // concatena nome na primeira ? do comando
            pst.setString(2, player.getNome());      // concatena nome na primeira ? do comando
            pst.setString(3, String.valueOf(player.getVida()));      // concatena nome na primeira ? do comando
            pst.setString(4, String.valueOf(player.getDanoTotal()));      // concatena nome na primeira ? do comando
            pst.setString(5, String.valueOf(player.getDanoBase()));      // concatena nome na primeira ? do comando
            pst.setString(6, String.valueOf(player.getVitalidade()));      // concatena nome na primeira ? do comando
            pst.setString(7, String.valueOf(player.getForca()));      // concatena nome na primeira ? do comando
            pst.setString(8, String.valueOf(player.getSabedoria()));      // concatena nome na primeira ? do comando
            pst.setString(9, String.valueOf(player.getInteligencia()));      // concatena nome na primeira ? do comando
            pst.setString(10, String.valueOf(player.getDestreza()));      // concatena nome na primeira ? do comando
            pst.execute();// executa o comando
            check = true;

        } catch (SQLException e) {
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    public int[] researchAllPlayers(){
        connect();
        int[] ids = new int[100];
        int i = 0;
        String sql = "SELECT id,nome,vida FROM player";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                ids[i] = result.getInt("id");
                i++;
                System.out.println("ID = " + result.getInt("id"));
                System.out.println("Nome = " + result.getString("nome"));
                System.out.println("Vida = " + result.getInt("vida"));
                System.out.println("------------------------------");
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return ids;
    }

    public Player researchPlayer(int id)
    {
        connect();
        Player player = null;
        String sql = "SELECT * FROM player WHERE id = ?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            result = pst.executeQuery();

            while(result.next()){
                int playerID = result.getInt("id");
                String playerNome = result.getString("nome");
                int playerVida = result.getInt("vida");
                int playerDanoTotal = result.getInt("danoTotal");
                int playerDanoBase = result.getInt("danoBase");
                int playerVitalidade = result.getInt("vitalidade");
                int playerForca = result.getInt("forca");
                int playerSabedoria = result.getInt("sabedoria");
                int playerInteligencia = result.getInt("inteligencia");
                int playerDestreza = result.getInt("destreza");
                System.out.println("ID = " + playerID);
                System.out.println("Nome = " + playerNome);
                System.out.println("Dano Total = " + playerDanoTotal);
                System.out.println("Dano Base = " + playerDanoBase);
                System.out.println("Vitalidade = " + playerVitalidade);
                System.out.println("Forca = " + playerForca);
                System.out.println("Sabedoria = " + playerSabedoria);
                System.out.println("Inteligencia = " + playerInteligencia);
                System.out.println("Destreza = " + playerDestreza);
                System.out.println("------------------------------");
                player = new Player(playerID,playerNome,playerVida,playerDanoTotal,playerDanoBase,playerVitalidade,playerForca,playerSabedoria,playerInteligencia,playerDestreza);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return player;
    }

    public boolean mudaNomePlayer(int id, String nome)
    {
        connect();
        String sql = "UPDATE player SET nome=? WHERE id=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, id);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    public int[] researchInventario(int id)
    {
        connect();
        int[] ids = new int[100];
        int i = 0;
        String sql = "SELECT id,nome,dano,is_equipado FROM arma WHERE id = ? ORDER BY is_equipado DESC";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            result = pst.executeQuery();

            while(result.next()){
                ids[i] = result.getInt("id");
                i++;
                if(result.getBoolean("is_equipado"))
                {
                    System.out.println("Arma equipada");
                }
                System.out.println("ID = " + result.getInt("id"));
                System.out.println("Nome = " + result.getString("nome"));
                System.out.println("Dano = " + result.getInt("dano"));
                System.out.println("------------------------------");
                if(result.getBoolean("is_equipado"))
                {
                    System.out.println();
                    System.out.println();
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return ids;
    }

    public boolean deletaPlayer(int id)
    {
        connect();
        String sql = "DELETE FROM player WHERE id=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    public int researchId()
    {
        connect();
        int id = 0;
        Player player = null;
        String sql = "SELECT max(id) FROM player";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
               id = result.getInt("max(id)");
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return id;
    }

}
