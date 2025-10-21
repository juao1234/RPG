package RPG;

public class Main {
    public static void main(String[] args) {
        try{
//            Viloes compsognathus = new Viloes("Compsognathus", 35, 12, 4, 2);
//            Viloes velociraptor  = new Viloes("Velociraptor",  60, 18, 6, 3);
//            Viloes pterodactilo  = new Viloes("Pterodáctilo",  45, 14, 5, 2);
//            Viloes droneRecon    = new Viloes("Drone Recon",   25, 10, 2, 1);
//            Viloes triceratops   = new Viloes("Triceratops",   90, 20, 8, 4);
//            Viloes soldadoElite  = new Viloes("Soldado Elite", 70, 22, 7, 4);

            //Personagem teste = new Personagem("Guerreiro", 100, 10, 10, (short) 1);
            //System.out.println(teste.toString());

            //Personagem teste2 = new Personagem("Augusto", 100, 10, 10, (short) 2);
            //System.out.println(teste.equals(teste2));

            Inimigo testeInimigo = new Inimigo("Alienígena verde", 50, 75, 10, (short) 3);

            Mago testeMago = new Mago("Engenheiro de software", 5, 100, 50, (short) 1);
            System.out.println(testeMago.toString());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}