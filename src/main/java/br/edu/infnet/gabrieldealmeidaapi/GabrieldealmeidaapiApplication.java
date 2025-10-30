package br.edu.infnet.gabrieldealmeidaapi;

import br.edu.infnet.gabrieldealmeidaapi.model.domain.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GabrieldealmeidaapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GabrieldealmeidaapiApplication.class, args);

        Scanner in = new Scanner(System.in);
        Usuario usuario = new Usuario();

        //System.out.println("Digite seu email");
        //String inputEmail = in.nextLine();

        //usuario.email = inputEmail;
        //usuario.mensagem();

        int opcaoConta = -1;
        System.out.println(" ");
        System.out.println("Digite um número inteiro:");
        System.out.println("1 - Entrar");
        System.out.println("2 - Criar conta");
        System.out.println(" ");
        System.out.println("0 - Sair");
        System.out.println(" ");
        System.out.println("----------------");
        System.out.println(" ");
        do {
            System.out.print("Digite o número: ");
            opcaoConta = Integer.parseInt(in.nextLine());



        } while (opcaoConta != 1 && opcaoConta != 2 && opcaoConta != 0);

        switch (opcaoConta) {
            case 1:

                do {
                    System.out.println("Entrar");
                    System.out.println("----------------");

                    System.out.print("Digite seu email: ");
                    String inputEmail = in.nextLine();
                    usuario.email = inputEmail;
                    System.out.println("");
                    System.out.print("Digite sua senha: ");
                    String inputSenha = in.nextLine();
                    usuario.senha = inputSenha;

                    if (!usuario.verificarEntrar()) {
                        System.out.println(" ");
                        System.out.println("Erro: Dados incorretos!");
                        System.out.println("----------------");
                    }

                } while (!usuario.verificarEntrar());

                System.out.println("Entrou!");
                break;
            case 2:

                do {
                    System.out.println("Criar conta");
                    System.out.println("----------------");

                    String inputEmail;

                    do {
                        System.out.println("");
                        System.out.print("Digite seu email: ");
                        inputEmail = in.nextLine();

                        if (inputEmail.isEmpty()) {
                            System.out.println("");
                            System.out.println("Erro: Campo vazio!");
                        }

                    } while (inputEmail.isEmpty());
                    usuario.email = inputEmail;

                    String inputSenha;
                    do {
                        System.out.println("");
                        System.out.print("Digite sua senha: ");
                        inputSenha = in.nextLine();


                        if (inputSenha.length() < 8) {
                            System.out.println("");
                            System.out.println("Erro: A senha deve ter mais de 7 digitos!");
                        }

                        if (inputSenha.isEmpty()) {
                            System.out.println("");
                            System.out.println("Erro: Campo vazio!");
                        }

                    } while (inputSenha.length() < 8);
                    usuario.senha = inputSenha;

                    if (!usuario.criarConta()) {
                        System.out.println(" ");
                        System.out.println("Erro: Email já cadastrado!");
                        System.out.println("----------------");
                    }

                } while (!usuario.criarConta());

                System.out.println("Conta criada!");
                break;
            case 0:
                System.out.println("Sair");
                return;
        }

        System.out.println("Hello World!");
	}

}
