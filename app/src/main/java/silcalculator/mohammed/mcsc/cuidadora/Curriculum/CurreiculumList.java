package silcalculator.mohammed.mcsc.cuidadora.Curriculum;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import silcalculator.mohammed.mcsc.cuidadora.Post.PostList;

import silcalculator.mohammed.mcsc.cuidadora.R;

public class CurreiculumList extends Fragment {

    private OnFragmentInteractionListener listener;
    public static CurreiculumList newInstance() { return new CurreiculumList(); }
    @Override public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    private DatabaseReference mDatabase;
    ArrayList<UsuarioC> usuarioCS;
    ListView productsList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.curreiculum_list, container, false);
        productsList = (ListView)view.findViewById(R.id.listView);
        mDatabase = FirebaseDatabase.getInstance().getReference().child(getString(R.string.Cureculum));
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usuarioCS = new ArrayList<>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    UsuarioC usuarioC = postSnapshot.getValue(UsuarioC.class);
                    usuarioCS.add(usuarioC);
                }
                CurreiculumAdapter adapter = new CurreiculumAdapter(getActivity(), usuarioCS);
                productsList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return  view ;

    }












    @Override
    public void onAttach(Context context) { super.onAttach(context);
        if (context instanceof PostList.OnFragmentInteractionListener) { listener = (OnFragmentInteractionListener) context; }
        else { throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener"); } }

    @Override public void onDetach() { super.onDetach();listener = null; }
    public interface OnFragmentInteractionListener { void onClicked();}

}
