package com.example.multiconversor.classes;

import java.util.function.DoubleToLongFunction;

public class Rentabilidade {

    private Double valorAporte;
    private Double anos;
    private Double taxaRetorno;
    private Double taxaCustodia;
    private Double taxaIr;
    private Double retornoBruto;
    private Double retornoLiquido;
    private Double lucroBruto;
    private Double lucroLiquido;
    private Double descontoIr;
    private Double outrosDescontos;
    private Double diasCorridos;

    public Rentabilidade(Double prValorAporte, Double prAnos, Double prTaxaRetorno, Double prTaxaCustodia){

        this.valorAporte = prValorAporte;
        this.anos = prAnos;
        this.taxaRetorno = prTaxaRetorno;
        this.taxaCustodia = prTaxaCustodia;

        setTaxaIr();
        setRentabilidades();

    }

    public Double getValorAporte(){
        return this.valorAporte;
    }

    public Double getAnos(){
        return this.anos;
    }

    public Double getTaxaRetorno(){
        return this.taxaRetorno;
    }

    public Double getTaxaCustodia(){
        return this.taxaCustodia;
    }

    public void setTaxaIr(){

        this.diasCorridos = this.anos * 365;

        this.taxaIr = 22.5;

        if( this.diasCorridos <= 180 ){
            this.taxaIr = 22.5;
        }else if( this.diasCorridos <= 360 ){
            this.taxaIr = 20.0;
        }else if( this.diasCorridos <= 720 ){
            this.taxaIr = 17.5;
        }else if( this.diasCorridos <= 20000 ){
            this.taxaIr = 15.0;
        }

    }

    public void setRentabilidades(){

        //seta retorno bruto
        Double baseTaxa = 1 + (this.taxaRetorno / 100);
        Double powTaxa = Math.pow(baseTaxa, this.anos);
        this.retornoBruto = this.valorAporte * powTaxa;

        //calcula e seta taxas e retornos
        this.descontoIr = ((this.retornoBruto - this.valorAporte)/100) * this.taxaIr;
        this.outrosDescontos = ((this.retornoBruto - this.valorAporte)/100) * this.taxaCustodia;

        this.retornoLiquido = this.retornoBruto - this.descontoIr - this.outrosDescontos;

        //seta lucros
        setLucros();
    }

    public void setLucros(){
        this.lucroBruto = this.retornoBruto - this.valorAporte;
        this.lucroLiquido = this.retornoLiquido - this.valorAporte;
    }

    public String getRentabilidade(){
        StringBuilder retorno = new StringBuilder();

        retorno.append("Valor Aporte: R$ " + String.format("%.2f",this.valorAporte)+"\n");
        retorno.append("Retorno Bruto: R$ " + String.format("%.2f",this.retornoBruto)+"\n");
        retorno.append("Desonto IR: R$ " + String.format("%.2f",this.descontoIr)+"\t = " + String.format("%.2f",this.taxaIr)+"%\n");
        retorno.append("Dias Corridos: " + String.valueOf(this.diasCorridos)+"\n" );
        retorno.append("Outros Descontos: R$ " + String.format("%.2f",this.outrosDescontos)+"\n");
        retorno.append("Retorno Liquido: R$ " + String.format("%.2f",this.retornoLiquido)+"\n");
        retorno.append("Lucro Bruto: R$ " + String.format("%.2f",this.lucroBruto)+"\n");
        retorno.append("Lucro Liquido: R$ " + String.format("%.2f",this.lucroLiquido)+"\n");

        return retorno.toString();
    }


}

