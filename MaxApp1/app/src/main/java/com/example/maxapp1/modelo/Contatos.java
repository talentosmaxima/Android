package com.example.maxapp1.modelo;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Date;
import java.util.Objects;

public class Contatos {

    private String nome,telefone,celular,conjuge,tipo,time, e_mail;
    private String data_nascimento,dataNascimentoConjuge;

    public Contatos() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getConjuge() {
        return conjuge;
    }

    public void setConjuge(String conjuge) {
        this.conjuge = conjuge;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getDataNascimentoConjuge() {
        return dataNascimentoConjuge;
    }

    public void setDataNascimentoConjuge(String dataNascimentoConjuge) {
        this.dataNascimentoConjuge = dataNascimentoConjuge;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone, celular, conjuge, tipo, time, e_mail, data_nascimento, dataNascimentoConjuge);
    }

    @Override
    public String toString() {
        return "Contatos{" +
                "nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", celular='" + celular + '\'' +
                ", conjuge='" + conjuge + '\'' +
                ", tipo='" + tipo + '\'' +
                ", time='" + time + '\'' +
                ", eMail='" + e_mail + '\'' +
                ", dataNascimento=" + data_nascimento +
                ", dataNascimentoConjuge=" + dataNascimentoConjuge +
                '}';
    }
}
