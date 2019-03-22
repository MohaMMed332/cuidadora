package silcalculator.mohammed.mcsc.cuidadora.Splash;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TypefaceSpan;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

import silcalculator.mohammed.mcsc.cuidadora.Activity.PatroaPrincipa;
import silcalculator.mohammed.mcsc.cuidadora.FirebaseLogin.LoginActivity;
import silcalculator.mohammed.mcsc.cuidadora.R;
import silcalculator.mohammed.mcsc.cuidadora.config.ConfiguracaoFirebase;

public class WelcomeActivity extends IntroActivity {

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setButtonBackVisible(false);
        setButtonNextVisible(false);
        setButtonCtaVisible(false);
        setButtonCtaTintMode(BUTTON_CTA_TINT_MODE_BACKGROUND);
        TypefaceSpan labelSpan = new TypefaceSpan(
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? "sans-serif-medium" : "sans serif");
        SpannableString label = SpannableString
                .valueOf(getString(R.string.label_button_cta_canteen_intro));
        label.setSpan(labelSpan, 0, label.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        setButtonCtaLabel(label);

        setPageScrollDuration(500);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setPageScrollInterpolator(android.R.interpolator.fast_out_slow_in);
        }


        addSlide( new FragmentSlide.Builder()
                .background(R.color.black)
                .fragment(R.layout.intro_1)
                .build());
        addSlide( new FragmentSlide.Builder()
                .background(R.color.black)
                .fragment(R.layout.intro_2)
                .build());
        addSlide( new FragmentSlide.Builder()
                .background(R.color.black)
                .fragment(R.layout.intro_3)
                .build());
        addSlide( new FragmentSlide.Builder()
                .background(R.color.black)
                .fragment(R.layout.intro_4)
                .build());
        addSlide( new FragmentSlide.Builder()
                .background(R.color.black)
                .fragment(R.layout.intro_cadastro)
                .build());



        autoplay(2000, INFINITE);

    }



    @Override
    protected void onStart() {
        super.onStart();
        verificarUsuarioLogado();




    }

   public void EntrarPatroa(View view){ startActivity(new Intent(this, LoginActivity.class)); }


    public void verificarUsuarioLogado(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        //autenticacao.signOut();
        if( autenticacao.getCurrentUser() != null ){
            abrirTelaPrincipal();
            finish();
        }
    }

    public void abrirTelaPrincipal(){
        startActivity(new Intent(this, PatroaPrincipa.class));
    }



}
