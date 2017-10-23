package com.example.jean_.pocketmarket.modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

public abstract class usuario {

    private int CPFCNPJ;

    private byte Foto;

    private String tipoUsuario;

    private int DDDTelefoneOuCelular;

    private int telefoneOuCelular;

    private String email;

    private String enderecoComResi;

    private int CEPComResi;

    private String complementoComResi;

    private String numeroComResi;

    private String bairroComResi;

    private String cidadeComResi;

    private String UFComResi;

    private String login;

    private String senha;


    public void setCPFCNPJ(int CPFCNPJ) {
        this.CPFCNPJ = CPFCNPJ;
    }

    public int getCPFCNPJ() {
        return CPFCNPJ;
    }

    public void setFoto(byte Foto) {
        this.Foto = Foto;
    }

    public byte getFoto() {
        return Foto;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setDDDTelefoneOuCelular(int DDDTelefoneOuCelular) {
        this.DDDTelefoneOuCelular = DDDTelefoneOuCelular;
    }

    public int getDDDTelefoneOuCelular() {
        return DDDTelefoneOuCelular;
    }

    public void setTelefoneOuCelular(int telefoneOuCelular) {
        this.telefoneOuCelular = telefoneOuCelular;
    }

    public int getTelefoneOuCelular() {
        return telefoneOuCelular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEnderecoComResi(String enderecoComResi) {
        this.enderecoComResi = enderecoComResi;
    }

    public String getEnderecoComResi() {
        return enderecoComResi;
    }

    public void setCEPComResi(int CEPComResi) {
        this.CEPComResi = CEPComResi;
    }

    public int getCEPComResi() {
        return CEPComResi;
    }

    public void setComplementoComResi(String complementoComResi) {
        this.complementoComResi = complementoComResi;
    }

    public String getComplementoComResi() {
        return complementoComResi;
    }

    public void setNumeroComResi(String numeroComResi) {
        this.numeroComResi = numeroComResi;
    }

    public String getNumeroComResi() {
        return numeroComResi;
    }

    public void setBairroComResi(String bairroComResi) {
        this.bairroComResi = bairroComResi;
    }

    public String getBairroComResi() {
        return bairroComResi;
    }

    public void setCidadeComResi(String cidadeComResi) {
        this.cidadeComResi = cidadeComResi;
    }

    public String getCidadeComResi() {
        return cidadeComResi;
    }

    public void setUFComResi(String UFComResi) {
        this.UFComResi = UFComResi;
    }

    public String getUFComResi() {
        return UFComResi;
    }

    public void setLogin(String loginComResi) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

}

