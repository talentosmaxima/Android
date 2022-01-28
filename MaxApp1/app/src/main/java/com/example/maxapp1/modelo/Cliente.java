package com.example.maxapp1.modelo;

 import java.io.Serializable;

public class Cliente implements Serializable {

      private String id ,codigo;
       private  String razao_social,nomeFantasia,cnpj, ramo_atividade,endereco,status;
      private Contatos[] contatos = new Contatos[1];

    public Cliente() {
    }

    public Contatos[] getContatos() {
        return contatos;
    }

    public void setContatos(Contatos[] contatos) {
        this.contatos = contatos;
    }
    public void setContatosL(Contatos contatos) {
        this.contatos[0]=contatos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRamo_atividade() {
        return ramo_atividade;
    }

    public void setRamo_atividade(String ramo_atividade) {
        this.ramo_atividade = ramo_atividade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", codigo=" + codigo +
                ", razao_social='" + razao_social + '\'' +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", ramo_atividade='" + ramo_atividade + '\'' +
                ", endereco='" + endereco + '\'' +
                ", status='" + status + '\'' +
                '}';
    }


}
