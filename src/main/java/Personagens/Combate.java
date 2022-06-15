package Personagens;

import Personagens.Inimigos.Inimigo;

public interface Combate
{
    void ataqueRapido(Personagem personagem);
    void atacar(Personagem personagem, int danoEfetivo);
    void ataqueLento(Personagem personagem);
}
