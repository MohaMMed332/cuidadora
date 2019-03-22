
package silcalculator.mohammed.mcsc.cuidadora.Menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import silcalculator.mohammed.mcsc.cuidadora.Activity.About;
import silcalculator.mohammed.mcsc.cuidadora.Activity.Chat;
import silcalculator.mohammed.mcsc.cuidadora.Curriculum.CurreiculumActivity;
import silcalculator.mohammed.mcsc.cuidadora.Activity.Settings;
import silcalculator.mohammed.mcsc.cuidadora.FirebaseLogin.LoginActivity;
import silcalculator.mohammed.mcsc.cuidadora.R;
import silcalculator.mohammed.mcsc.cuidadora.config.ConfiguracaoFirebase;


public class MenuListFragment extends Fragment {
    private ImageView ivMenuUserProfilePhoto;
    private TextView ivMenuUserProfileName;
    private FirebaseAuth autenticacao;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public final void finishFragment() {
        getActivity().onBackPressed();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_menu, container, false);
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        NavigationView vNavigation = (NavigationView) view.findViewById(R.id.vNavigation);
        vNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                Toast.makeText(getActivity(), menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                if (id == R.id.Profile) {
                    Intent intent = new Intent(getActivity(), CurreiculumActivity.class);
                    startActivity(intent);
                }
                if (id == R.id.Chat) {
                    Intent intent = new Intent(getActivity(), Chat.class);
                    startActivity(intent);
                }
                if (id == R.id.menu_settings) {
                    Intent intent = new Intent(getActivity(), Settings.class);
                    startActivity(intent);
                }
                if (id == R.id.menu_about) {
                    Intent intent = new Intent(getActivity(), About.class);
                    startActivity(intent);
                }
                if (id == R.id.Exit) {
                    AlertDialog.Builder alertDialogBuilder;
                    alertDialogBuilder = new AlertDialog.Builder(new ContextThemeWrapper(
                            (getActivity()), R.style.CardView));
                    alertDialogBuilder.setTitle(getString(R.string.Sair_da_conta));
                    alertDialogBuilder.setMessage(R.string.Você_realmente_quer_sair_da_conta);
                    alertDialogBuilder.setCancelable(false);
                    alertDialogBuilder.setPositiveButton(R.string.Sim, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //PrincipalActivity.super.onBackPressed();
                            Log.d("->", getString(R.string.Entrou));
                            autenticacao.signOut();
                            finish();
                            Intent i = new Intent(getActivity(), LoginActivity.class);
                            startActivity(i);
                            Toast.makeText(getActivity(), getString(R.string.Sair), Toast.LENGTH_SHORT).show();
                        }
                    });
                    alertDialogBuilder.setNegativeButton(getString(R.string.Não), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }
                return false;
            }
        });
        setupHeader();
        return view;
    }


    private void setupHeader() {
        int avatarSize = getResources().getDimensionPixelSize(R.dimen.global_menu_avatar_size);
        String profilePhoto = getResources().getString(R.string.user_profile_photo);

    }

    public void finish() {
        Activity activity = getActivity();
        if (activity == null) return;
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            activity.finish();
        }
    }
}
