package com.manoelcampos.exportador.coluna;

public interface Coluna<T> {
    String getTitulo();
    void setTitulo(String titulo);
    String abrir();
    String fechar();
    String exportarCabecalho();
    String exportarDado(T objeto);
}
