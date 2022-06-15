package Personagens.Players;

import Armas.ArcoEFlecha;
import Armas.Arma;
import Armaduras.Armadura;
import Armas.EspadaLonga;
import Personagens.Combate;
import Personagens.Inimigos.Inimigo;
import Personagens.Personagem;

import java.util.List;

public abstract class Player extends Personagem implements Combate
{
    protected int pontosAtaque;
    protected String nome;

    static int vidaBase;

    protected int vitalidade;
    protected int forca;
    protected int inteligencia;
    protected int destreza;
    protected int sabedoria;

    protected Armadura armadura;
    protected Arma arma;

    public Player(String nome)
    {
        vitalidade += 5;
        forca += 5;
        inteligencia += 5;
        destreza += 5;
        sabedoria += 5;

        this.nome = nome;

        vida = vidaBase + 10*vitalidade;
        pontosArmadura = 0;

        armadura = new Armadura("Sem Armadura",0);
        arma = null;
    }

    public void aumentaForca(int quant)
    {
        forca += quant;
        pontosAtaque += forca*10;
    }

    public void aumentaVitalidade(int quant)
    {
        vitalidade += quant;
        vida += vitalidade*10;
    }

    public void aumentaInteligencia(int quant)
    {
        inteligencia += quant;
        pontosAtaque += inteligencia*10;
    }

    public void aumentaDestreza(int quant)
    {
        destreza += quant;
        pontosAtaque += destreza*10;
    }

    public void aumentaSabedoria(int quant)
    {
        sabedoria += quant;
        pontosAtaque += sabedoria*10;
    }

    protected int calcDano(Inimigo inimigo)
    {
        int danoEfetivo;
        if(arma instanceof ArcoEFlecha)
        {
            danoEfetivo = arma.calculaDano(arma.getDano(),destreza,forca,inimigo.getArmadura());
        }
        else if (arma instanceof EspadaLonga)
        {
            danoEfetivo = arma.calculaDano(arma.getDano(),forca,vitalidade,inimigo.getArmadura());
        }
        else
        {
            danoEfetivo = arma.calculaDano(arma.getDano(),inteligencia,sabedoria,inimigo.getArmadura());
        }
        return danoEfetivo;
    }


    public int getVida()
    {
        return vida;
    }

    public void setVida(int vida)
    {
        this.vida = vida;
    }

    public int getPontosArmadura()
    {
        return pontosArmadura;
    }

    public void setPontosArmadura(int pontosArmadura)
    {
        this.pontosArmadura = pontosArmadura;
    }

    public void printStatus()
    {
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Pontos de Armadura: " + pontosArmadura);

        System.out.println("Vitalidade: " + vitalidade);
        System.out.println("inteligência: " + inteligencia);
        System.out.println("Forca: " + forca);
        System.out.println("Destreza: " + destreza);
        System.out.println("Sabedoria: " + sabedoria);

        System.out.println("Arma equipada");
        System.out.println("Nome da arma: " + arma.getNome());
        System.out.println("Dano da arma: " + arma.getDano());

    }
}
