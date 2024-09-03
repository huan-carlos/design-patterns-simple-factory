package com.manoelcampos.exportador;

import com.manoelcampos.exportador.coluna.Coluna;
import com.manoelcampos.exportador.coluna.ColunaCSV;

import java.util.List;
import java.util.function.Function;

public class ExportadorListaCSV<T> extends AbstractExportadorLista<T> {
    public ExportadorListaCSV(List<T> lista) {
        super(lista);
    }

    @Override
    protected Coluna<T> newColuna(Function<T, String> funcaoValorColuna, String titulo) {
        return new ColunaCSV<T>(funcaoValorColuna, titulo);
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
        return "";
    }

    @Override
    public String fecharLinha() {
        return "\n";
    }

    @Override
    public String abrirLinhaTitulos() {
        return "";
    }

    @Override
    public String fecharLinhaTitulos() {
        return "\n";
    }
}
