package Armas;

public abstract class Arma
{
    protected String nome;

    protected int dano;

    public int getDano()
    {
        return dano;
    }

    abstract public int calculaDano(int dano, int atrib1, int atrib2, int armadura);

    public String getNome()
    {
        return nome;
    }
}
