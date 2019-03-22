package silcalculator.mohammed.mcsc.cuidadora.Post;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import silcalculator.mohammed.mcsc.cuidadora.R;

public class PostAdapter extends ArrayAdapter<Product> {
    private Uri img_uri;
    private Context context;


    TextView nameText;
     WebView foodImageView;

    private DatabaseReference mDatabase;
    public Context ctx;

    public PostAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
        ctx = context;
        mDatabase = FirebaseDatabase.getInstance().getReference().child(" ");
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Product backEndPosts = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.post_adapter,
                    parent, false);


            foodImageView = (WebView) convertView.findViewById(R.id.Image_Cureeculm);
            foodImageView.getSettings().setUseWideViewPort(true);
            foodImageView.getSettings().setDisplayZoomControls(false);
            foodImageView.getSettings().setBuiltInZoomControls(true);
            foodImageView.setInitialScale(1);
            foodImageView.loadUrl(backEndPosts.getImgurl());

        }


        Bitmap bitmap;     // pfoto on text
        ImageView ivUserProfile;
        TextView nome_da_Receita, nomeUser;
        LinearLayout linearLayoutClick,linearLayoutClick2;


        nome_da_Receita = (TextView) convertView.findViewById(R.id.Posttrxt);
        nome_da_Receita.setText(backEndPosts.getNome_da_Receita());

        nomeUser = (TextView) convertView.findViewById(R.id.name_publec);
        nomeUser.setText(backEndPosts.getUsuario().getNome());

        ivUserProfile = (ImageView) convertView.findViewById(R.id.ivUserProfile);
        Picasso.with(ctx).load(backEndPosts.getUsuario().getImgurl()).into(ivUserProfile);

         nameText = (TextView) convertView.findViewById(R.id.nameText);

        linearLayoutClick = (LinearLayout) convertView.findViewById(R.id.linearLayoutClick);
        linearLayoutClick2 = (LinearLayout) convertView.findViewById(R.id.MaisCurreculum);



        linearLayoutClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edit = new Intent(getContext(), PostDetail.class);

                edit.putExtra("imgurl", backEndPosts.getImgurl());
                edit.putExtra("id", backEndPosts.getId());

                edit.putExtra("nome_da_Receita", backEndPosts.getNome_da_Receita());
                 edit.putExtra("categoria", backEndPosts.getCategoria());

                getContext().startActivity(edit);
            }
        });

        linearLayoutClick2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edit = new Intent(getContext(), PostProfile.class);

                edit.putExtra("nome", backEndPosts.getUsuario().getNome());
                edit.putExtra("email", backEndPosts.getUsuario().getEmail());
                edit.putExtra("imgurl", backEndPosts.getUsuario().getImgurl());
                edit.putExtra("aniversario", backEndPosts.getUsuario().getAniversario());
                edit.putExtra("sexo", backEndPosts.getUsuario().getSexo());
                edit.putExtra("cidade", backEndPosts.getUsuario().getCidade());
                edit.putExtra("estado", backEndPosts.getUsuario().getEstado());
                edit.putExtra("telefone", backEndPosts.getUsuario().getTelefone());
                edit.putExtra("celular", backEndPosts.getUsuario().getCelular());
                edit.putExtra("cep", backEndPosts.getUsuario().getCep());
                edit.putExtra("altura", backEndPosts.getUsuario().getAltura());
                edit.putExtra("peso", backEndPosts.getUsuario().getPeso());
                edit.putExtra("filhos", backEndPosts.getUsuario().getFilhos());
                edit.putExtra("idadefilhos", backEndPosts.getUsuario().getIdadefilhos());
                edit.putExtra("nacionalidade", backEndPosts.getUsuario().getNacionalidade());
                edit.putExtra("naturalidade", backEndPosts.getUsuario().getNaturalidade());
                edit.putExtra("estado_civil", backEndPosts.getUsuario().getEstado_civil());
                edit.putExtra("rg", backEndPosts.getUsuario().getRg());
                edit.putExtra("cpf", backEndPosts.getUsuario().getCpf());
                edit.putExtra("escolaridade", backEndPosts.getUsuario().getEscolaridade());
                edit.putExtra("carteiraprof", backEndPosts.getUsuario().getCarteiraprof());
                edit.putExtra("serie", backEndPosts.getUsuario().getSerie());
                edit.putExtra("carteirahab", backEndPosts.getUsuario().getCarteirahab());
                edit.putExtra("categoriaC", backEndPosts.getUsuario().getCategoriaC());
                edit.putExtra("endereco", backEndPosts.getUsuario().getEndereco());
                edit.putExtra("bairro", backEndPosts.getUsuario().getBairro());
                edit.putExtra("imgurl", backEndPosts.getUsuario().getImgurl());


                getContext().startActivity(edit);
            }
        });
        return convertView;


    }


}
