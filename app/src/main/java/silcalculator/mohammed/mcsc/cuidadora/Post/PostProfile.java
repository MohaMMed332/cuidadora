package silcalculator.mohammed.mcsc.cuidadora.Post;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.Map;

import silcalculator.mohammed.mcsc.cuidadora.Curriculum.UsuarioC;
import silcalculator.mohammed.mcsc.cuidadora.Patroa.modol.UserStorage;
import silcalculator.mohammed.mcsc.cuidadora.Patroa.modol.Usuario;
import silcalculator.mohammed.mcsc.cuidadora.R;

public class PostProfile extends AppCompatActivity {

    Map<String, String> userInfos;
    String Imgurl;
    ImageView foodImageView;
    TextView nameText;
    Usuario usuario;
    private FirebaseAuth autenticacao;
    private DatabaseReference mDatabase;
    LinearLayout linearLayoutClick;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        final UsuarioC usuarioC ;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_profile);


        foodImageView = (ImageView) findViewById(R.id.imge_prof);
        Imgurl = getIntent().getExtras().getString("imgurl");


        nameText = (TextView) findViewById(R.id.nameText);
        nameText.setText(getIntent().getExtras().getString("nome"));



        userInfos = UserStorage.getUserInfo(getBaseContext());


    }

}
