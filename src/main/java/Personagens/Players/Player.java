package Personagens.Players;

import Armas.Arma;

import java.util.List;

public class Player
{
    protected int id;
    protected String nome;
    protected int vida;
    protected int danoTotal;
    protected int danoBase;

    static int vidaBase;

    protected int vitalidade;
    protected int forca;
    protected int sabedoria;
    protected int inteligencia;
    protected int destreza;
    protected Arma arma;

    protected List inventario;

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
        this.danoBase = danoBase;
        this.vitalidade = vitalidade;
        this.forca = forca;
        this.sabedoria = sabedoria;
        this.inteligencia = inteligencia;
        this.destreza = destreza;
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

        arma = new Arma("Sem arma", 0);

        danoTotal = danoBase + arma.getDano();
    }

    public Player()
    {

    }

    public int getVida()
    {
        return vida;
    }

    public void setVida(int vida)
    {
        this.vida = vida;
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

    public static int getVidaBase()
    {
        return vidaBase;
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

    public List getInventario()
    {
        return inventario;
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
        System.out.println();
    }

    public void mudaNome(String nome)
    {
        this.nome = nome;
    }

}
