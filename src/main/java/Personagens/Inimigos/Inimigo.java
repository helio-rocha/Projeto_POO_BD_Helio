package Personagens.Inimigos;

public class Inimigo
{
    protected int id;
    public String nome;
    protected int dano;
    protected int vida;

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

    public void setVida(int vida)
    {
        this.vida = vida;
    }

    public void setDano(int dano)
    {
        this.dano = dano;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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
