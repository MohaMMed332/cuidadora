package silcalculator.mohammed.mcsc.cuidadora.Curriculum;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.Map;

import silcalculator.mohammed.mcsc.cuidadora.Patroa.modol.UserStorage;
import silcalculator.mohammed.mcsc.cuidadora.Patroa.modol.Usuario;
import silcalculator.mohammed.mcsc.cuidadora.R;
import silcalculator.mohammed.mcsc.cuidadora.config.ConfiguracaoFirebase;
import silcalculator.mohammed.mcsc.cuidadora.helper.Base64Custom;

public class CurreiculumEdit extends AppCompatActivity {
    ImageView foodImageView;
    String emailId;
    private ProgressDialog progressDialog;


    EditText Telefone, Estado, Cidade, Data,
            Sexo, Celular, Cep, Altura, Peso, Filhos, Idadefilhos,
            Ncionalidade, Naturalidade, Rg, Cpf, Escolaridade,
            Carteiraprof, Serie, Carteirahab, CategoriaC,
            Estado_civil, Bairro, Endereco;


    TextView emailProfile, nameText;
    private FirebaseAuth autenticacao;
    private DatabaseReference mDatabase;
    String idValue, nome, email, telefone, aniversario, sexo, cidade,
            celular, cep, altura, peso, endereco, bairro,
            filhos, idadefilhos, nacionalidade, naturalidade, estado_civil, rg, cpf, escolaridade,
            carteiraprof, serie, carteirahab, categoriaC, estado, imgurl;


    private static String Simgurl;
    private Uri imgUri;
    private StorageReference mStorage;
    UploadTask.TaskSnapshot taskSnapshot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.curreiculum_edit);


        foodImageView = (ImageView) findViewById(R.id.imge_prof);
        nameText = (TextView) findViewById(R.id.nameText);
        Telefone = (EditText) findViewById(R.id.numberphone);
        Celular = (EditText) findViewById(R.id.celular);
        emailProfile = (TextView) findViewById(R.id.emailProfile);
        Sexo = (EditText) findViewById(R.id.SexoP);
        Data = (EditText) findViewById(R.id.DataP);
        Cidade = (EditText) findViewById(R.id.CidadeP);
        Estado = (EditText) findViewById(R.id.EstadoP);
        Cep = (EditText) findViewById(R.id.cep);
        Altura = (EditText) findViewById(R.id.altura);
        Peso = (EditText) findViewById(R.id.peso);
        Filhos = (EditText) findViewById(R.id.filhos);
        Idadefilhos = (EditText) findViewById(R.id.idadefilhos);
        Ncionalidade = (EditText) findViewById(R.id.nacionalidade);
        Naturalidade = (EditText) findViewById(R.id.naturalidade);
        Rg = (EditText) findViewById(R.id.rg);
        Cpf = (EditText) findViewById(R.id.cpf);
        Escolaridade = (EditText) findViewById(R.id.escolaridade);
        Carteiraprof = (EditText) findViewById(R.id.carteiraprof);
        Serie = (EditText) findViewById(R.id.serie);
        Carteirahab = (EditText) findViewById(R.id.carteirahab);
        CategoriaC = (EditText) findViewById(R.id.categoriaC);
        Endereco = (EditText) findViewById(R.id.endereco);
        Bairro = (EditText) findViewById(R.id.bairro);
        Estado_civil = (EditText) findViewById(R.id.estado_civil);

        Telefone.setText(telefone);
        Estado.setText(estado);
        Cidade.setText(cidade);
        Data.setText(aniversario);
        Sexo.setText(sexo);
        Celular.setText(celular);
        Cep.setText(cep);
        Altura.setText(altura);
        Peso.setText(peso);
        Filhos.setText(filhos);
        Idadefilhos.setText(idadefilhos);
        Ncionalidade.setText(nacionalidade);
        Naturalidade.setText(naturalidade);
        Rg.setText(rg);
        Cpf.setText(cpf);
        Escolaridade.setText(escolaridade);
        Carteiraprof.setText(carteiraprof);
        Serie.setText(serie);
        Carteirahab.setText(carteirahab);
        CategoriaC.setText(categoriaC);
        Estado_civil.setText(estado_civil);
        Bairro.setText(bairro);
        Endereco.setText(endereco);


        Map<String, String> userInfos = UserStorage.getUserInfo(getBaseContext());
        getUserInfo(userInfos.get("USER_EMAIL"));
        mStorage = FirebaseStorage.getInstance().getReference();
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();

    }

    public void showClick(View view) {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, 200);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 200 && data != null) {
            Uri imagerUri = data.getData();
            foodImageView.setImageURI(imagerUri);
            imgUri = imagerUri;
            Toast.makeText(getApplicationContext(), imagerUri.toString(), Toast.LENGTH_LONG).show();
        }
    }


    public void setUserInfo() {
        Map<String, String> userInfos = UserStorage.getUserInfo(getBaseContext());
        if (userInfos.get("USER_NAME") != null) {
            nameText.setText(userInfos.get("USER_NAME"));
        }
        if (userInfos.get("USER_EMAIL") != null) {
            emailId = userInfos.get("USER_EMAIL");
            emailProfile.setText(userInfos.get("USER_EMAIL"));
        }
        if (userInfos.get("USER_PHONE") != null) {
            Telefone.setText(userInfos.get("USER_PHONE"));
        }
        if (userInfos.get("USER_SEXO") != null) {
            Sexo.setText(userInfos.get("USER_SEXO"));
        }
        if (userInfos.get("USER_ANIVERSARIO") != null) {
            Data.setText(userInfos.get("USER_ANIVERSARIO"));
        }
        if (userInfos.get("USER_CIDADE") != null) {
            Cidade.setText(userInfos.get("USER_CIDADE"));
        }
        if (userInfos.get("USER_ESTADO") != null) {
            Estado.setText(userInfos.get("USER_ESTADO"));
        }
        if (userInfos.get("USER_CELULAR") != null) {
            Celular.setText(userInfos.get("USER_CELULAR"));
        }
        if (userInfos.get("USER_CEP") != null) {
            Cep.setText(userInfos.get("USER_CEP"));
        }
        if (userInfos.get("USER_ALTURA") != null) {
            Altura.setText(userInfos.get("USER_ALTURA"));
        }
        if (userInfos.get("USER_PESO") != null) {
            Peso.setText(userInfos.get("USER_PESO"));
        }
        if (userInfos.get("USER_FILHOS") != null) {
            Filhos.setText(userInfos.get("USER_FILHOS"));
        }
        if (userInfos.get("USER_IDADEFILHOS") != null) {
            Idadefilhos.setText(userInfos.get("USER_IDADEFILHOS"));
        }
        if (userInfos.get("USER_NACIONALIDADE") != null) {
            Ncionalidade.setText(userInfos.get("USER_NACIONALIDADE"));
        }
        if (userInfos.get("USER_NATURALIDADE") != null) {
            Naturalidade.setText(userInfos.get("USER_NATURALIDADE"));
        }
        if (userInfos.get("USER_RG") != null) {
            Rg.setText(userInfos.get("USER_RG"));
        }
        if (userInfos.get("USER_CPF") != null) {
            Cpf.setText(userInfos.get("USER_CPF"));
        }
        if (userInfos.get("USER_ESCOLARIDADE") != null) {
            Escolaridade.setText(userInfos.get("USER_ESCOLARIDADE"));
        }
        if (userInfos.get("USER_CATRITAPROF") != null) {
            Carteiraprof.setText(userInfos.get("USER_CATRITAPROF"));
        }
        if (userInfos.get("USER_SERIE") != null) {
            Serie.setText(userInfos.get("USER_SERIE"));
        }
        if (userInfos.get("USER_CARTRITAHAB") != null) {
            Carteirahab.setText(userInfos.get("USER_CARTRITAHAB"));
        }
        if (userInfos.get("USER_CARTRITAC") != null) {
            CategoriaC.setText(userInfos.get("USER_CARTRITAC"));
        }
        if (userInfos.get("USER_ESTADO_CIVIL") != null) {
            Estado_civil.setText(userInfos.get("USER_ESTADO_CIVIL"));
        }
        if (userInfos.get("USER_BAIRRO") != null) {
            Bairro.setText(userInfos.get("USER_BAIRRO"));
        }
        if (userInfos.get("USER_ENDRECO") != null) {
            Endereco.setText(userInfos.get("USER_ENDRECO"));
        }


        if (userInfos.get("IMG_URL") != null) {
            Picasso.with(this)
                    .load(userInfos.get("IMG_URL"))
                    .placeholder(ContextCompat.getDrawable(this, R.drawable.quatro))
                    .into(foodImageView);
        }
    }

    public void getUserInfo(String email) {


        FirebaseDatabase.getInstance().getReference()
                .child("usuarios").orderByChild("email").equalTo(email)
                .addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Usuario user = dataSnapshot.getValue(Usuario.class);
                        Iterable<DataSnapshot> iterable = dataSnapshot.getChildren();
                        for (DataSnapshot child : iterable) {
                            user.setNome(child.child("nome").getValue().toString());
                            user.setEmail(child.child("email").getValue().toString());
                            user.setTelefone(child.child("telefone").getValue().toString());


                            if (child.child("imgurl").exists()) {
                                user.setImgurl(child.child("imgurl").getValue().toString());
                            }
                            if (child.child("telefone").exists()) {
                                user.setTelefone(child.child("telefone").getValue().toString());
                            }
                            if (child.child("aniversario").exists()) {
                                user.setAniversario(child.child("aniversario").getValue().toString());
                            }
                            if (child.child("sexo").exists()) {
                                user.setSexo(child.child("sexo").getValue().toString());
                            }
                            if (child.child("cidade").exists()) {
                                user.setCidade(child.child("cidade").getValue().toString());
                            }
                            if (child.child("estado").exists()) {
                                user.setEstado(child.child("estado").getValue().toString());
                            }
                            if (child.child("celular").exists()) {
                                user.setCelular(child.child("celular").getValue().toString());
                            }
                            if (child.child("cep").exists()) {
                                user.setCep(child.child("cep").getValue().toString());
                            }
                            if (child.child("altura").exists()) {
                                user.setAltura(child.child("altura").getValue().toString());
                            }
                            if (child.child("peso").exists()) {
                                user.setPeso(child.child("peso").getValue().toString());
                            }
                            if (child.child("filhos").exists()) {
                                user.setFilhos(child.child("filhos").getValue().toString());
                            }
                            if (child.child("idadefilhos").exists()) {
                                user.setIdadefilhos(child.child("idadefilhos").getValue().toString());
                            }
                            if (child.child("nacionalidade").exists()) {
                                user.setNacionalidade(child.child("nacionalidade").getValue().toString());
                            }
                            if (child.child("naturalidade").exists()) {
                                user.setNaturalidade(child.child("naturalidade").getValue().toString());
                            }
                            if (child.child("estado_civil").exists()) {
                                user.setEstado_civil(child.child("estado_civil").getValue().toString());
                            }
                            if (child.child("rg").exists()) {
                                user.setRg(child.child("rg").getValue().toString());
                            }
                            if (child.child("cpf").exists()) {
                                user.setCpf(child.child("cpf").getValue().toString());
                            }
                            if (child.child("escolaridade").exists()) {
                                user.setEscolaridade(child.child("escolaridade").getValue().toString());
                            }
                            if (child.child("carteiraprof").exists()) {
                                user.setCarteiraprof(child.child("carteiraprof").getValue().toString());
                            }
                            if (child.child("serie").exists()) {
                                user.setSerie(child.child("serie").getValue().toString());
                            }
                            if (child.child("carteirahab").exists()) {
                                user.setCarteirahab(child.child("carteirahab").getValue().toString());
                            }
                            if (child.child("categoriaC").exists()) {
                                user.setCategoriaC(child.child("categoriaC").getValue().toString());
                            }
                            if (child.child("endereco").exists()) {
                                user.setEndereco(child.child("endereco").getValue().toString());
                            }
                            if (child.child("bairro").exists()) {
                                user.setBairro(child.child("bairro").getValue().toString());
                            }


                        }
                        UserStorage.saveUserInfo(getApplicationContext(), user);
                        setUserInfo();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w("->", "loadPost:onCancelled", databaseError.toException());
                    }
                });

    }


    public void updateProfile(View view) {
        nome = nameText.getText().toString();
        email = emailProfile.getText().toString();
        telefone = Telefone.getText().toString();
        aniversario = Data.getText().toString();
        sexo = Sexo.getText().toString();
        cidade = Cidade.getText().toString();
        estado = Estado.getText().toString();
        imgurl = foodImageView.getDrawable().toString();
        celular = Celular.getText().toString();
        cep = Cep.getText().toString();
        altura = Altura.getText().toString();
        peso = Peso.getText().toString();
        endereco = Endereco.getText().toString();
        bairro = Bairro.getText().toString();
        filhos = Filhos.getText().toString();
        idadefilhos = Idadefilhos.getText().toString();
        nacionalidade = Ncionalidade.getText().toString();
        naturalidade = Naturalidade.getText().toString();
        estado_civil = Estado_civil.getText().toString();
        rg = Rg.getText().toString();
        cpf = Cpf.getText().toString();
        escolaridade = Escolaridade.getText().toString();
        categoriaC = CategoriaC.getText().toString();
        carteirahab = Carteirahab.getText().toString();
        serie = Serie.getText().toString();
        carteiraprof = Carteiraprof.getText().toString();

        Usuario usuario = new Usuario(nome, email, telefone, aniversario, sexo, cidade, celular, cep, altura, peso, endereco, bairro, filhos, idadefilhos, nacionalidade, naturalidade, estado_civil, rg, cpf, escolaridade, carteiraprof, serie, carteirahab, categoriaC, estado, imgurl);

     //   if (imgUri != null) { usuario.setImgurl(Simgurl); }
     //   else { usuario.setImgurl("https://firebasestorage.googleapis.com/v0/b/appcomerbem.appspot.com/o/Users%2Fum.png?alt=media&token=7ab7842e-5201-4ffe-9543-bef58863267c"); }

        String idUsuario = Base64Custom.codificarBase64(usuario.getEmail());
        usuario.setIdUsuario(idUsuario);
        usuario.salvar();
        onBackPressed();
        }

    public void Publickcc(View view) {

        nome = nameText.getText().toString();
        email = emailProfile.getText().toString();
        telefone = Telefone.getText().toString();
        aniversario = Data.getText().toString();
        sexo = Sexo.getText().toString();
        cidade = Cidade.getText().toString();
        estado = Estado.getText().toString();
        imgurl = foodImageView.getDrawable().toString();
        celular = Celular.getText().toString();
        cep = Cep.getText().toString();
        altura = Altura.getText().toString();
        peso = Peso.getText().toString();
        endereco = Endereco.getText().toString();
        bairro = Bairro.getText().toString();
        filhos = Filhos.getText().toString();
        idadefilhos = Idadefilhos.getText().toString();
        nacionalidade = Ncionalidade.getText().toString();
        naturalidade = Naturalidade.getText().toString();
        estado_civil = Estado_civil.getText().toString();
        rg = Rg.getText().toString();
        cpf = Cpf.getText().toString();
        escolaridade = Escolaridade.getText().toString();
        categoriaC = CategoriaC.getText().toString();
        carteirahab = Carteirahab.getText().toString();
        serie = Serie.getText().toString();
        carteiraprof = Carteiraprof.getText().toString();


        UsuarioC usuarioc = new UsuarioC(nome, email, telefone, aniversario, sexo, cidade,
                celular, cep, altura, peso, endereco, bairro,
                filhos, idadefilhos, nacionalidade, naturalidade, estado_civil, rg, cpf, escolaridade,
                carteiraprof, serie, carteirahab, categoriaC, estado, imgurl);

        if (imgUri != null) { usuarioc.setImgurl(Simgurl); }
        else { usuarioc.setImgurl("https://firebasestorage.googleapis.com/v0/b/appcomerbem.appspot.com/o/Users%2Fum.png?alt=media&token=7ab7842e-5201-4ffe-9543-bef58863267c"); }

        String key = Base64Custom.codificarBase64(usuarioc.getEmail());
        usuarioc.setIdUsuario(key);
        usuarioc.salvar();

        mDatabase.child(getString(R.string.Cureculum)).child(key).setValue(usuarioc);


        onBackPressed();
    }


}