package br.edu.infnet.gabrieldealmeidaapi.model.domain;

public class Usuario {

    private final String emailCadastrado = "teste@gmail.com";
    private final String senhaCadastrado = "12345678";

    public String email;
    public String senha;

    public boolean verificarEntrar(){

        if (emailCadastrado.equals(email) && senhaCadastrado.equals(senha)) {
            return true;
        }

        return false;
    }

    public boolean criarConta(){
        if (!emailCadastrado.equals(email)) {
            return true;
        }
    return false;
    }

}
