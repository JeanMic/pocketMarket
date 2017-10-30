package com.example.jean_.pocketmarket.modelo;

/**
 * Created by jean_ on 11/09/2017.
 */

public abstract class usuario {

    private int CPFCNPJ; //ok

    private byte Foto; //verificar depois

    private String tipoUsuario; //sera preenchido em tempo de execucao

    private int DDDTelefoneOuCelular; //ok

    private int telefoneOuCelular; //ok

    private String email; //ok

    private String enderecoComResi; //ok

    private int CEPComResi; //ok

    private String complementoComResi; //ok

    private String numeroComResi; //ok

    private String bairroComResi;//ok

    private String cidadeComResi; //ok

    private String UFComResi; //ok

    private String login; //vou remover

    private String senha; //ok


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

