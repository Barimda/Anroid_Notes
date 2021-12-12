package ru.gb.student.anroidnotes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import ru.gb.student.anroidnotes.frontend.Navigation;
import ru.gb.student.anroidnotes.frontend.NavigationType;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotesListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotesListFragment extends Fragment {

    private static final String ARG_NOTE_ID = "noteID";

    private int mParam1;

    public NotesListFragment() {
        // Required empty public constructor
    }

    public static NotesListFragment newInstance(int index) {
        NotesListFragment fragment = new NotesListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NOTE_ID, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_NOTE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
    }

    private void navigateToDetails() {
        ConstraintLayout item =  getView().findViewById(R.id.note_item);
        item.setOnClickListener(v-> {
            Navigation.navigateTo(getFragmentManager(), R.id.notes_list, new NoteDetailsFragment(), NavigationType.ADD_WITH_BACKSTACK);
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null){
            int noteID = arguments.getInt(ARG_NOTE_ID);
        }
        navigateToDetails();
    }
}