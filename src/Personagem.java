package RPG;

public abstract class Personagem {
    private String nome;
    private int pontosVida, ataque, defesa;
    private short nivel;
    //private Inventario inventario;

    public Personagem(String nome, int pontosVida, int ataque, int defesa, short nivel) throws Exception{
        this.setNome(nome);
        this.setPontosVida(pontosVida);
        this.setAtaque(ataque);
        this.setDefesa(defesa);
        this.setNivel(nivel);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setPontosVida(int pontosVida) throws Exception{
        if(pontosVida < 0){
            throw new Exception("Quantidade de pontos de vida inválida!");
        }
        this.pontosVida = pontosVida;
    }

    public int getPontosVida(){
        return this.pontosVida;
    }

    public void setAtaque(int ataque) throws Exception{
        if(ataque < 0){
            throw new Exception("Valor de ataque inválido!");
        }
        this.ataque = ataque;
    }

    public int getAtaque(){
        return this.ataque;
    }

    public void setDefesa(int defesa) throws Exception{
        if(defesa < 0){
            throw new Exception("Valor de defesa inválido!");
        }
        this.defesa = defesa;
    }

    public int getDefesa(){
        return this.defesa;
    }

    public void setNivel(short nivel) throws Exception{
        if(nivel < 0){
            throw new Exception("Valor de nível inválido!");
        }
        this.nivel = nivel;
    }

    public int getNivel(){
        return this.nivel;
    }

    @Override
    public String toString(){
        return String.format("Nome: %s \nHP: %d \nAtaque: %d \nDefesa: %d \nNível: %d"
                ,this.nome, this.pontosVida, this.ataque, this.defesa, this.nivel);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Personagem outro = (Personagem) o;

        return this.pontosVida == outro.pontosVida &&
                this.ataque == outro.ataque &&
                this.defesa == outro.defesa &&
                this.nivel == outro.nivel &&
                this.nome.equals(outro.nome);
    }

    @Override
    public int hashCode() {
        int ret = 1;

        ret = 31 * ret + ((this.nome == null) ? 0 : this.nome.hashCode());
        ret = 31 * ret + this.pontosVida;
        ret = 31 * ret + this.ataque;
        ret = 31 * ret + this.defesa;
        ret = 31 * ret + this.nivel;

        return ret;
    }
}
