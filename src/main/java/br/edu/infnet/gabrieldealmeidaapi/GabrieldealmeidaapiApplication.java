package br.edu.infnet.gabrieldealmeidaapi;

import br.edu.infnet.gabrieldealmeidaapi.model.domain.Post;
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


            try {
                opcaoConta = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro!");
            }

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
                        continue;
                    }
                    break;
                } while (!usuario.verificarEntrar());

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

                        if (inputEmail.isBlank()) {
                            System.out.println("");
                            System.out.println("Erro: Campo vazio!");
                        }

                    } while (inputEmail.isBlank());
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

                        if (inputSenha.isBlank()) {
                            System.out.println("");
                            System.out.println("Erro: Campo vazio!");
                        }

                    } while (inputSenha.length() < 8);
                    usuario.senha = inputSenha;

                    if (!usuario.criarConta()) {
                        System.out.println(" ");
                        System.out.println("Erro: Email já cadastrado!");
                        System.out.println("----------------");
                        continue;
                    }

                    break;
                } while (!usuario.criarConta());

                System.out.println("Conta criada!");
                break;
            case 0:
                System.out.println("Sair");
                return;
        }

        System.out.println("Hello World!");

        Post post = new Post();

        boolean confirmacaoPost = false;

        while (!confirmacaoPost) {

            for (int i = 0; i < 10; i++) {
                System.out.println(" ");
            }

            System.out.println("Criar Post:");
            System.out.println("Digite um número inteiro:");
            System.out.println("1 - Criar/Alterar título");
            System.out.println("2 - Criar/Alterar conteúdo");
            System.out.println("3 - Escolher/Alterar categoria");
            System.out.println("4 - Postar");
            System.out.println(" ");
            System.out.println("0 - Sair");
            System.out.println(" ");
            System.out.println("----------------");
            System.out.println(" ");

            int opcaoPost = -1;

            do {
                System.out.print("Digite o número: ");
                try {
                    opcaoPost = Integer.parseInt(in.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Erro!");
                }
            } while (opcaoPost < 0 && opcaoPost > 4);

            switch (opcaoPost) {
                case 1:
                    boolean confirmacaoTitulo = false;

                    while (!confirmacaoTitulo) {
                        if (post.titulo != null){
                            System.out.println("Título atual: " + post.titulo);
                        }
                        System.out.println(" ");
                        System.out.print("Digite o título: ");
                        String titulo = in.nextLine();

                        System.out.println("Digite um número inteiro: ");
                        System.out.println("11 - Confirmar título");
                        System.out.println("12 - Alterar título");
                        System.out.println(" ");
                        System.out.println("10 - Voltar");
                        System.out.println(" ");
                        System.out.println("----------------");
                        System.out.println(" ");

                        int opcaoTitulo = -1;
                        System.out.print("Digite o número: ");
                        try {
                            opcaoTitulo = Integer.parseInt(in.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Erro!");
                        }
                        switch (opcaoTitulo) {
                            case 11:

                                if (!titulo.isBlank()) {
                                    post.titulo = titulo;
                                    confirmacaoTitulo = true;
                                    continue;
                                }
                                System.out.println("Erro: Título vazio!");
                                break;
                            case 12:
                                if (post.titulo == null){
                                    System.out.println("Título atual: " + titulo);
                                } else {
                                    System.out.println("Título atual: " + post.titulo);
                                }


                                break;
                            case 10:
                                confirmacaoTitulo = true;
                                continue;
                        }

                    }

                    break;
                case 2:

                    boolean confirmacaoConteudo = false;

                    while (!confirmacaoConteudo) {
                        if (post.conteudo != null){
                            System.out.println("Conteúdo atual: " + post.conteudo);
                        }
                        System.out.println(" ");
                        System.out.print("Digite o conteúdo: ");
                        String conteudo = in.nextLine();

                        System.out.println("Digite um número inteiro: ");
                        System.out.println("21 - Confirmar conteúdo");
                        System.out.println("22 - Alterar conteúdo");
                        System.out.println(" ");
                        System.out.println("20 - Voltar");
                        System.out.println(" ");
                        System.out.println("----------------");
                        System.out.println(" ");

                        int opcaoConteudo = -1;
                        System.out.print("Digite o número: ");
                        try {
                            opcaoConteudo = Integer.parseInt(in.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Erro!");
                        }
                        switch (opcaoConteudo) {
                            case 21:

                                if (!conteudo.isBlank()) {
                                    post.conteudo = conteudo;
                                    confirmacaoConteudo = true;
                                    continue;
                                }
                                System.out.println("Erro: Conteúdo vazio!");
                                break;
                            case 22:
                                if (post.conteudo == null){
                                    System.out.println("Conteúdo atual: " + conteudo);
                                } else {
                                    System.out.println("Conteúdo atual: " + post.conteudo);
                                }


                                break;
                            case 20:
                                confirmacaoConteudo = true;
                                continue;
                        }

                    }

                    break;
                case 3:

                    boolean confirmacaoCategoria = false;

                    while (!confirmacaoCategoria) {

                        if (post.categoria != null){
                            System.out.println("Categoria atual: " + post.categoria);
                        }
                        System.out.println(" ");
                        System.out.print("Digite o categoria: ");
                        String categoria = in.nextLine();

                        System.out.println("Digite um número inteiro: ");
                        System.out.println("31 - Confirmar categoria");
                        System.out.println("32 - Alterar categoria");
                        System.out.println(" ");
                        System.out.println("30 - Voltar");
                        System.out.println(" ");
                        System.out.println("----------------");
                        System.out.println(" ");

                        int opcaoCategoria = -1;
                        System.out.print("Digite o número: ");

                        try {
                            opcaoCategoria = Integer.parseInt(in.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Erro!");
                        }

                        switch (opcaoCategoria) {
                            case 31:

                                if (!categoria.isBlank()) {
                                    post.categoria = categoria;
                                    confirmacaoCategoria = true;
                                    continue;
                                }
                                System.out.println("Erro: Categoria vazio!");
                                break;
                            case 32:
                                if (post.categoria == null){
                                    System.out.println("Categoria atual: " + categoria);
                                } else {
                                    System.out.println("Categoria atual: " + post.categoria);
                                }

                                break;
                            case 30:
                                confirmacaoCategoria = true;
                                continue;
                        }

                    }

                    break;
                case 4:

                    if (post.postar()) {
                        post.emailAutor = usuario.email;
                        post.post();
                        confirmacaoPost = true;
                    }

                    break;
                case 0:
                    System.out.println("Sair");
                    confirmacaoPost = true;
                    break;
            }
        }
    }
}
