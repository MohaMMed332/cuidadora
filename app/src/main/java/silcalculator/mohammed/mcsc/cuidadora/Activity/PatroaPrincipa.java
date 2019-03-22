package silcalculator.mohammed.mcsc.cuidadora.Activity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import silcalculator.mohammed.mcsc.cuidadora.BottomNavigation.BottomBarHolderActivity;
import silcalculator.mohammed.mcsc.cuidadora.BottomNavigation.NavigationPage;
import silcalculator.mohammed.mcsc.cuidadora.Curriculum.CurreiculumList;
import silcalculator.mohammed.mcsc.cuidadora.People.PeopleList;
import silcalculator.mohammed.mcsc.cuidadora.Post.PostList;

public class PatroaPrincipa extends BottomBarHolderActivity implements PostList.OnFragmentInteractionListener, CurreiculumList.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NavigationPage page1 = new NavigationPage("Post", PostList.newInstance());
        NavigationPage page2 = new NavigationPage("Curriculum", CurreiculumList.newInstance());
        NavigationPage page3 = new NavigationPage("People", PeopleList.newInstance());
        //ContextCompat.getDrawable(this, R.drawable.ic_people),
        NavigationPage page4 = new NavigationPage("Chat", Chat.newInstance());

        List<NavigationPage> navigationPages = new ArrayList<>();
        navigationPages.add(page1);
        navigationPages.add(page2);
        navigationPages.add(page3);
        navigationPages.add(page4);

        super.setupBottomBarHolderActivity(navigationPages);

    }

    @Override
    public void onClicked() {
        Toast.makeText(this, "Clicked!", Toast.LENGTH_SHORT).show();
    }


}