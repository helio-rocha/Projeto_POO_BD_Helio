package Areas;

import Personagens.Inimigos.Geral.Slime;
import Personagens.Inimigos.MontanhaGelida.BonecoDeNeve;
import Personagens.Inimigos.MontanhaGelida.Ieti;

public class MontanhaGelida extends Area
{
    public MontanhaGelida()
    {
        inimigos[0] = new BonecoDeNeve();
        inimigos[1] = new Ieti();
        inimigos[2] = new Slime();
    }
}
