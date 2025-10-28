package RPG;

public class Arquiteto extends Personagem {
    public Arquiteto(String nome) {
        super(nome, 90, 15, 12, (short) 1);

        Item refrigerante = new Item("Refrigerante", "Recupera 10 HP",
                "CURA_HP", 1, 10);
        this.getInventario().adicionarItem(refrigerante);
    }

    @Override
    public int calcularAtaque() {
        return getAtaque();
    }

    public Arquiteto(Arquiteto other) {
        super(other);
    }
}
