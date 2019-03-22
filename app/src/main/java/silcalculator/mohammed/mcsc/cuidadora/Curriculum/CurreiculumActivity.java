package silcalculator.mohammed.mcsc.cuidadora.Curriculum;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Map;

import silcalculator.mohammed.mcsc.cuidadora.Activity.PatroaPrincipa;
import silcalculator.mohammed.mcsc.cuidadora.Patroa.modol.UserStorage;
import silcalculator.mohammed.mcsc.cuidadora.Patroa.modol.Usuario;
import silcalculator.mohammed.mcsc.cuidadora.R;
import silcalculator.mohammed.mcsc.cuidadora.config.ConfiguracaoFirebase;

public class CurreiculumActivity extends AppCompatActivity {
    String nomeString, telefoneString, aniversarioString, sexoString,
            cidadeString, estadoString,imgurlString,
            celularString,cepString,alturaString,pesoString,
            enderecoString,bairroString,
            FilhosString,idadefilhosString,nacionalidadeString
            ,naturalidadeString,estado_civilString,rgString,
            cpfString,escolaridadeString,
            carteiraprofString,serieString,carteirahabString,categoriaCString;


    String emailId;

    ImageView foodImageView;
    TextView nameText, emailProfile, numberphone, EstadoP, CidadeP, DataNP,
            SexoP, celular, cep, altura, peso, filhos, idadefilhos,
            nacionalidade, naturalidade, rg, cpf, escolaridade,
            carteiraprof, serie, carteirahab, categoriaC,
            estado_civil, bairro, endereco;

    Usuario usuario;
    private FirebaseAuth autenticacao;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.curreiculum);

        foodImageView = (ImageView) findViewById(R.id.imge_prof);
        nameText = (TextView) findViewById(R.id.nameText);
        numberphone = (TextView) findViewById(R.id.numberphone);
        emailProfile = (TextView) findViewById(R.id.email);
        SexoP = (TextView) findViewById(R.id.SexoP);
        DataNP = (TextView) findViewById(R.id.DataP);
        CidadeP = (TextView) findViewById(R.id.CidadeP);
        EstadoP = (TextView) findViewById(R.id.EstadoP);
        celular = (TextView) findViewById(R.id.celular);
        cep = (TextView) findViewById(R.id.cep);
        altura = (TextView) findViewById(R.id.altura);
        peso = (TextView) findViewById(R.id.peso);
        filhos = (TextView) findViewById(R.id.filhos);
        idadefilhos = (TextView) findViewById(R.id.idadefilhos);
        nacionalidade = (TextView) findViewById(R.id.nacionalidade);
        naturalidade = (TextView) findViewById(R.id.naturalidade);
        rg = (TextView) findViewById(R.id.rg);
        cpf = (TextView) findViewById(R.id.cpf);
        escolaridade = (TextView) findViewById(R.id.escolaridade);
        carteiraprof = (TextView) findViewById(R.id.carteiraprof);
        serie = (TextView) findViewById(R.id.serie);
        carteirahab = (TextView) findViewById(R.id.carteirahab);
        categoriaC = (TextView) findViewById(R.id.categoriaC);
        estado_civil = (TextView) findViewById(R.id.estado_civil);
        bairro = (TextView) findViewById(R.id.bairro);
        endereco = (TextView) findViewById(R.id.endereco);


        setUserInfo();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();


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
            numberphone.setText(userInfos.get("USER_PHONE"));
        }
        if (userInfos.get("USER_SEXO") != null) {
            SexoP.setText(userInfos.get("USER_SEXO"));
        }
        if (userInfos.get("USER_ANIVERSARIO") != null) {
            DataNP.setText(userInfos.get("USER_ANIVERSARIO"));
        }
        if (userInfos.get("USER_CIDADE") != null) {
            CidadeP.setText(userInfos.get("USER_CIDADE"));
        }
        if (userInfos.get("USER_ESTADO") != null) {
            EstadoP.setText(userInfos.get("USER_ESTADO"));
        }
        if (userInfos.get("USER_CELULAR") != null) {
            celular.setText(userInfos.get("USER_CELULAR"));
        }
        if (userInfos.get("USER_CEP") != null) {
            cep.setText(userInfos.get("USER_CEP"));
        }
        if (userInfos.get("USER_ALTURA") != null) {
            altura.setText(userInfos.get("USER_ALTURA"));
        }
        if (userInfos.get("USER_PESO") != null) {
            peso.setText(userInfos.get("USER_PESO"));
        }
        if (userInfos.get("USER_FILHOS") != null) {
            filhos.setText(userInfos.get("USER_FILHOS"));
        }
        if (userInfos.get("USER_IDADEFILHOS") != null) {
            idadefilhos.setText(userInfos.get("USER_IDADEFILHOS"));
        }
        if (userInfos.get("USER_NACIONALIDADE") != null) {
            nacionalidade.setText(userInfos.get("USER_NACIONALIDADE"));
        }
        if (userInfos.get("USER_NATURALIDADE") != null) {
            naturalidade.setText(userInfos.get("USER_NATURALIDADE"));
        }
        if (userInfos.get("USER_RG") != null) {
            rg.setText(userInfos.get("USER_RG"));
        }
        if (userInfos.get("USER_CPF") != null) {
            cpf.setText(userInfos.get("USER_CPF"));
        }
        if (userInfos.get("USER_ESCOLARIDADE") != null) {
            escolaridade.setText(userInfos.get("USER_ESCOLARIDADE"));
        }
        if (userInfos.get("USER_CATRITAPROF") != null) {
            carteiraprof.setText(userInfos.get("USER_CATRITAPROF"));
        }
        if (userInfos.get("USER_SERIE") != null) {
            serie.setText(userInfos.get("USER_SERIE"));
        }
        if (userInfos.get("USER_CARTRITAHAB") != null) {
            carteirahab.setText(userInfos.get("USER_CARTRITAHAB"));
        }
        if (userInfos.get("USER_CARTRITAC") != null) {
            categoriaC.setText(userInfos.get("USER_CARTRITAC"));
        }
        if (userInfos.get("USER_ESTADO_CIVIL") != null) {
            estado_civil.setText(userInfos.get("USER_ESTADO_CIVIL"));
        }
        if (userInfos.get("USER_BAIRRO") != null) {
            bairro.setText(userInfos.get("USER_BAIRRO"));
        }
        if (userInfos.get("USER_ENDRECO") != null) {
            endereco.setText(userInfos.get("USER_ENDRECO"));
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
                .addListenerForSingleValueEvent(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        getUserInfo(usuario.getEmail());

                        Usuario user = dataSnapshot.getValue(Usuario.class);
                        Iterable<DataSnapshot> iterable = dataSnapshot.getChildren();
                        for (DataSnapshot child : iterable) {
                            user.setNome(child.child("nome").getValue().toString());
                            user.setEmail(child.child("email").getValue().toString());
                            user.setImgurl(child.child("imgurl").getValue().toString());
                            user.setAniversario(child.child("aniversario").getValue().toString());
                            user.setSexo(child.child("sexo").getValue().toString());
                            user.setCidade(child.child("cidade").getValue().toString());
                            user.setEstado(child.child("estado").getValue().toString());
                            user.setCelular(child.child("celular").getValue().toString());
                            user.setCep(child.child("cep").getValue().toString());
                            user.setAltura(child.child("altura").getValue().toString());
                            user.setPeso(child.child("peso").getValue().toString());
                            user.setFilhos(child.child("filhos").getValue().toString());
                            user.setIdadefilhos(child.child("idadefilhos").getValue().toString());
                            user.setNacionalidade(child.child("nacionalidade").getValue().toString());
                            user.setNaturalidade(child.child("naturalidade").getValue().toString());
                            user.setEstado_civil(child.child("estado_civil").getValue().toString());
                            user.setRg(child.child("rg").getValue().toString());
                            user.setCpf(child.child("cpf").getValue().toString());
                            user.setEscolaridade(child.child("escolaridade").getValue().toString());
                            user.setCarteiraprof(child.child("carteiraprof").getValue().toString());
                            user.setSerie(child.child("serie").getValue().toString());
                            user.setCarteirahab(child.child("carteirahab").getValue().toString());
                            user.setCategoriaC(child.child("categoriaC").getValue().toString());
                            user.setEndereco(child.child("endereco").getValue().toString());
                            user.setBairro(child.child("bairro").getValue().toString());

                        }

                        UserStorage.saveUserInfo(getApplicationContext(), user);

                        abrirTelaPrincipal();

                     }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                        Log.w("->", "loadPost:onCancelled", databaseError.toException());

                    }
                });

    }


    public void abrirTelaPrincipal() {
        startActivity(new Intent(this, PatroaPrincipa.class));
        finish();
    }
    public void editCurreculum(View view) {
        Intent intent = new Intent(this, CurreiculumEdit.class);
        startActivity(intent);
    }
}