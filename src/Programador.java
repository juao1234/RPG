package RPG;

public class Programador extends Personagem {
    public Programador(String nome) {
        super(nome, 70, 20, 10, (short) 1);

        Item salgado = new Item("Salgado", "Cura 20 HP", "CURA_HP", 1, 20);
        this.getInventario().adicionarItem(salgado);
    }

    @Override
    public int calcularAtaque() {
        int bonus = 4;
        System.out.println(getNome() + " usa Lógica de Ataque! O ataque será calculado com um bônus de +" + bonus);
        return getAtaque() + bonus;
    }

    public Programador(Programador other) {
        super(other);
    }
}

