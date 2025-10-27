package RPG;

import java.util.Random;

public class Arquiteto extends Personagem {
    public Arquiteto(String nome) {
        super(nome, 90, 12, 10, (short) 1);

        Item refrigerante = new Item("Refrigerante", "Recupera 10 HP",
                "CURA_HP", 1, 10);
        this.getInventario().adicionarItem(refrigerante);
    }

    @Override
    public int calcularAtaque() {
       
        return getAtaque();
    }

    public void planejamentoEstrutural() {
        int bonus = 2;
        setDefesa(getDefesa() + bonus);
        System.out.println(getNome() + " planeja sua defesa! Defesa aumentada em " + bonus + " (Permanente/Até o fim da batalha).");
    }

    
    public int ataqueADistancia(Inimigo alvo) {
        Random random = new Random();
        int dado = random.nextInt(6) + 1; 
        int dano = getAtaque() + dado - alvo.getDefesa();
        System.out.println(getNome() + " ataca à distância com precisão! Dano: " + dano);
        return Math.max(0, dano);
    }

    public Arquiteto(Arquiteto other) {
        super(other);
    }
}
