package Database;

import Armas.Arma;

import java.sql.SQLException;

public class ArmaDB extends Database
{
    public void criarArma(Arma arma,int playerI)
    {
        connect();
        String sql = "INSERT INTO arma VALUES(?,?,?,false,?)";
        try {
            pst = connection.prepareStatement(sql);
            int id = researchId()+1;
            pst.setString(1, String.valueOf(id));
            pst.setString(2, arma.getNome());
            pst.setString(3, String.valueOf(arma.getDano()));
            pst.setString(4, String.valueOf(playerI));
            pst.execute();
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
    }

    private int researchId()
    {
        connect();
        int id = 0;
        String sql = "SELECT max(id) FROM arma";
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

    public void mudaNomeArma(int id, String nome)
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

    public void deletaArma(int id)
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
    }

    public void desequipaArma(int id)
    {
        connect();
        String sql = "UPDATE arma SET is_equipado = false WHERE id=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sql = "UPDATE player SET danoTotal = danoBase WHERE id=?";
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
            }catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

    public void equipaArma(int id, int dano)
    {
        connect();
        String sql = "UPDATE arma SET is_equipado = true WHERE id=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            check = true;
            sql = "UPDATE player SET danoTotal = danoBase + ? WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, dano);
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
    }
}
