/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrodeusuarios;

import java.io.IOException;
import java.util.Scanner;
import java.lang.String;

/**
 *
 * @author alvinegro
 */
public class CadastroDeUsuarios {
    private int numeroDeUsuarios = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        CadastroDeUsuarios cadastro = new CadastroDeUsuarios();
        cadastro.menuPrincipal();
    }

    private void menuPrincipal() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Usuario[] user = new Usuario[100];
        System.out.println("##################################");
        System.out.println("Bem vindo ao Cadastro de Usuário!");
        System.out.println("##################################");
        while (true) {
            System.out.println("Tecle 1 para cadastrar um usuário no banco de dados.");
            System.out.println("Tecle 2 para sair.");
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    user[numeroDeUsuarios] = new Usuario();
                    rotinaCadastro(user[numeroDeUsuarios]);
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    private void rotinaCadastro(Usuario user) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //Fazer tratamento de erros;
        System.out.println("Nome:");
        String nome = scanner.nextLine();
        user.setNome(nome);
        System.out.println("CPF/Passaporte (somente números):");
        String id = scanner.nextLine();
        user.setId(id);
        System.out.println("Endereço completo");
        System.out.println("Logradouro:");
        String endereco = scanner.nextLine();
        user.setEndereco(1, endereco);
        System.out.println("Numero");
        endereco = scanner.nextLine();
        user.setEndereco(2, endereco);
        System.out.println("Bairro");
        endereco = scanner.nextLine();
        user.setEndereco(3, endereco);
        System.out.println("Cidade");
        endereco = scanner.nextLine();
        user.setEndereco(4, endereco);
        System.out.println("Estado");
        endereco = scanner.nextLine();
        user.setEndereco(5, endereco);
        System.out.println("País");
        endereco = scanner.nextLine();
        user.setEndereco(6, endereco);
        System.out.println("Quantos telefones deseja adicionar (até 4)?");
        int j = scanner.nextInt();
        String telefone;
        int t = 1;
        while (t <= j) {
            System.out.println("Digite o " + t + " telefone:");
            telefone = scanner.next();
            user.setTelefone(telefone);
            t++;
        }
        this.numeroDeUsuarios++;
        user.escreverNoArquivo();
    }
}
