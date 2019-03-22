package silcalculator.mohammed.mcsc.cuidadora.Curriculum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
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

public class Profile extends AppCompatActivity {

    ImageView foodImageView;
    TextView nameText;

    Usuario usuario;
    private FirebaseAuth autenticacao;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        foodImageView = (ImageView) findViewById(R.id.imge_prof);
        nameText = (TextView) findViewById(R.id.nameText);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();

        setUserInfo();
    }

    public void setUserInfo() {

        Map<String, String> userInfos = UserStorage.getUserInfo(getBaseContext());
        if (userInfos.get("USER_NAME") != null) {
            nameText.setText(userInfos.get("USER_NAME"));
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
                            user.setImgurl(child.child("imgurl").getValue().toString());

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


    public void curreculum(View view) {
        Intent intent = new Intent(this, CurreiculumActivity.class);
        startActivity(intent);
    }
}