package Areas;

import Personagens.Inimigos.Cemiterio.Esqueleto;
import Personagens.Inimigos.Cemiterio.Zumbi;
import Personagens.Inimigos.Geral.Morcego;

public class Cemiterio extends Area
{
    public Cemiterio()
    {
        inimigos[0] = new Esqueleto();
        inimigos[1] = new Zumbi();
        inimigos[2] = new Morcego();
    }
}
