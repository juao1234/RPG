package RPG;

public class Atleta extends Personagem {
    public Atleta(String nome) {
        super(nome, 120, 12, 16, (short) 1);

        Item kit = new Item("Kit de Primeiros Socorros", "Recupera 75 HP",
                "CURA_HP", 1, 75);
        this.getInventario().adicionarItem(kit);
    }

    @Override
    public int calcularAtaque() {
        int bonus = 5;
        System.out.println(this.getNome() + " usa Impulso Atlético! O ataque será calculado com um bônus de +" + bonus);
        return this.getAtaque() + bonus;
    }

    public Atleta(Atleta other) {
        super(other);
    }
}
