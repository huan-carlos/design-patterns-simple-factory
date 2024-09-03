package com.manoelcampos.exportador;

import java.util.List;
import java.util.function.Function;

public interface ExportadorLista<T> {
    String abrirTabela();
    String fecharTabela();
    String abrirLinha();
    String fecharLinha();
    String abrirLinhaTitulos();
    String fecharLinhaTitulos();
    String exportar();

    void addNewColuna(Function<T, String> funcaoValorColuna, String titulo);

    static <T> ExportadorLista<T> newInstance(List<T> lista){
        return newInstance(lista, "html");
    }

    static <T> ExportadorLista<T> newInstance(List<T> lista, String extensaoArquivoExportacao){
        return switch (extensaoArquivoExportacao.toLowerCase()) {
            case "html" -> new ExportadorListaHtml<>(lista);
            case "md" -> new ExportadorListaMD<>(lista);
            case "csv" -> new ExportadorListaCSV<>(lista);
            default -> throw new UnsupportedOperationException(
                    "Formato não suportado: " + extensaoArquivoExportacao);
        };
    }
}
