package modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

public class servico {

    private String tituloServico;

    private String descricaoServico;

    private String categoriaServico;

    private float precoServico;


    public void setTituloServico(String tituloServico) {
        this.tituloServico = tituloServico;
    }

    public String getTituloServico() {
        return tituloServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setCategoriaServico(String categoriaServico) {
        this.categoriaServico = categoriaServico;
    }

    public String getCategoriaServico() {
        return categoriaServico;
    }

    public void setPrecoServico(float precoServico) {
        this.precoServico = precoServico;
    }

    public float getPrecoServico() {
        return precoServico;
    }

}

