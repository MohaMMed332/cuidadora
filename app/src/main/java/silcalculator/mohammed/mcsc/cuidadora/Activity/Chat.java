package silcalculator.mohammed.mcsc.cuidadora.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import silcalculator.mohammed.mcsc.cuidadora.R;

public class Chat extends AppCompatActivity {
    public static Chat newInstance() {
        return new Chat();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }
}
