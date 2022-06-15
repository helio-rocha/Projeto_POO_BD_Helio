package Personagens.Players;

import Personagens.Inimigos.Inimigo;
import Personagens.Personagem;

public class Mago extends Player
{
    public Mago(String nome)
    {
        super(nome);
        this.aumentaSabedoria(4);
        this.aumentaInteligencia(3);
    }

    @Override
    public void ataqueRapido(Personagem personagem)
    {

        this.atacar(personagem,this.calcDano((Inimigo) personagem));
    }

    @Override
    public void atacar(Personagem personagem, int danoEfetivo)
    {
        personagem.setVida(personagem.getVida()-danoEfetivo);
    }

    @Override
    public void ataqueLento(Personagem personagem)
    {
        int danoEfetivo = this.calcDano((Inimigo) personagem);
        danoEfetivo = 2*danoEfetivo;
        this.atacar(personagem,danoEfetivo);
    }

}
