package com.manoelcampos.exportador.coluna;

import java.util.function.Function;

public class ColunaHtml<T> extends AbstractColuna<T> {
    public ColunaHtml(Function<T, String> function, String titulo) {
        super(titulo, function);
    }
    @Override
    public String abrir() {
        return "        <td>";
    }

    @Override
    public String fechar() {
        return "</td>\n";
    }
}
