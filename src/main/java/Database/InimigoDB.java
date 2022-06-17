package Database;

import Personagens.Inimigos.Inimigo;

import java.sql.SQLException;

public class InimigoDB extends Database
{
    public void criarInimigo(Inimigo inimigo)
    {
        connect();
        String sql = "INSERT INTO inimigo VALUES(?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            int id = researchId()+1;
            pst.setString(1, String.valueOf(id));      // concatena nome na primeira ? do comando
            pst.setString(2, inimigo.getNome());      // concatena nome na primeira ? do comando
            pst.setString(3, String.valueOf(inimigo.getDano()));      // concatena nome na primeira ? do comando
            pst.setString(4, String.valueOf(inimigo.getVida()));      // concatena nome na primeira ? do comando
            pst.execute();// executa o comando
            check = true;

        } catch (SQLException e) {
            System.out.println("Erro de operacao: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: " + e.getMessage());
            }
        }
    }

    public int[] researchAllInimigos()
    {
        connect();
        int[] ids = new int[100];
        int i = 0;
        String sql = "SELECT id,nome,vida,dano FROM inimigo";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                ids[i] = result.getInt("id");
                i++;
                System.out.println("ID = " + result.getInt("id"));
                System.out.println("Nome = " + result.getString("nome"));
                System.out.println("Vida = " + result.getInt("vida"));
                System.out.println("Dano = " + result.getInt("dano"));
                System.out.println("------------------------------");
            }
        }catch (SQLException e){
            System.out.println("Erro de operacao: " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: " + e.getMessage());
            }
        }
        return ids;
    }

    public Inimigo researchInimigo(int id)
    {
        connect();
        Inimigo inimigo = null;
        String sql = "SELECT * FROM inimigo WHERE id = ?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            result = pst.executeQuery();

            while(result.next()){
                int inimigoID = result.getInt("id");
                String inimigoNome = result.getString("nome");
                int inimigoDano = result.getInt("dano");
                int inimigoVida = result.getInt("vida");
                System.out.println("ID = " + inimigoID);
                System.out.println("Nome = " + inimigoNome);
                System.out.println("Dano = " + inimigoDano);
                System.out.println("Vida = " + inimigoVida);
                System.out.println("------------------------------");
                inimigo = new Inimigo(inimigoID,inimigoNome,inimigoDano,inimigoVida);
            }
        }catch (SQLException e){
            System.out.println("Erro de operacao: " + e.getMessage());
        }finally {
            try {
                connection.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: " + e.getMessage());
            }
        }
        return inimigo;
    }

    public void mudaNomeInimigo(int id, String nome)
    {
        connect();
        String sql = "UPDATE inimigo SET nome=? WHERE id=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setInt(2, id);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operacao: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e) {
                System.out.println("Erro ao fechar a conexao: " + e.getMessage());
            }
        }
    }

    public void addInimigoArea(int id, int areaId)
    {
        connect();
        String sql = "INSERT INTO inimigo_esta_area VALUES(?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, String.valueOf(areaId));      // concatena nome na primeira ? do comando
            pst.setString(2, String.valueOf(id));      // concatena nome na primeira ? do comando
            pst.execute();// executa o comando
            check = true;

        } catch (SQLException e) {
            System.out.println("Erro de operacao: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: " + e.getMessage());
            }
        }
    }

    public void DeleteInimigoArea(int id, int areaId)
    {
        connect();
        String sql = "DELETE FROM inimigo_esta_area WHERE area_id = ? AND  inimigo_id = ?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, areaId);
            pst.setInt(2, id);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operacao: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: " + e.getMessage());
            }
        }
    }

    public void deleteInimigo(int id)
    {
        connect();
        String sql = "DELETE FROM inimigo_esta_area WHERE inimigo_id=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sql = "DELETE FROM inimigo WHERE id=?";
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operacao: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: " + e.getMessage());
            }
        }
    }

    public int researchId()
    {
        connect();
        int id = 0;
        String sql = "SELECT max(id) FROM inimigo";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                id = result.getInt("max(id)");
            }
        }catch (SQLException e){
            System.out.println("Erro de operacao: " + e.getMessage());
        }finally {
            try {
                connection.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: " + e.getMessage());
            }
        }
        return id;
    }

    public int[] researchAllInimigosNEsta(int id)
    {
        connect();
        int[] ids = new int[100];
        int i = 0;
        int a = 0;
        String sql = "SELECT id,nome FROM inimigo WHERE id NOT IN (SELECT I.id FROM inimigo AS I, inimigo_esta_area AS IA WHERE I.id = IA.inimigo_id AND IA.area_id = ?)";
        try
        {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            result = pst.executeQuery();
            while (result.next())
            {
                ids[i] = result.getInt("id");
                i++;
                System.out.println("ID = " + result.getInt("id"));
                System.out.println("Nome = " + result.getString("nome"));
                System.out.println("------------------------------");
                a = 1;
            }
            if (a==0)
            {
                sql = "SELECT area_id FROM inimigo_esta_area WHERE area_id = ?";
                pst = connection.prepareStatement(sql);
                pst.setInt(1, id);
                result = pst.executeQuery();
                if(result.next());
                else
                {
                    sql = "SELECT id, nome FROM inimigo";
                    pst = connection.prepareStatement(sql);
                    result = pst.executeQuery();
                    while (result.next())
                    {
                        ids[i] = result.getInt("id");
                        i++;
                        System.out.println("ID = " + result.getInt("id"));
                        System.out.println("Nome = " + result.getString("nome"));
                        System.out.println("------------------------------");
                    }
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de operacao: " + e.getMessage());
        }finally {
            try {
                connection.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: " + e.getMessage());
            }
        }
        return ids;
    }

    public int[] researchAllInimigosEsta(int id)
    {
        connect();
        int[] ids = new int[100];
        int i = 0;
        int a = 0;
        String sql = "SELECT id,nome FROM inimigo WHERE id IN (SELECT I.id FROM inimigo AS I, inimigo_esta_area AS IA WHERE I.id = IA.inimigo_id AND IA.area_id = ?)";
        try
        {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            result = pst.executeQuery();
            while (result.next())
            {
                ids[i] = result.getInt("id");
                i++;
                System.out.println("ID = " + result.getInt("id"));
                System.out.println("Nome = " + result.getString("nome"));
                System.out.println("------------------------------");
                a = 1;
            }
            if (a==0)
            {
                sql = "SELECT area_id FROM inimigo_esta_area WHERE area_id = ?";
                pst = connection.prepareStatement(sql);
                pst.setInt(1, id);
                result = pst.executeQuery();
                if(!result.next());
                else
                {
                    sql = "SELECT id, nome FROM inimigo";
                    pst = connection.prepareStatement(sql);
                    result = pst.executeQuery();
                    while (result.next())
                    {
                        ids[i] = result.getInt("id");
                        i++;
                        System.out.println("ID = " + result.getInt("id"));
                        System.out.println("Nome = " + result.getString("nome"));
                        System.out.println("------------------------------");
                    }
                }
            }
        }catch (SQLException e){
            System.out.println("Erro de operacao: " + e.getMessage());
        }finally {
            try {
                connection.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Erro ao fechar a conexao: " + e.getMessage());
            }
        }
        return ids;
    }
}
