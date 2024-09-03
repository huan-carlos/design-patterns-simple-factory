package com.manoelcampos.exportador;

import com.manoelcampos.exportador.coluna.Coluna;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractExportadorLista<T> implements ExportadorLista<T> {
    private final List<T> lista;
    private final List<Coluna<T>> colunas;

    public AbstractExportadorLista(List<T> lista){
        this.lista = lista;
        colunas = new ArrayList<>();
    }

    @Override
    public final String exportar() {
        final var builder = new StringBuilder();
        builder.append(abrirTabela())
               .append(abrirLinhaTitulos())
               .append(gerarColunasTitulo())
               .append(fecharLinhaTitulos())
               .append(gerarLinhas(lista))
               .append(fecharTabela());
        return builder.toString();
    }

    private String gerarLinhas(List<T> listaProdutos) {
        return lista
                .stream()
                .map(produto -> abrirLinha() + gerarColunas(produto) + fecharLinha())
                .collect(Collectors.joining());
    }

    private String gerarColunas(T p) {
        var builder = new StringBuilder();
        colunas.forEach(coluna -> builder.append(coluna.exportarDado(p)));
        return builder.toString();
    }

    private String gerarColunasTitulo() {
        var builder = new StringBuilder();
        colunas.forEach(coluna -> builder.append(coluna.exportarCabecalho()));
        return builder.toString();
    }

    @Override
    public void addNewColuna(Function<T, String> funcaoValorColuna, String titulo) {
        colunas.add(newColuna(funcaoValorColuna, titulo));
    }

    protected abstract Coluna<T> newColuna(Function<T, String> funcaoValorColuna, String titulo);
}
