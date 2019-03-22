package silcalculator.mohammed.mcsc.cuidadora.Curriculum;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import silcalculator.mohammed.mcsc.cuidadora.config.ConfiguracaoFirebase;


public class UsuarioC {
    private String idUsuario;
    private String imgurl;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String celular;
    private String cep;
    private String aniversario;
    private String sexo;
    private String endereco;
    private String bairro;
    private String altura;
    private String cidade;
    private String estado;
    private String peso;
    private String filhos;
    private String idadefilhos;
    private String nacionalidade;
    private String naturalidade;
    private String rg;
    private String estado_civil;
    private String cpf;
    private String escolaridade;
    private String carteiraprof;
    private
    String serie;
    private String carteirahab;
    private String categoriaC;
    private FirebaseAuth auth;


    public UsuarioC(String nome ,String email, String telefone, String aniversario, String sexo, String cidade,
                   String celular, String cep, String altura, String peso, String endereco, String bairro,
                   String filhos, String idadefilhos, String nacionalidade, String naturalidade, String estado_civil, String rg, String cpf, String escolaridade,
                   String carteiraprof, String serie, String carteirahab, String categoriaC, String estado, String imgurl) {


        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.aniversario = aniversario;
        this.sexo = sexo;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
        this.bairro = bairro;
        this.celular = celular;
        this.cep = cep;
        this.altura = altura;
        this.peso = peso;
        this.filhos = filhos;
        this.idadefilhos = idadefilhos;
        this.nacionalidade = nacionalidade;
        this.naturalidade = naturalidade;
        this.estado_civil = estado_civil;
        this.rg = rg;
        this.cpf = cpf;
        this.escolaridade = escolaridade;
        this.carteiraprof = carteiraprof;
        this.serie = serie;
        this.carteirahab = carteirahab;
        this.categoriaC = categoriaC;
        this.imgurl = imgurl;
    }


    public UsuarioC() {
    }

    public void salvar() {
        auth = FirebaseAuth.getInstance();
        DatabaseReference firebase = ConfiguracaoFirebase.getFirebaseDatabase();
        firebase.child("usuarios").child(auth.getCurrentUser().getUid()).setValue(this);
    }

    @Exclude
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }


    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getFilhos() {
        return filhos;
    }

    public void setFilhos(String filhos) {
        this.filhos = filhos;
    }

    public String getIdadefilhos() {
        return idadefilhos;
    }

    public void setIdadefilhos(String idadefilhos) {
        this.idadefilhos = idadefilhos;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getCarteiraprof() {
        return carteiraprof;
    }

    public void setCarteiraprof(String carteiraprof) {
        this.carteiraprof = carteiraprof;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getCarteirahab() {
        return carteirahab;
    }

    public void setCarteirahab(String carteirahab) {
        this.carteirahab = carteirahab;
    }

    public String getCategoriaC() {
        return categoriaC;
    }

    public void setCategoriaC(String categoriaC) {
        this.categoriaC = categoriaC;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }



}
