package RPG;

public class Arqueiro extends Personagem{
    public Arqueiro(String nome, int pontosVida, int ataque, int defesa, short nivel) throws Exception{
        super(nome, pontosVida, ataque, defesa, nivel);
    }

    //Ainda falta definir o nome final e suas características próprias\

    public Arqueiro(Arqueiro other) {
               super(other);
    }
}
