package Personagens.Players;

import Armas.Arma;

import java.util.List;

public abstract class Player
{
    protected int id;
    protected String nome;
    protected int danoBase;
    protected int vida;
    protected int danoTotal;

    static int vidaBase;

    protected int vitalidade;
    protected int forca;
    protected int inteligencia;
    protected int destreza;
    protected int sabedoria;
    protected Arma arma;

    protected List inventario;

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
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Dano base: " + danoBase);
        System.out.println("Dano Total: " + danoTotal);

        System.out.println("Vitalidade: " + vitalidade);
        System.out.println("inteligência: " + inteligencia);
        System.out.println("Forca: " + forca);
        System.out.println("Destreza: " + destreza);
        System.out.println("Sabedoria: " + sabedoria);

        if (arma!=null)
        {
            System.out.println("Arma equipada");
            System.out.println("Nome da arma: " + arma.getNome());
            System.out.println("Dano da arma: " + arma.getDano());
        }
    }

    public void mudaNome(String nome)
    {
        this.nome = nome;
    }

    public void mostraInventario()
    {
        // Busca no BD
        System.out.println("Se deseja equipar uma arma aperte o seu número, caso contrário aperte 0 para sair");
    }

    public void criarArma(String nome,int dano)
    {
        Arma arma = new Arma(nome, dano);
        this.addInventario(arma);
    }

    public void addInventario(Arma arma)
    {
        // adicionar BD
        // adiciona inventário
    }

    public void trocarArma(Arma arma)
    {
        this.addInventario(this.arma);
        this.arma = arma;
        this.removeInventario(arma);
    }

    public void removeInventario(Arma arma)
    {
        // Remove lista
        // Remove BD
    }

}
