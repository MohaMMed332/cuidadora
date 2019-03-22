package silcalculator.mohammed.mcsc.cuidadora.Patroa.modol;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {


    public static void saveUserInfo(Context context, Usuario user) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString("USER_NAME", user.getNome());
        editor.putString("USER_EMAIL", user.getEmail());
        editor.putString("IMG_URL", user.getImgurl());
        editor.putString("USER_PHONE", user.getTelefone());
        editor.putString("USER_SEXO", user.getSexo());
        editor.putString("USER_ANIVERSARIO", user.getAniversario());
        editor.putString("USER_CIDADE", user.getCidade());
        editor.putString("USER_ESTADO", user.getEstado());
        editor.putString("USER_CELULAR", user.getCelular());
        editor.putString("USER_CEP", user.getCep());
        editor.putString("USER_ALTURA", user.getAltura());
        editor.putString("USER_PESO", user.getPeso());
        editor.putString("USER_FILHOS", user.getFilhos());
        editor.putString("USER_IDADEFILHOS", user.getIdadefilhos());
        editor.putString("USER_NACIONALIDADE", user.getNacionalidade());
        editor.putString("USER_NATURALIDADE", user.getNaturalidade());
        editor.putString("USER_RG", user.getRg());
        editor.putString("USER_CPF", user.getCpf());
        editor.putString("USER_ESCOLARIDADE", user.getEscolaridade());
        editor.putString("USER_CATRITAPROF", user.getCarteiraprof());
        editor.putString("USER_SERIE", user.getSerie());
        editor.putString("USER_CARTRITAHAB", user.getCarteirahab());
        editor.putString("USER_CARTRITAC", user.getCategoriaC());
        editor.putString("USER_ESTADO_CIVIL", user.getEstado_civil());
        editor.putString("USER_BAIRRO", user.getBairro());
        editor.putString("USER_ENDRECO", user.getEndereco());

        editor.apply();
    }

    public static Map<String, String> getUserInfo(Context context) {
        SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(context);
        Map<String, String> userInfos = new HashMap<String, String>();
        userInfos.put("USER_NAME", sh.getString("USER_NAME", null));
        userInfos.put("USER_EMAIL", sh.getString("USER_EMAIL", null));
        userInfos.put("IMG_URL", sh.getString("IMG_URL", null));
        userInfos.put("USER_PHONE", sh.getString("USER_PHONE", null));
        userInfos.put("USER_ANIVERSARIO", sh.getString("USER_ANIVERSARIO", null));
        userInfos.put("USER_SEXO", sh.getString("USER_SEXO", null));
        userInfos.put("USER_CIDADE", sh.getString("USER_CIDADE", null));
        userInfos.put("USER_ESTADO", sh.getString("USER_ESTADO", null));
        userInfos.put("USER_CELULAR", sh.getString("USER_CELULAR", null));
        userInfos.put("USER_CEP", sh.getString("USER_CEP", null));
        userInfos.put("USER_ALTURA", sh.getString("USER_ALTURA", null));
        userInfos.put("USER_PESO", sh.getString("USER_PESO", null));
        userInfos.put("USER_FILHOS", sh.getString("USER_FILHOS", null));
        userInfos.put("USER_IDADEFILHOS", sh.getString("USER_IDADEFILHOS", null));
        userInfos.put("USER_NACIONALIDADE", sh.getString("USER_NACIONALIDADE", null));
        userInfos.put("USER_NATURALIDADE", sh.getString("USER_NATURALIDADE", null));
        userInfos.put("USER_RG", sh.getString("USER_RG", null));
        userInfos.put("USER_CPF", sh.getString("USER_CPF", null));
        userInfos.put("USER_ESCOLARIDADE", sh.getString("USER_ESCOLARIDADE", null));
        userInfos.put("USER_CATRITAPROF", sh.getString("USER_CATRITAPROF", null));
        userInfos.put("USER_SERIE", sh.getString("USER_SERIE", null));
        userInfos.put("USER_CARTRITAHAB", sh.getString("USER_CARTRITAHAB", null));
        userInfos.put("USER_CARTRITAC", sh.getString("USER_CARTRITAC", null));
        userInfos.put("USER_ESTADO_CIVIL", sh.getString("USER_ESTADO_CIVIL", null));
        userInfos.put("USER_BAIRRO", sh.getString("USER_BAIRRO", null));
        userInfos.put("USER_ENDRECO", sh.getString("USER_ENDRECO", null));
         return userInfos;
    }

}
