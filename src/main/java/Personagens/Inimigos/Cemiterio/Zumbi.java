package Personagens.Inimigos.Cemiterio;

import Personagens.Inimigos.Inimigo;
import Personagens.Personagem;

public class Zumbi extends Inimigo
{
    @Override
    public void ataqueRapido(Personagem personagem)
    {
        this.atacar(personagem,dano);
    }

    @Override
    public void atacar(Personagem personagem, int danoEfetivo)
    {
        personagem.setVida(personagem.getVida()-danoEfetivo);
    }

    @Override
    public void ataqueLento(Personagem personagem)
    {
        int danoEfetivo = 2*dano;
        this.atacar(personagem,danoEfetivo);
    }
}
