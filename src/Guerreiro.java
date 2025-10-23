package RPG;

public class Guerreiro extends Personagem{
    public Guerreiro(String nome, int pontosVida, int ataque, int defesa, short nivel) throws Exception{
        super(nome, pontosVida, ataque, defesa, nivel);
    }

    //Ainda falta definir o nome final e suas características próprias

    public Guerreiro(Guerreiro other) {
        super(other);
    }
}
