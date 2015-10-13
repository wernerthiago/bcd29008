/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrodeusuarios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alvinegro
 */
public class Usuario {

    private String nome;
    private String id;
    private List telefone = new ArrayList();
    private int i = 1;
    private Endereco endereco = new Endereco();

    public Usuario() {
        this.nome = "";
        this.id = "";
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getId() {
        return id;
    }

    public List getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(int i, String endereco) {
        if (i == 1) {
            this.endereco.setLogradouro(endereco);
        }
        if (i == 2) {
            this.endereco.setNumero(endereco);
        }
        if (i == 3) {
            this.endereco.setBairro(endereco);
        }
        if (i == 4) {
            this.endereco.setCidade(endereco);
        }
        if (i == 5) {
            this.endereco.setEstado(endereco);
        }
        if (i == 6) {
            this.endereco.setPais(endereco);
        }
    }

    public void setTelefone(String telefone) {
        this.telefone.add(telefone);
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void escreverNoArquivo() throws IOException{
        FileWriter file = new FileWriter("C:\\Users\\alvinegro\\Google Drive\\FACULDADE\\8fase\\BCD29008\\projetos\\CadastroDeUsuarios\\JSON.txt", true);
        PrintWriter recfile = new PrintWriter(file);
        String cell = "";
        String json = "{\"nome\":\"" + this.nome + "\":\"logradouro\":\""+ this.endereco.getLogradouro() +"\":\"numero\":\""+ this.endereco.getNumero() +"\":\"bairro\":\""+ this.endereco.getBairro() +"\":\"cidade\":\""+ this.endereco.getCidade() +"\":\"estado\":\""+ this.endereco.getEstado() +"\":\"pais\":\""+ this.endereco.getPais() +"\":\"cpfoupassaporte\":\""+ this.id +"\":";
        int n = telefone.size();
        int aux = 0;
        while(aux != n){
            cell = cell + "\"telefone" + aux + "\":\"" + telefone.get(aux) + "\":";
            aux++;
        }
        cell = cell.substring(0, cell.length() - 1);
        cell = cell + "}";
        json = json + cell;
        System.out.println(json);
        recfile.print(json);
        file.close();
    }

}
