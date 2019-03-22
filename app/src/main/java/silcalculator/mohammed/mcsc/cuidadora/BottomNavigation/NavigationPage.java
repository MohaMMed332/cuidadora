package silcalculator.mohammed.mcsc.cuidadora.BottomNavigation;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;

import silcalculator.mohammed.mcsc.cuidadora.Activity.Chat;


public class NavigationPage {

    private String title;
    private Drawable icon;
    private Fragment fragment;

    public NavigationPage(String title, Fragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public NavigationPage (String chat,Chat chat1) {

    }

    public String getTitle() {
        return title;
    }

    public Drawable getIcon() {
        return icon;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
