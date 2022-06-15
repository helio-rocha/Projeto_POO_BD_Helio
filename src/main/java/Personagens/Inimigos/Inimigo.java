package Personagens.Inimigos;

import Personagens.Combate;
import Personagens.Personagem;

public abstract class Inimigo extends Personagem implements Combate
{
    protected int dano;

    public int getVida()
    {
        return vida;
    }

    public int getDano()
    {
        return dano;
    }

    public int getArmadura()
    {
        return pontosArmadura;
    }

    public void setVida(int vida)
    {
        this.vida = vida;
    }

    public void setDano(int dano)
    {
        this.dano = dano;
    }

    public void setArmadura(int armadura)
    {
        this.pontosArmadura = armadura;
    }



}
