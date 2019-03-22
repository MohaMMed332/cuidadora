package silcalculator.mohammed.mcsc.cuidadora.People;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import silcalculator.mohammed.mcsc.cuidadora.Patroa.modol.Usuario;
import silcalculator.mohammed.mcsc.cuidadora.R;

public class PeopleAdapter extends ArrayAdapter<Usuario> {
    public Context ctx;
    private DatabaseReference mDatabase;

    public PeopleAdapter(Context context, ArrayList<Usuario> usuarios) {
        super(context, 0, usuarios);
        ctx = context;
        mDatabase = FirebaseDatabase.getInstance().getReference().child("");
    }


    private Uri img_uri;
    private Context context;
    String nomeString, telefoneString, aniversarioString, sexoString, cidadeString, estadoString, imgurlString, celularString, cepString, alturaString, pesoString, enderecoString, bairroString, FilhosString, idadefilhosString, nacionalidadeString, naturalidadeString, estado_civilString, rgString, cpfString, escolaridadeString, carteiraprofString, serieString, carteirahabString, categoriaCString;
    String emailId;
    TextView nameText, EstadoP, CidadeP, celular;
    WebView foodImageView;
    TextView nome_da_Receita, nomeUser;
    TextView linearLayoutClick;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Usuario usuario = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.people_adapter,
                    parent, false);

            foodImageView = (WebView) convertView.findViewById(R.id.Image_Cureeculm);
            foodImageView.getSettings().setUseWideViewPort(true);
            foodImageView.getSettings().setDisplayZoomControls(false);
            foodImageView.getSettings().setBuiltInZoomControls(true);
            foodImageView.setInitialScale(1);
            foodImageView.loadUrl(usuario.getImgurl());
        }


        // Picasso.with(ctx).load(usuario.getImgurl()).into(foodImageView);


        nameText = (TextView) convertView.findViewById(R.id.name_Cureeculm);
        nameText.setText(usuario.getNome());


        return convertView;
    }

}
