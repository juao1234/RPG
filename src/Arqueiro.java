package RPG;

public class Arqueiro extends Personagem{
    public Arqueiro(String nome) throws Exception{
        super(nome, 90, 12, 10, (short) 1);

        Item refrigerante = new Item("Refrigerante", "Recupera 10 HP",
                "CURA_HP", 1, 10);
        this.getInventario().adicionarItem(refrigerante);
    }

    //Ainda falta definir o nome final e suas características próprias\

    public Arqueiro(Arqueiro other) {
               super(other);
    }
}
