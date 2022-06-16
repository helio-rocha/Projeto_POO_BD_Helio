package Database;

import Personagens.Players.Player;

import java.sql.SQLException;

public class PlayerDB extends Database
{
    public boolean insertPlayer(Player player){
        connect();
        String sql = "INSERT INTO player VALUES(default,?,?,?,?,?,?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, player.getNome());      // concatena nome na primeira ? do comando
            pst.setString(2, String.valueOf(player.getVida()));      // concatena nome na primeira ? do comando
            pst.setString(3, String.valueOf(player.getDanoTotal()));      // concatena nome na primeira ? do comando
            pst.setString(4, String.valueOf(player.getDanoBase()));      // concatena nome na primeira ? do comando
            pst.setString(5, String.valueOf(player.getVitalidade()));      // concatena nome na primeira ? do comando
            pst.setString(6, String.valueOf(player.getForca()));      // concatena nome na primeira ? do comando
            pst.setString(7, String.valueOf(player.getSabedoria()));      // concatena nome na primeira ? do comando
            pst.setString(8, String.valueOf(player.getInteligencia()));      // concatena nome na primeira ? do comando
            pst.setString(9, String.valueOf(player.getDestreza()));      // concatena nome na primeira ? do comando
            pst.execute();                            // executa o comando
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
}
