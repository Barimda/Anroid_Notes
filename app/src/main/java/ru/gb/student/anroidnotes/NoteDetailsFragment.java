package ru.gb.student.anroidnotes;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class NoteDetailsFragment extends Fragment {

    private static final String CHILD_NOTE_ID = "noteID";

    private int noteID;

    public NoteDetailsFragment() {
        // Required empty public constructor
    }

    public static NoteDetailsFragment newInstance(int noteID) {
        NoteDetailsFragment fragment = new NoteDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(CHILD_NOTE_ID, noteID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (getArguments() != null) {
            noteID = getArguments().getInt(CHILD_NOTE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_details, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.note_details_menu, menu);

    }


    @Override
    public void onPause() {
        super.onPause();
        new AlertDialog.Builder(getContext())
                .setTitle("Внимание")
                .setMessage("Сохранить изменения?")
                // Из этого окна нельзя выйти кнопкой Back
                .setCancelable(false)
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //TODO make something (save note)
                        saveChanges();
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //TODO make something (unsave note)
                        discardChanges();
                    }
                })
                .show();
    }

    private void saveChanges() {
    }

    private void discardChanges() {
    }

}