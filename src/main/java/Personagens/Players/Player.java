package Personagens.Players;

import Armas.Arma;


public class Player
{
    private int id;
    private String nome;
    private int vida;
    private int danoTotal;
    private final int danoBase = 50;

    static int vidaBase;

    private int vitalidade;
    private int forca;
    private int sabedoria;
    private int inteligencia;
    private int destreza;
    private Arma arma;


    public int getId()
    {
        return id;
    }

    public Player(int id, String nome, int vida, int danoTotal, int danoBase, int vitalidade, int forca, int sabedoria, int inteligencia, int destreza)
    {
        this.id = id;
        this.nome = nome;
        this.vida = vida;
        this.danoTotal = danoTotal;
        this.vitalidade = vitalidade;
        this.forca = forca;
        this.sabedoria = sabedoria;
        this.inteligencia = inteligencia;
        this.destreza = destreza;
        this.arma = arma;
    }

    public Player(String nome)
    {
        vitalidade = 5;
        forca = 5;
        inteligencia = 5;
        destreza = 5;
        sabedoria = 5;

        this.nome = nome;

        vida = vidaBase + 10*vitalidade;

        danoTotal = danoBase;
    }

    public Player()
    {

    }

    public int getVida()
    {
        return vida;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getDanoBase()
    {
        return danoBase;
    }

    public int getDanoTotal()
    {
        return danoTotal;
    }


    public int getVitalidade()
    {
        return vitalidade;
    }

    public int getForca()
    {
        return forca;
    }

    public int getInteligencia()
    {
        return inteligencia;
    }

    public int getDestreza()
    {
        return destreza;
    }

    public int getSabedoria()
    {
        return sabedoria;
    }

    public Arma getArma()
    {
        return arma;
    }


    public void printStatus()
    {
        System.out.println();
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Dano base: " + danoBase);
        System.out.println("Dano Total: " + danoTotal);

        System.out.println("Vitalidade: " + vitalidade);
        System.out.println("inteligencia: " + inteligencia);
        System.out.println("Forca: " + forca);
        System.out.println("Destreza: " + destreza);
        System.out.println("Sabedoria: " + sabedoria);

        if (arma!=null)
        {
            System.out.println("Arma equipada");
            System.out.println("Nome da arma: " + arma.getNome());
            System.out.println("Dano da arma: " + arma.getDano());
        }
        else
        {
            System.out.println("Sem arma");
        }
        System.out.println();
    }

    public void setArma(Arma arma)
    {
        this.arma = arma;
    }

    public void setDanototal(int danoBase)
    {
        this.danoTotal = danoBase;
    }
}
