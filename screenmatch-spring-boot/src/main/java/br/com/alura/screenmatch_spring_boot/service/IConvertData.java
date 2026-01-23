package br.com.alura.screenmatch_spring_boot.service;

public interface IConvertData {
    <T> T obterDados(String json, Class<T> classe);
}
