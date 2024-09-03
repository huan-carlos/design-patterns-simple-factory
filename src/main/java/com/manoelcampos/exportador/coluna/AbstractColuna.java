package com.manoelcampos.exportador.coluna;

import java.util.function.Function;

public abstract class AbstractColuna<T> implements Coluna<T> {
    private String titulo;
    private Function<T, String> function;

    public AbstractColuna(String titulo, Function<T, String> function) {
        this.titulo = titulo;
        this.function = function;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String exportarCabecalho() {
        return abrir() + titulo + fechar();
    }

    @Override
    public String exportarDado(T objeto) {
        return abrir() + function.apply(objeto) + fechar();
    }
}
