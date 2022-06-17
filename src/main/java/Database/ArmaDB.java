package Database;

import Armas.Arma;

import java.sql.SQLException;

public class ArmaDB extends Database
{
    static ArmaDB armaDB = new ArmaDB();

    static int cont = 1;

    public boolean criarArma(Arma arma,int playerI)
    {
        connect();
        String sql = "INSERT INTO arma VALUES(?,?,?,false,?)";
        try {
            pst = connection.prepareStatement(sql);

            pst.setString(1, String.valueOf(cont));      // concatena nome na primeira ? do comando
            pst.setString(2, arma.getNome());      // concatena nome na primeira ? do comando
            pst.setString(3, String.valueOf(arma.getDano()));      // concatena nome na primeira ? do comando
            pst.setString(4, String.valueOf(playerI));      // concatena nome na primeira ? do comando
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

    public boolean mudaNomeArma(int id, String nome)
    {
        connect();
        String sql = "UPDATE arma SET nome=? WHERE id=?";
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

    public Arma researchArma(int id)
    {
        connect();
        Arma arma = null;
        String sql = "SELECT * FROM arma WHERE id = ?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            result = pst.executeQuery();

            while(result.next()){
                int armaID = result.getInt("id");
                String armaNome = result.getString("nome");
                int armaDano = result.getInt("dano");
                boolean armaIs_equipado = result.getBoolean("is_equipado");
                System.out.println("ID = " + armaID);
                System.out.println("Nome = " + armaNome);
                System.out.println("Dano = " + armaDano);
                System.out.println("------------------------------");
                arma = new Arma(armaID,armaNome,armaDano,armaIs_equipado);
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
        return arma;
    }

    public boolean deletaArma(int id)
    {
        connect();
        String sql = "DELETE FROM arma WHERE id=?";
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
}