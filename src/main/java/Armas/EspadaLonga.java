package Armas;

public class EspadaLonga extends Arma
{
    public EspadaLonga()
    {
    }

    @Override
    public int calculaDano(int dano, int forca, int vitalidade, int armadura)
    {
        return (int) (dano*(0.7*forca + 0.3*vitalidade) - armadura);
    }
}
