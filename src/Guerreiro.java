package RPG;

public class Guerreiro extends Personagem{
    public Guerreiro(String nome) throws Exception{
        super(nome, 120, 8, 15, (short) 1);

        Item kit = new Item("Kit de Primeiros Socorros", "Recupera 75 HP",
                "CURA_HP", 1, 75);
        this.getInventario().adicionarItem(kit);
    }

    //Ainda falta definir o nome final e suas características próprias

    public Guerreiro(Guerreiro other) {
        super(other);
    }
}
