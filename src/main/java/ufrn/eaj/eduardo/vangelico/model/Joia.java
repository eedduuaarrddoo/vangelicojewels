package ufrn.eaj.eduardo.vangelico.model;

public class Joia {
    private int id;
    private float valor;
    private float peso;
    private float quilate;
    private String tipo;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getQuilate() {
        return quilate;
    }

    public void setQuilate(float quilate) {
        this.quilate = quilate;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public String toString() {
        return "Joia{" +
                "id=" + id +
                ", valor=" + valor +
                ", peso=" + peso +
                ", quilate=" + quilate +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
