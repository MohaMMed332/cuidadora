package silcalculator.mohammed.mcsc.cuidadora.Curriculum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.Map;

import silcalculator.mohammed.mcsc.cuidadora.Patroa.modol.UserStorage;
import silcalculator.mohammed.mcsc.cuidadora.R;

public class CurreiculumDetail extends AppCompatActivity {
    String nomeString, telefoneString, aniversarioString, sexoString,
            cidadeString, estadoString, imgurlString,
            celularString, cepString, alturaString, pesoString,
            enderecoString, bairroString,
            FilhosString, idadefilhosString, nacionalidadeString, naturalidadeString, estado_civilString, rgString,
            cpfString, escolaridadeString,
            carteiraprofString, serieString, carteirahabString, categoriaCString;

    Map<String, String> userInfos;


    String Imgurl;

    ImageView foodImageView;
    TextView nameText, emailProfile, numberphone, EstadoP, CidadeP, DataNP, SexoP, celular, cep, altura, peso, filhos, idadefilhos,
            nacionalidade, naturalidade, rg, cpf, escolaridade, carteiraprof, serie, carteirahab, categoriaC, estado_civil, bairro, endereco;

    private FirebaseAuth autenticacao;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.curreiculum_detail);


        foodImageView = (ImageView) findViewById(R.id.imge_prof);
        Imgurl = getIntent().getExtras().getString("imgurl");


        nameText = (TextView) findViewById(R.id.nameText);
        nameText.setText(getIntent().getExtras().getString("nome"));

        numberphone = (TextView) findViewById(R.id.numberphone);
        numberphone.setText(getIntent().getExtras().getString("telefone"));

        emailProfile = (TextView) findViewById(R.id.email);
        emailProfile.setText(getIntent().getExtras().getString("email"));

        SexoP = (TextView) findViewById(R.id.SexoP);
        SexoP.setText(getIntent().getExtras().getString("sexo"));

        DataNP = (TextView) findViewById(R.id.DataP);
        DataNP.setText(getIntent().getExtras().getString("aniversario"));

        CidadeP = (TextView) findViewById(R.id.CidadeP);
        CidadeP.setText(getIntent().getExtras().getString("cidade"));

        EstadoP = (TextView) findViewById(R.id.EstadoP);
        EstadoP.setText(getIntent().getExtras().getString("estado"));

        celular = (TextView) findViewById(R.id.celular);
        celular.setText(getIntent().getExtras().getString("celular"));

        cep = (TextView) findViewById(R.id.cep);
        cep.setText(getIntent().getExtras().getString("cep"));

        altura = (TextView) findViewById(R.id.altura);
        altura.setText(getIntent().getExtras().getString("altura"));

        peso = (TextView) findViewById(R.id.peso);
        peso.setText(getIntent().getExtras().getString("peso"));

        filhos = (TextView) findViewById(R.id.filhos);
        filhos.setText(getIntent().getExtras().getString("filhos"));

        idadefilhos = (TextView) findViewById(R.id.idadefilhos);
        idadefilhos.setText(getIntent().getExtras().getString("idadefilhos"));

        nacionalidade = (TextView) findViewById(R.id.nacionalidade);
        nacionalidade.setText(getIntent().getExtras().getString("nacionalidade"));

        naturalidade = (TextView) findViewById(R.id.naturalidade);
        naturalidade.setText(getIntent().getExtras().getString("naturalidade"));

        rg = (TextView) findViewById(R.id.rg);
        rg.setText(getIntent().getExtras().getString("rg"));

        cpf = (TextView) findViewById(R.id.cpf);
        cpf.setText(getIntent().getExtras().getString("cpf"));

        escolaridade = (TextView) findViewById(R.id.escolaridade);
        escolaridade.setText(getIntent().getExtras().getString("escolaridade"));

        carteiraprof = (TextView) findViewById(R.id.carteiraprof);
        carteiraprof.setText(getIntent().getExtras().getString("carteiraprof"));

        serie = (TextView) findViewById(R.id.serie);
        serie.setText(getIntent().getExtras().getString("serie"));

        carteirahab = (TextView) findViewById(R.id.carteirahab);
        carteirahab.setText(getIntent().getExtras().getString("carteirahab"));

        categoriaC = (TextView) findViewById(R.id.categoriaC);
        categoriaC.setText(getIntent().getExtras().getString("categoriaC"));

        estado_civil = (TextView) findViewById(R.id.estado_civil);
        estado_civil.setText(getIntent().getExtras().getString("estado_civil"));

        bairro = (TextView) findViewById(R.id.bairro);
        bairro.setText(getIntent().getExtras().getString("endereco"));

        endereco = (TextView) findViewById(R.id.endereco);
        endereco.setText(getIntent().getExtras().getString("bairro"));


        userInfos = UserStorage.getUserInfo(getBaseContext());


    }
}
