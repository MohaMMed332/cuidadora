package silcalculator.mohammed.mcsc.cuidadora.FirebaseLogin;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import silcalculator.mohammed.mcsc.cuidadora.Activity.PatroaPrincipa;
import silcalculator.mohammed.mcsc.cuidadora.Patroa.modol.Usuario;
import silcalculator.mohammed.mcsc.cuidadora.Patroa.modol.UserStorage;
import silcalculator.mohammed.mcsc.cuidadora.R;
import silcalculator.mohammed.mcsc.cuidadora.config.ConfiguracaoFirebase;

public class LoginActivity extends AppCompatActivity {


    private Button botaoEntrar;
    private EditText campoEmail, campoSenha;
    private Usuario usuario;
    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_patroa);
        final ProgressDialog progressDialog = new ProgressDialog(this);


        campoEmail = findViewById(R.id.editEmail);
        campoSenha = findViewById(R.id.editSenha);
        botaoEntrar = findViewById(R.id.buttonEntrar);


        botaoEntrar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View v) {

                String textoEmail = campoEmail.getText().toString();
                String textoSenha = campoSenha.getText().toString();

                if (!textoEmail.isEmpty()) {
                    if (!textoSenha.isEmpty()) {

                        usuario = new Usuario();
                        usuario.setEmail(textoEmail);
                        usuario.setSenha(textoSenha);
                        validarLogin();
                    } else {
                        Toast.makeText(LoginActivity.this,
                                R.string.Preencher_a_senha,
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this,
                            R.string.Preencher_o_email,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void validarLogin() {

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    getUserInfo(usuario.getEmail());

                } else {

                    String excecao = "";
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e) {
                        excecao = getString(R.string.Usuário_não_cadastrado);
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = getString(R.string.Email_e_senha_não_correspondem_a_um_usuário_cadastrado);
                    } catch (Exception e) {
                        excecao = getString(R.string.Erro_ao_cadastrar_usuário) + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(LoginActivity.this,
                            excecao,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void getUserInfo(String email) {

        FirebaseDatabase.getInstance().getReference()
                .child("usuarios").orderByChild("email").equalTo(email)
                .addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        Usuario user = dataSnapshot.getValue(Usuario.class);
                        Iterable<DataSnapshot> iterable = dataSnapshot.getChildren();
                        for (DataSnapshot child : iterable) {
                            user.setNome(child.child("nome").getValue().toString());
                            user.setEmail(child.child("email").getValue().toString());


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
                            if (child.child("idadeFilhos").exists()) {
                                user.setIdadefilhos(child.child("idadeFilhos").getValue().toString());
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
                        abrirTelaPrincipal();

// do something with this user or save it
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

    public void btCadastrar(View view) {
        startActivity(new Intent(this, CadastroActivity.class));
    }


}
