import com.manoelcampos.exportador.ExportadorLista;
import com.manoelcampos.exportador.Produto;

import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<Produto> listProdutos = List.of(
                new Produto("1", "SmartTv", "LG"),
                new Produto("2", "TV Best", "Samsung"),
                new Produto("3", "TV Big", "Apple")
        );

        var exportadorHTML = ExportadorLista.newInstance(listProdutos, "html");

        exportadorHTML.addNewColuna(Produto::getId, "Identifier");
        exportadorHTML.addNewColuna(Produto::getNome, "Nome");
        exportadorHTML.addNewColuna(Produto::getMarca, "Marca");
        System.out.println(exportadorHTML.exportar());

        System.out.println("--------------------------------------------------");

        var exportadorMD = ExportadorLista.newInstance(listProdutos, "md");
        exportadorMD.addNewColuna(Produto::getId, "Identifier");
        exportadorMD.addNewColuna(Produto::getNome, "Nome");
        exportadorMD.addNewColuna(Produto::getMarca, "Marca");
        System.out.println(exportadorMD.exportar());

        System.out.println("--------------------------------------------------");

        var exportadorCSV = ExportadorLista.newInstance(listProdutos, "csv");
        exportadorCSV.addNewColuna(Produto::getId, "Identifier");
        exportadorCSV.addNewColuna(Produto::getNome, "Nome");
        exportadorCSV.addNewColuna(Produto::getMarca, "Marca");
        System.out.println(exportadorCSV.exportar());
    }
}
