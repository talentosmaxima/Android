package com.example.maxapp1.modelo;

public class Legenda {
    private long numero_ped_Rca;
    private String legenda;

    public Legenda() {
    }

    public long getNumero_ped_Rca() {
        return numero_ped_Rca;
    }

    public void setNumero_ped_Rca(long numero_ped_Rca) {
        this.numero_ped_Rca = numero_ped_Rca;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    @Override
    public String toString() {
        return "Legenda{" +
                "numero_ped_Rca=" + numero_ped_Rca +
                ", legenda='" + legenda + '\'' +
                '}';
    }
}
