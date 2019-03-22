package silcalculator.mohammed.mcsc.cuidadora.Post;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.Map;

import silcalculator.mohammed.mcsc.cuidadora.Patroa.modol.UserStorage;
import silcalculator.mohammed.mcsc.cuidadora.Patroa.modol.Usuario;
import silcalculator.mohammed.mcsc.cuidadora.R;

public class PostAdd extends AppCompatActivity {
    private DatabaseReference mDatabase;
    ImageView imageView;
    private StorageReference mStorage;
    private Uri img_uri;
    private ProgressDialog progressDialog;
    private static String imgurl;

    public static Intent createIntent(Activity activity, Uri uri) {
        Intent intent = new Intent(activity, PostAdd.class);
        intent.setData(uri);
        return intent;
    }

    EditText nome_da_Receita;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_add);
        img_uri = null;
        nome_da_Receita = findViewById(R.id.add_name);
        imageView = findViewById(R.id.add_imge);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        progressDialog = new ProgressDialog(this);
        mStorage = FirebaseStorage.getInstance().getReference();


        Picasso.with(this)
                .load(img_uri)
                .placeholder(ContextCompat.getDrawable(this, R.drawable.person))
                .into(imageView);

    }

    public void imageView_click(View view) {

        ///open albom
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, 200);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 200 && data != null) {
            Uri imagerUri = data.getData();
            imageView.setImageURI(imagerUri);
            img_uri = imagerUri;
            Toast.makeText(getApplicationContext(), imagerUri.toString(), Toast.LENGTH_LONG).show();
        }
    }


    public void add(View view) {
        Calendar calendar = Calendar.getInstance();

        progressDialog.setMessage(getString(R.string.Carregando));
        progressDialog.show();

        String nameText;

        nameText = nome_da_Receita.getText().toString();


        if (img_uri == null) {
            progressDialog.dismiss();
            return;

        }
        if (nameText.isEmpty() || nameText.equals(" ")) {
            nome_da_Receita.setError(getString(R.string.Favor_preencher));
            return;
        }

        StorageReference filepath = mStorage.child(getString(R.string.Word)).child("img_" + calendar.getTimeInMillis());
        filepath.putFile(img_uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                progressDialog.dismiss();
                Toast.makeText(PostAdd.this, R.string.Upload_de_imagem, Toast.LENGTH_SHORT).show();
                Log.d("nome_da_Receita ---> ", nome_da_Receita.getText().toString());
                Log.d("imgurl ---> ", taskSnapshot.getDownloadUrl().toString());
                imgurl = taskSnapshot.getDownloadUrl().toString();
                Log.d("FUNCIONA ---> ", imgurl);
                Log.d("->", "Entrou");
                finish();
                Picasso.with(getApplicationContext()).load(taskSnapshot.getDownloadUrl()).into(imageView);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(PostAdd.this, R.string.não_carregou, Toast.LENGTH_SHORT).show();
            }
        });


        Product product = new Product(imgurl, nameText, setUserInfo());

        String key = mDatabase.child(getString(R.string.Word)).push().getKey();
        product.setId(key);

        mDatabase.child(getString(R.string.Word)).child(key).setValue(product);

        nome_da_Receita.setText("");

        Picasso.with(this)
                .load(imgurl)
                .placeholder(ContextCompat.getDrawable(this, R.drawable.person))
                .into(imageView);


    }

    public Usuario setUserInfo() {
        Usuario user = new Usuario();
        Map<String, String> userInfos = UserStorage.getUserInfo(getBaseContext());
        if (userInfos.get("USER_NAME") != null) {
            user.setNome(userInfos.get("USER_NAME"));

        }
        if (userInfos.get("USER_EMAIL") != null) {
            user.setEmail(userInfos.get("USER_EMAIL"));
        }
        if (userInfos.get("USER_PHONE") != null) {
            user.setTelefone(userInfos.get("USER_PHONE"));
        }
        if (userInfos.get("USER_SEXO") != null) {
            user.setSexo(userInfos.get("USER_SEXO"));
        }
        if (userInfos.get("USER_ANIVERSARIO") != null) {
            user.setAniversario(userInfos.get("USER_ANIVERSARIO"));
        }
        if (userInfos.get("USER_CIDADE") != null) {
            user.setCidade(userInfos.get("USER_CIDADE"));
        }
        if (userInfos.get("USER_ESTADO") != null) {
            user.setEstado(userInfos.get("USER_ESTADO"));
        }
        if (userInfos.get("IMG_URL") != null) {
            user.setImgurl(userInfos.get("IMG_URL"));
        }

        return user;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }


}
