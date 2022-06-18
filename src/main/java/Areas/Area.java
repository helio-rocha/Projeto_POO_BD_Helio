package Areas;

import Inimigos.Inimigo;

import java.util.ArrayList;
import java.util.List;

public class Area
{
    private int id;
    private String nome;
//    private Inimigo[] inimigos;
    public ArrayList<Inimigo> inimigos;

    public Area(String nome)
    {
        this.nome = nome;
    }

    public Area(int id, String nome)
    {
        this.id = id;
        this.nome = nome;
    }

    public int getId()
    {
        return id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public ArrayList<Inimigo> getInimigos()
    {
        return inimigos;
    }

    public void setInimigos(ArrayList<Inimigo> inimigos)
    {
        this.inimigos = inimigos;
    }

    public void printStatus()
    {
        System.out.println("Nome: " + nome);
        System.out.println("Id: " + id);
        System.out.println();
        if (inimigos.size()>0)
        {
            System.out.println("Inimigos");
            System.out.println();
            for (Inimigo inimigo : inimigos)
            {
                inimigo.printStatus();
                System.out.println();
            }
        }
        else System.out.println("Area sem inimigos");
    }
}
