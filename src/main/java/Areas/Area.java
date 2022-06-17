package Areas;

import Personagens.Inimigos.Inimigo;

public class Area
{
    private int id;
    private String nome;
    private Inimigo[] inimigos;

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

    public Inimigo[] getInimigos()
    {
        return inimigos;
    }

    public void setInimigos(Inimigo[] inimigos)
    {
        this.inimigos = inimigos;
    }

    public void printStatus()
    {
        System.out.println("Nome: " + nome);
        System.out.println("Id: " + id);


    }
}
