package Personagens.Players;

public class Arqueiro extends Player
{
    public Arqueiro(String nome)
    {
        super(nome);
        forca += 3;
        destreza += 4;
        danoBase += destreza*10;
        danoBase += forca*10;
    }



}
