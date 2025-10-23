package RPG;

public class Inimigo extends Personagem{
    public Inimigo(String nome, int pontosVida, int ataque, int defesa, short nivel) throws Exception{
        super(nome, pontosVida, ataque, defesa, nivel);
    }

    //Aqui não precisa repetir os métodos da classe Personagem,
    //a não ser que queira usar o @Override caso o inimigo for fazer algo de especial comparado a classe Personagem.
    //Atualmente o Inimigo é idêntico ao Personagem, dps a gnt decide o que for fazer de diferente.

    public Inimigo(Inimigo other) {
        super(other);
    }
}
