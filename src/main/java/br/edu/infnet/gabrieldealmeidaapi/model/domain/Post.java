package br.edu.infnet.gabrieldealmeidaapi.model.domain;

public class Post {

   private int idPost;
   public String emailAutor;


   public String titulo;
   public String conteudo;
   public String categoria;

   public boolean postar(){

       if (titulo != null && conteudo != null && categoria != null) {
           gerarVerificarId();
           return true;
       }

       return false;
   }

    private void gerarVerificarId(){

        idPost = (int) (Math.ceil(Math.random() * 1000));

    }

    public void post(){
       for (int i = 0; i < 10; i++){
           System.out.println(" ");
       }

        System.out.println(titulo);
        System.out.println(" ");
        System.out.println(conteudo);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Categoria: " + categoria);
        System.out.println(" ");
        System.out.println("id: " + idPost);
        System.out.println("Email do autor: " + emailAutor);
    }
}
