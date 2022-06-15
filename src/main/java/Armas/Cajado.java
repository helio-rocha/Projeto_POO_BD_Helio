package Armas;

public class Cajado extends Arma
{
    public Cajado()
    {
    }


    @Override
    public int calculaDano(int dano, int inteligencia, int sabedoria, int armadura)
    {
            return (int) (dano*(0.7*sabedoria + 0.3*inteligencia) - armadura);
    }
}
