package Armas;

public class Arma
{
    protected int id;
    protected String nome;

    protected int dano;
    protected boolean is_equipado;

    public int getDano()
    {
        return dano;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Arma(String nome, int dano)
    {
        this.nome = nome;
        this.dano = dano;
    }

    public Arma()
    {

    }

    public Arma(int id, String nome, int dano, boolean is_equipado)
    {
        this.id = id;
        this.nome = nome;
        this.dano = dano;
        this.is_equipado = is_equipado;
    }

    public void printStatus()
    {
        String equipado;
        if (is_equipado) equipado = "Sim";
        else equipado = "Nao";
        System.out.println("Nome: " + nome);
        System.out.println("Dano: " + dano);
        System.out.println("Esta equipada: " + equipado);
        System.out.println();
    }

    public int getId()
    {
        return id;
    }

    public boolean isIs_equipado()
    {
        return is_equipado;
    }
}
