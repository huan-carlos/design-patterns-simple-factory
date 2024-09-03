package com.manoelcampos.exportador;

import com.manoelcampos.exportador.coluna.Coluna;
import com.manoelcampos.exportador.coluna.ColunaMD;

import java.util.List;
import java.util.function.Function;

public class ExportadorListaMD<T> extends AbstractExportadorLista<T> {
    private int numCol;

    public ExportadorListaMD(List<T> lista) {
        super(lista);
        numCol = lista.size();
    }

    @Override
    public String abrirTabela() {
        return "";
    }

    @Override
    public String fecharTabela() {
        return "";
    }

    @Override
    public String abrirLinha() {
        return "\n";
    }

    @Override
    public String fecharLinha() {
        return "";
    }

    @Override
    public String abrirLinhaTitulos() {
        return "";
    }

    @Override
    public String fecharLinhaTitulos() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (int i = 0; i < numCol; i++) {
            builder.append("|-");
        }
        return builder.toString();
    }

    @Override
    protected Coluna<T> newColuna(Function<T, String> funcaoValorColuna, String titulo) {
        return new ColunaMD<>(funcaoValorColuna, titulo);
    }
}
