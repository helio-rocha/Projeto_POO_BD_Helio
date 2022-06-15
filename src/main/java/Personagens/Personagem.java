package Personagens;

public abstract class Personagem
{
    protected int vida;
    protected int pontosArmadura;

    public int getVida()
    {
        return vida;
    }

    public void setVida(int vida)
    {
        this.vida = vida;
    }

    public int getArmadura()
    {
        return pontosArmadura;
    }

    public void setArmadura(int armadura)
    {
        this.pontosArmadura = armadura;
    }
}
