package RPG;

import java.util.Objects;

public class Item implements Comparable<Item>, Cloneable {
    private String nome;
    private String descricao;
    private String efeito;
    private int quantidade;

    public Item() {
        this.nome = "";
        this.descricao = "";
        this.efeito = "";
        this.quantidade = 0;
    }

    public Item(String nome, String descricao, String efeito, int quantidade) {
        setNome(nome);
        setDescricao(descricao);
        setEfeito(efeito);
        setQuantidade(quantidade);
    }

    public Item(Item other) {
        if (other == null) throw new IllegalArgumentException("Item de cópia não pode ser nulo.");
        this.nome = other.nome;
        this.descricao = other.descricao;
        this.efeito = other.efeito;
        this.quantidade = other.quantidade;
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

    public boolean usar() {
        if (quantidade <= 0) return false;
        quantidade--;
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
                '}';
    }
}
