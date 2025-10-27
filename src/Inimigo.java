package RPG;

import java.util.Random;

public class Inimigo extends Personagem {
    
    public Inimigo(String nome, int pontosVida, int ataque, int defesa, short nivel) {
        super(nome, pontosVida, ataque, defesa, nivel);
    }

    public Inimigo(Inimigo other) {
        super(other);
    }

    @Override
    public int calcularAtaque() {
        // Inimigos usam seu ataque base
        return getAtaque();
    }

    public static Inimigo gerarInimigo(String localizacao) {
        Random dado = new Random();
        int chance = dado.nextInt(100); 
        String loc = (localizacao == null) ? "" : localizacao.trim();

        if (loc.equalsIgnoreCase("Prédio H") || loc.equalsIgnoreCase("Predio H")
                || loc.equalsIgnoreCase("Biblioteca")) {

            if (chance < 50) {
                return new Inimigo("Drone Sentinela", 90, 8, 15, (short) 3);
            } else if (chance < 85) {
                return new Inimigo("Soldado Invasor", 70, 15, 8, (short) 3);
            } else {
                return new Inimigo("Comandante Alienígena", 150, 25, 15, (short) 5);
            }
        }

       
        if (chance < 60) {
            return new Inimigo("Drone de Patrulha", 40, 10, 5, (short) 1);
        } else if (chance < 90) {
            return new Inimigo("Soldado Invasor", 70, 15, 8, (short) 3);
        } else {
            return new Inimigo("Drone Sentinela", 90, 8, 15, (short) 3);
        }
    }
}
