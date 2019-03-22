package silcalculator.mohammed.mcsc.cuidadora.People;

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

import silcalculator.mohammed.mcsc.cuidadora.Patroa.modol.Usuario;

import silcalculator.mohammed.mcsc.cuidadora.Post.PostList;
import silcalculator.mohammed.mcsc.cuidadora.R;

public class PeopleList extends Fragment {
    private PeopleList.OnFragmentInteractionListener listener;

    public static PeopleList newInstance() {
        return new PeopleList();
    }
    ArrayList<Usuario> usuarios;
    ListView productsList;
    private DatabaseReference mDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.people_list, container, false);
        productsList = (ListView) view.findViewById(R.id.listView);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("usuarios");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usuarios = new ArrayList<>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Usuario usuario = postSnapshot.getValue(Usuario.class);
                    usuarios.add(usuario);
                }
                PeopleAdapter adapter = new PeopleAdapter(getActivity(), usuarios);
                productsList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return view;

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PostList.OnFragmentInteractionListener) {
         } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnFragmentInteractionListener {
    }
}
