package Armas;

public class Arma
{
    protected String nome;

    protected int dano;

    public int getDano()
    {
        return dano;
    }

    public String getNome()
    {
        return nome;
    }

    public Arma(String nome, int dano)
    {
        this.nome = nome;
        this.dano = dano;
    }
}
