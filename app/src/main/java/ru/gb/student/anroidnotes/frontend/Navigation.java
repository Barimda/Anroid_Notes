package ru.gb.student.anroidnotes.frontend;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public final class Navigation {

    public static void navigateTo(FragmentManager fragmentManager, int viewElementID, Fragment fragment, NavigationType navigationType) {
        switch (navigationType) {
            case REPLACE:
                fragmentManager
                        .beginTransaction()
                        .replace(viewElementID, fragment)
                        .commit();
                break;
            case ADD_WITHOUT_BACKSTACK:
                fragmentManager
                        .beginTransaction()
                        .add(viewElementID, fragment)
                        .commit();
                break;
            case ADD_WITH_BACKSTACK:
                fragmentManager
                        .beginTransaction()
                        .add(viewElementID, fragment)
                        .addToBackStack("")
                        .commit();
                break;
        }


    }

}

