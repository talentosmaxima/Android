package com.example.maxapp1.recursos;

public class Mascara {
    public Mascara() {
    }

    public String Mascara(String mascara, String palavra) {

        String[] listaMascara = mascara.split("");
        String[] listaPalavra = palavra.split("");
        String retorno="";
        if(listaMascara.length>listaPalavra.length){
            int inid=0;
            for(int i =0;i<listaMascara.length;i++){
                if(listaMascara[i].equals("#")){
                    if(inid<listaPalavra.length) {
                        listaMascara[i] = listaPalavra[inid];
                        inid++;
                    }else {

                    }

                }
                retorno+=listaMascara[i];

            }
        }
        return retorno;
    }
}
