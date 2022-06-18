package Database;

import Areas.Area;

import java.sql.SQLException;

public class AreaDB extends Database
{
    public int[] researchAllAreas()
    {
        connect();
        int[] ids = new int[100];
        int i = 0;
        String sql = "SELECT id,nome FROM area";
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                ids[i] = result.getInt("id");
                i++;
                System.out.println("ID = " + result.getInt("id"));
                System.out.println("Nome = " + result.getString("nome"));
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

    public void criarArea(Area area)
    {
        connect();
        String sql = "INSERT INTO area VALUES(?,?)";
        try {
            pst = connection.prepareStatement(sql);
            int id = researchId()+1;
            pst.setString(1, String.valueOf(id));
            pst.setString(2, area.getNome());
            pst.execute();
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

    public Area researchArea(int id)
    {
        connect();
        Area area = null;
        String sql = "SELECT * FROM area WHERE id = ?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            result = pst.executeQuery();

            while(result.next()){
                int areaID = result.getInt("id");
                String areaNome = result.getString("nome");
                System.out.println("ID = " + areaID);
                System.out.println("Nome = " + areaNome);
                System.out.println("------------------------------");
                area = new Area(areaID,areaNome);
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
        return area;
    }

    public void mudaNomeArea(int id, String nome)
    {
        connect();
        String sql = "UPDATE area SET nome=? WHERE id=?";
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

    public void deleteArea(int id)
    {
        String sql = "DELETE FROM inimigo_esta_area WHERE area_id = ?";
        connect();
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            sql = "DELETE FROM area WHERE id=?";
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
        String sql = "SELECT max(id) FROM area";
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

    public void researchAreaInimigo(int id)
    {
        connect();
        String sql = "SELECT A.nome FROM area AS A, inimigo_esta_area as IA WHERE IA.inimigo_id = ? AND A.id = IA.area_id";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            result = pst.executeQuery();

            while(result.next()){
                String areaNome = result.getString("A.nome");
                System.out.println("Nome da Area = " + areaNome);
            }
            System.out.println("------------------------------");
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
    }

    public int[] researchAllAreasNEsta(int id)
    {
        connect();
        int[] ids = new int[100];
        int i = 0;
        int a = 0;
        String sql = "SELECT id,nome FROM area WHERE id NOT IN (SELECT A.id FROM area AS A, inimigo_esta_area AS IA WHERE A.id = IA.area_id AND IA.inimigo_id = ?)";
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
                sql = "SELECT inimigo_id FROM inimigo_esta_area WHERE inimigo_id = ?";
                pst = connection.prepareStatement(sql);
                pst.setInt(1, id);
                result = pst.executeQuery();
                if(result.next());
                else
                {
                    sql = "SELECT id, nome FROM area";
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

    public int[] researchAllAreasEsta(int id)
    {
        connect();
        int[] ids = new int[100];
        int i = 0;
        int a = 0;
        String sql = "SELECT id,nome FROM area WHERE id IN (SELECT A.id FROM area AS A, inimigo_esta_area AS IA WHERE A.id = IA.area_id AND IA.inimigo_id = ?)";
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
                sql = "SELECT inimigo_id FROM inimigo_esta_area WHERE inimigo_id = ?";
                pst = connection.prepareStatement(sql);
                pst.setInt(1, id);
                result = pst.executeQuery();
                if(!result.next());
                else
                {
                    sql = "SELECT id, nome FROM area";
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
