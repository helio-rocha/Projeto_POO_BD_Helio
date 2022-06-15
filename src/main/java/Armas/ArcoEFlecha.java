package Armas;

public class ArcoEFlecha extends Arma
{
    public ArcoEFlecha()
    {

    }

    public int calculaDano(int dano, int destreza, int forca, int armadura)
    {
        return (int) (dano*(0.7*destreza + 0.3*forca) - armadura);
    }

}
