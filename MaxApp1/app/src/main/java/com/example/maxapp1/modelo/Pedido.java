package com.example.maxapp1.modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Pedido implements Serializable {


    private long numero_ped_Rca;
    private String numero_ped_erp;
    private String codigoCliente;
    private String  NOMECLIENTE;
    private  Date data;
    private String status;
    private String critica;
    private String tipo;
    @SerializedName("legendas")
    @Expose
    private String[] legendas;

    public long getNumero_ped_Rca() {
        return numero_ped_Rca;
    }

    public void setNumero_ped_Rca(long numero_ped_Rca) {
        this.numero_ped_Rca = numero_ped_Rca;
    }

    public String getNumero_ped_erp() {
        return numero_ped_erp;
    }

    public void setNumero_ped_erp(String numero_ped_erp) {
        this.numero_ped_erp = numero_ped_erp;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNOMECLIENTE() {
        return NOMECLIENTE;
    }

    public void setNOMECLIENTE(String NOMECLIENTE) {
        this.NOMECLIENTE = NOMECLIENTE;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCritica() {
        return critica;
    }

    public void setCritica(String critica) {
        this.critica = critica;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String[] getLegendas() {

        return legendas;
    }

    public void setLegendas(String[] legendas) {
        this.legendas = legendas;
    }

    public Pedido() {
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numero_ped_Rca=" + numero_ped_Rca +
                ", numero_ped_erp='" + numero_ped_erp + '\'' +
                ", codigoCliente='" + codigoCliente + '\'' +
                ", NOMECLIENTE='" + NOMECLIENTE + '\'' +
                ", data=" + data +
                ", status='" + status + '\'' +
                ", critica='" + critica + '\'' +
                ", tipo='" + tipo + '\'' +
                ", legendas=" + legendas +
                '}';
    }


}
