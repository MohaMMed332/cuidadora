package silcalculator.mohammed.mcsc.cuidadora.Post;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;
import silcalculator.mohammed.mcsc.cuidadora.Patroa.modol.UserStorage;
import silcalculator.mohammed.mcsc.cuidadora.R;


public class PostDetail extends AppCompatActivity {

    TextView Posttrxt;
    ImageView imge_public;
    String Imgurl, id, Nome_da_ReceitaValue;
    LinearLayoutManager linearLayoutManager;
    Map<String, String> userInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_detail);


        id = getIntent().getExtras().getString("id");
      //  Nome_da_ReceitaValue = getIntent().getExtras().getString("nome_da_Receita");


        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);


        imge_public = (ImageView) findViewById(R.id.imge_public);
        Imgurl = getIntent().getExtras().getString("imgurl");

        Posttrxt = (TextView) findViewById(R.id.Posttrxt);
        Posttrxt.setText(getIntent().getExtras().getString("nome_da_Receita"));



        userInfos = UserStorage.getUserInfo(getBaseContext());

    }


}


