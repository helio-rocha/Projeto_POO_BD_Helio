package Personagens.Players;

import Personagens.Inimigos.Inimigo;
import Personagens.Personagem;

public class Arqueiro extends Player
{
    public Arqueiro(String nome)
    {
        super(nome);
        this.aumentaDestreza(4);
        this.aumentaForca(3);
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
