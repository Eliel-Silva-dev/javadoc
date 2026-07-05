package com.hydrahtec.exceptiondoc.exceptions;

public class DivisaoNaoExataException extends Exception{

    int num;
    int dem;

    public DivisaoNaoExataException (int num, int dem) {
        super();
        this.num = num;
        this.dem = dem;
    }

    @Override
    public String toString() {
        return "O resultado de " + num + "/" + dem + " não é exato.";
    }
}
