package Personagens.Players;

public class Mago extends Player
{
    public Mago(String nome)
    {
        super(nome);
        inteligencia += 3;
        sabedoria += 4;
        danoBase += inteligencia*10;
        danoBase += sabedoria*10;
    }

}
