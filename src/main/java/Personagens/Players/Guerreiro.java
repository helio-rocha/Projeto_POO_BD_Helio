package Personagens.Players;

public class Guerreiro extends Player
{

    public Guerreiro(String nome)
    {
        super(nome);
        vitalidade += 3;
        forca += 4;
        danoBase += forca*10;
        vida += vitalidade*10;
    }



}
