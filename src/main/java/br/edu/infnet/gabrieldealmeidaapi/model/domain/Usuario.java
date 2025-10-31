package br.edu.infnet.gabrieldealmeidaapi.model.domain;

public class Usuario {

    private final String emailCadastrado = "teste@gmail.com";
    private final String senhaCadastrado = "12345678";
    private final int idCadastrado = 15678;

    public String email;
    public String senha;
    private int id;

    public boolean verificarEntrar(){

        if (emailCadastrado.equals(email) && senhaCadastrado.equals(senha)) {
            mensagemEntrar();

            return true;
        }

        return false;
    }

    public boolean criarConta(){
        if (!emailCadastrado.equals(email)) {
            id = gerarVerificarId();
            mensagemEntrar();
            return true;
        }
    return false;
    }

    private int gerarVerificarId(){

        int idGerado = (int) (Math.ceil(Math.random() * 1000));

        if (idGerado == idCadastrado) {
            gerarVerificarId();
        }

        return idGerado;
    }

    private void mensagemEntrar(){
        System.out.println("Entrou!");
    }
}
