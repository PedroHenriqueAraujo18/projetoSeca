package Menu.Usuario;

import java.util.HashMap;
import java.util.Map;

public class Cliente implements Usuario{

    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Map<String,Cliente> Clientes = new HashMap<>();

    public Cliente(String nome, String cpf, String telefone, String email) {
        if(nome == null || nome.isEmpty()){
            System.out.print("Erro nome vázio.");
        }
        if(cpf == null || cpf.isEmpty()){
            System.out.print("Erro CPF vazio");
        }
        if(telefone == null || telefone.isEmpty()){
            System.out.print("Erro telefone vazio");
        }
        if(email == null || email.isEmpty()){
            System.out.print("Erro email vazio");
        }
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;

    }
    @Override
    public void cadastrarUsuario() {
if(Clientes.containsKey(this.cpf)){
    Clientes.put(this.cpf, this);
    System.out.println("Cliente cadastrado com sucesso!");
}else{
    System.out.print("Erro na cadastro de cliente.\n");
}
    }

    @Override
    public void listarUsuario() {
if(Clientes.isEmpty()){
    System.out.print("Erro ,Sem Clientes.\n");
}else{
    System.out.println("Lista de Clientes:\n!");
    for(Cliente c : Clientes.values()){
        System.out.print("Nome:" + c.nome +","+ c.cpf +","+ c.telefone+ ","+  c.email + "\n");
            }
        }
    }

    @Override
    public void alterarUsuario() {
    if(!Clientes.isEmpty()){
        System.out.print("Sem Clientes:\n");
    }else {
        Cliente c = Clientes.get(this.cpf);
        c.nome = this.nome;
        c.cpf = this.cpf;
        c.telefone = this.telefone;
        c.email = this.email;
        }
    }

    @Override
    public void excluirUsuario() {
    if(!Clientes.isEmpty()){
        System.out.print("Sem Clientes:\n");
    }else{
        Clientes.remove(this.cpf);
        System.out.println("Cliente removido com sucesso!");
    }
    }
}
