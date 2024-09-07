package Menu.Autoridade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChamarAutoridade implements Autoridade{

    private List<String> autoridades;
    private Scanner scan;
    public ChamarAutoridade() {
        this.autoridades = new ArrayList<>();
        this.scan = new Scanner(System.in);
    }
    @Override
    public void cadastrarAutoridade() {
    System.out.println("Digite o nome do autoridade: ");
    String Nome = scan.nextLine();
    autoridades.add(Nome);
    System.out.println("Autoridade cadastrada com sucesso!");

    }

    @Override
    public void alterarAutoridade() {
System.out.println("Digite o nome do autoridade: ");
String Nome = scan.nextLine();
if(autoridades.contains(Nome)) {
    System.out.println("Altere o nome do autoridade:!");
    String novoNome = scan.nextLine();
    int index = autoridades.indexOf(novoNome);
    autoridades.set(index, Nome);
    System.out.println("Autoridade alterado com sucesso!");
 }else{
    System.out.print("Não registrado na base de dados:");
 }
    }

    @Override
    public void excluirAutoridade() {
    System.out.println("Digite o nome do autoridade: ");
    String Nome = scan.nextLine();
    if(autoridades.contains(Nome)) {
        autoridades.remove(Nome);
    }else{
        System.out.print("Autoridade Inexistente");
    }
    }

    @Override
    public void listarAutoridade() {

    }


}
