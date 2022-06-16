package Personagens.Inimigos;

public abstract class Inimigo
{
    protected int dano;
    public String nome;
    protected int vida;

    public Inimigo()
    {
        this.dano = 10;
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

}
