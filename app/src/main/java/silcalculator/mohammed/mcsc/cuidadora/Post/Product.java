package silcalculator.mohammed.mcsc.cuidadora.Post;

import java.util.List;

import silcalculator.mohammed.mcsc.cuidadora.Comment.Comment;
import silcalculator.mohammed.mcsc.cuidadora.Patroa.modol.Usuario;

public class Product {
    private String id;
    private String imgurl;
    private String nome_da_receita;
    private String categoria;
    private Usuario usuario;
    private List<Comment> commentList;

    public Product( String imgurl, String nome_da_receita, Usuario usuario ) {
        this.nome_da_receita = nome_da_receita;
        this.usuario = usuario;

        this.imgurl = imgurl; }


    public Product() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getImgurl() { return imgurl; }
    public void setImgurl(String imgurl) { this.imgurl = imgurl; }




    public String getNome_da_Receita() { return nome_da_receita; }
    public void setNome_da_Receita(String name) { this.nome_da_receita = name; }




    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List <Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List <Comment> commentList) {
        this.commentList = commentList;
    }
}
