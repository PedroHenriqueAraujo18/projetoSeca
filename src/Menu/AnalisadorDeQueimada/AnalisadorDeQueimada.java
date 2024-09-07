package Menu.AnalisadorDeQueimada;

import java.util.ArrayList;
import java.util.List;

public class AnalisadorDeQueimada implements Queimada {

    private int queimadasAnalisadas;
    private List<String> locaisQueimada;
    private int quantidadeQueimada;

    public AnalisadorDeQueimada() {
        this.queimadasAnalisadas = 0;
        this.locaisQueimada = new ArrayList<>();
        this.quantidadeQueimada = 0;
    }
    @Override
    public int qtdQueimada() {
     return this.quantidadeQueimada;
    }

    @Override
    public String localQueimada() {
       if(this.locaisQueimada.isEmpty()){
           return "Erro, nenhum local digitado!";
       }
       return locaisQueimada.get(locaisQueimada.size()-1);
    }

    @Override
    public int qtdAnalisadas() {
        return this.queimadasAnalisadas;
    }

    @Override
    public void adicionaQueimada(String queimada) {
        locaisQueimada.add(this.localQueimada());
        quantidadeQueimada++;
        queimadasAnalisadas++;
    }
}
