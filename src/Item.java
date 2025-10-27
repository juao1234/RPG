package RPG;

import java.util.Objects;

public class Item implements Comparable<Item>, Cloneable {
    private String nome;
    private String descricao;
    private String efeito;
    private int quantidade, qtdEfeito;

    public Item(String nome, String descricao, String efeito, int quantidade, int qtdEfeito) {
        setNome(nome);
        setDescricao(descricao);
        setEfeito(efeito);
        setQuantidade(quantidade);
        setQtdEfeito(qtdEfeito);
    }

    public Item(Item other) {
        if (other == null) throw new IllegalArgumentException("Item de cópia não pode ser nulo.");
        this.nome = other.nome;
        this.descricao = other.descricao;
        this.efeito = other.efeito;
        this.quantidade = other.quantidade;
        this.qtdEfeito = other.qtdEfeito;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEfeito() {
        return efeito;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getQtdEfeito() {
        return this.qtdEfeito;
    }

    public void setNome(String nome) {
        this.nome = nome.trim();
    }

    public void setDescricao(String descricao) {
        this.descricao = (descricao == null) ? "" : descricao.trim();
    }

    public void setEfeito(String efeito) {
        this.efeito = (efeito == null) ? "" : efeito.trim();
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) throw new IllegalArgumentException("Quantidade não pode ser negativa.");
        this.quantidade = quantidade;
    }

    public void setQtdEfeito(int qtdEfeito) {
        if (qtdEfeito < 0) throw new IllegalArgumentException("Quantidade de efeito não pode ser negativa.");
        this.qtdEfeito = qtdEfeito;
    }

    public boolean usar(Personagem alvo) throws Exception {
        if (this.quantidade <= 0) {
            return false; // Não tem o item
        }

        switch (this.efeito) {
            case "CURA_HP":
                // Pega a vida atual e máxima do alvo
                int vidaAtual = alvo.getPontosVida();
                int vidaMaxima = alvo.getVidaMaxima();

                // SE a vida estiver cheia, IMPEDE o uso.
                if (vidaAtual >= vidaMaxima) {
                    System.out.println(alvo.getNome() + " já está com a vida cheia!");
                    return false; // Item NÃO foi consumido.
                }

                int novaVida = vidaAtual + this.qtdEfeito;
                if (novaVida > vidaMaxima) {
                    novaVida = vidaMaxima; // Trava no máximo
                }

                alvo.setPontosVida(novaVida);
                System.out.println(alvo.getNome() + " recuperou HP! Vida atual: " + novaVida + "/" + vidaMaxima);
                break;

            case "BUFF_ATK":
                // Lógica para um item de buff de ataque, tipo um energético
                int atkAtual = alvo.getAtaque();
                alvo.setAtaque(atkAtual + this.qtdEfeito);
                System.out.println(alvo.getNome() + " sente-se mais forte!");
                break;

            case "BUFF_DEF":
                // Lógica para um item de buff de defesa
                int defAtual = alvo.getDefesa();
                alvo.setDefesa(defAtual + this.qtdEfeito);
                System.out.println(alvo.getNome() + " sente-se mais resistente!");
                break;

            default:
                System.out.println(this.nome + " não tem um efeito conhecido.");
                return false;
        }

        this.quantidade--;
        return true;
    }

    @Override
    public int compareTo(Item o) {
        if (o == null) return 1;
        return this.nome.compareToIgnoreCase(o.nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return nome.equalsIgnoreCase(item.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome.toLowerCase());
    }

    @Override
    public Item clone() {
        return new Item(this);
    }

    @Override
    public String toString() {
        return "Item{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", efeito='" + efeito + '\'' +
                ", quantidade=" + quantidade +
                ", qtdEfeito=" + qtdEfeito +
                '}';
    }
}
