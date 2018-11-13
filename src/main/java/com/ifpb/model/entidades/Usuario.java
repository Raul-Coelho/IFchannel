package com.ifpb.model.entidades;

public class Usuario {

    private int id;
    private String email;
    private String senha;
    private String nome;
    private String sexo;
    private String foto;
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
    private String telefone;
    private String numero;

    public Usuario() {
    }

    public Usuario(String email, String senha, String nome, String sexo, String foto, String rua, String cidade,
                   String estado, String cep, String telefone, String numero) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.sexo = sexo;
        this.foto = foto;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
        this.numero = numero;
    }

    public Usuario(int id, String email, String senha, String nome, String sexo, String foto, String rua, String cidade, String estado, String cep, String telefone, String numero) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.sexo = sexo;
        this.foto = foto;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.telefone = telefone;
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", foto='" + foto + '\'' +
                ", rua='" + rua + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

}
