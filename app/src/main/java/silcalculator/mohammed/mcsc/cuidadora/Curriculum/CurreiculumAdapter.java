package silcalculator.mohammed.mcsc.cuidadora.Curriculum;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import silcalculator.mohammed.mcsc.cuidadora.R;

public class CurreiculumAdapter extends ArrayAdapter<UsuarioC> {
    private Uri img_uri;
    private Context context;
    private DatabaseReference mDatabase;
    public Context ctx;

    String nomeString, telefoneString, aniversarioString, sexoString, cidadeString, estadoString, imgurlString, celularString, cepString, alturaString, pesoString, enderecoString, bairroString, FilhosString, idadefilhosString, nacionalidadeString, naturalidadeString, estado_civilString, rgString, cpfString, escolaridadeString, carteiraprofString, serieString, carteirahabString, categoriaCString;
    String emailId;
    ImageView foodImageView;
    TextView nameText, EstadoP, CidadeP, celular;


    public CurreiculumAdapter(Context context, ArrayList<UsuarioC> usuarioCS) {
        super(context, 0, usuarioCS);
        ctx = context;
        mDatabase = FirebaseDatabase.getInstance().getReference().child(" ");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final UsuarioC usuarioC = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.curreiculum_adapter, parent, false);
        }


        Bitmap bitmap;     // pfoto on text
        ImageView foodImageView, ivUserProfile, edit1, delete;
        TextView nome_da_Receita, nomeUser;
        LinearLayout linearLayoutClick;

        foodImageView = (ImageView) convertView.findViewById(R.id.Image_Cureeculm);
        Picasso.with(ctx).load(usuarioC.getImgurl()).into(foodImageView);


        nameText = (TextView) convertView.findViewById(R.id.name_Cureeculm);
        nameText.setText(usuarioC.getNome());

        CidadeP = (TextView) convertView.findViewById(R.id.Cidade_Cureeculm);
        CidadeP.setText(usuarioC.getCidade());

        EstadoP = (TextView) convertView.findViewById(R.id.Estado_Cureeculm);
        EstadoP.setText(usuarioC.getEstado());

        celular = (TextView) convertView.findViewById(R.id.Profissao_Cureeculm);
        celular.setText(usuarioC.getCelular());


        linearLayoutClick = (LinearLayout) convertView.findViewById(R.id.MaisCurreculum);

        linearLayoutClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edit = new Intent(getContext(), CurreiculumDetail.class);

                edit.putExtra("nome", usuarioC.getNome());
                edit.putExtra("email", usuarioC.getEmail());
                edit.putExtra("imgurl", usuarioC.getImgurl());
                edit.putExtra("aniversario", usuarioC.getAniversario());
                edit.putExtra("sexo", usuarioC.getSexo());
                edit.putExtra("cidade", usuarioC.getCidade());
                edit.putExtra("estado", usuarioC.getEstado());
                edit.putExtra("telefone", usuarioC.getTelefone());
                edit.putExtra("celular", usuarioC.getCelular());
                edit.putExtra("cep", usuarioC.getCep());
                edit.putExtra("altura", usuarioC.getAltura());
                edit.putExtra("peso", usuarioC.getPeso());
                edit.putExtra("filhos", usuarioC.getFilhos());
                edit.putExtra("idadefilhos", usuarioC.getIdadefilhos());
                edit.putExtra("nacionalidade", usuarioC.getNacionalidade());
                edit.putExtra("naturalidade", usuarioC.getNaturalidade());
                edit.putExtra("estado_civil", usuarioC.getEstado_civil());
                edit.putExtra("rg", usuarioC.getRg());
                edit.putExtra("cpf", usuarioC.getCpf());
                edit.putExtra("escolaridade", usuarioC.getEscolaridade());
                edit.putExtra("carteiraprof", usuarioC.getCarteiraprof());
                edit.putExtra("serie", usuarioC.getSerie());
                edit.putExtra("carteirahab", usuarioC.getCarteirahab());
                edit.putExtra("categoriaC", usuarioC.getCategoriaC());
                edit.putExtra("endereco", usuarioC.getEndereco());
                edit.putExtra("bairro", usuarioC.getBairro());


                getContext().startActivity(edit);
            }
        });

        return convertView;


    }


}
