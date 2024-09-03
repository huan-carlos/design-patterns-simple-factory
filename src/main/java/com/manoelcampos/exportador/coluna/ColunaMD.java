package com.manoelcampos.exportador.coluna;

import java.util.function.Function;

public class ColunaMD<T> extends AbstractColuna<T> {
    public ColunaMD(Function<T, String> function, String titulo) {
        super(titulo, function);
    }
    @Override
    public String abrir() {
        return "|";
    }

    @Override
    public String fechar() {
        return "";
    }
}
