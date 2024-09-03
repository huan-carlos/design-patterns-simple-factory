package com.manoelcampos.exportador.coluna;

import java.util.function.Function;

public class ColunaCSV<T> extends AbstractColuna<T>{
    public ColunaCSV(Function<T, String> function, String titulo) {
        super(titulo, function);
    }

    @Override
    public String abrir() {
        return "";
    }

    @Override
    public String fechar() {
        return ",";
    }
}
