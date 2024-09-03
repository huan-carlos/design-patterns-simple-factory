package com.manoelcampos.exportador;

import com.manoelcampos.exportador.coluna.Coluna;
import com.manoelcampos.exportador.coluna.ColunaHtml;

import java.util.List;
import java.util.function.Function;

public class ExportadorListaHtml<T> extends AbstractExportadorLista<T> {
    public ExportadorListaHtml(List<T> lista) {
        super(lista);
    }

    @Override
    public String abrirTabela() {
        return "<table>\n";
    }

    @Override
    public String fecharTabela() {
        return "</table>";
    }

    @Override
    public String abrirLinha() {
        return "    <tr>\n";
    }

    @Override
    public String fecharLinha() {
        return "    </tr>\n";
    }

    @Override
    public String abrirLinhaTitulos() {
        return "    <thead>\n";
    }

    @Override
    public String fecharLinhaTitulos() {
        return "    </thead>\n";
    }


    @Override
    protected Coluna<T> newColuna(Function<T, String> funcaoValorColuna, String titulo) {
        return new ColunaHtml<T>(funcaoValorColuna, titulo);
    }
}
