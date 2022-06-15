package Personagens.Players;

import Personagens.Inimigos.Inimigo;
import Personagens.Personagem;

public class Guerreiro extends Player
{

    public Guerreiro(String nome)
    {
        super(nome);
        this.aumentaVitalidade(3);
        this.aumentaForca(4);
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
