package Personagens.Inimigos;

public class Inimigo
{
    private int id;
    public String nome;
    private int dano;
    private int vida;

    public Inimigo()
    {
        this.dano = 10;
    }

    public Inimigo(String nome,int dano, int vida)
    {
        this.dano = dano;
        this.nome = nome;
        this.vida = vida;
    }

    public Inimigo(int id, String nome, int dano, int vida)
    {
        this.id = id;
        this.nome = nome;
        this.dano = dano;
        this.vida = vida;
    }

    public String getNome()
    {
        return nome;
    }

    public int getVida()
    {
        return vida;
    }

    public int getDano()
    {
        return dano;
    }


    public int getId()
    {
        return id;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void printStatus()
    {
        System.out.println("id: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Dano: " + dano);
        System.out.println("Vida: " + vida);
    }
}
