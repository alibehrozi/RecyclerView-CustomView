package com.example.customview;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customview.adapter.NotesAdapter;
import com.example.customview.model.Note;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private NotesAdapter notesAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LinearLayout layout = new LinearLayout(this);
		layout.setLayoutParams(
				new LinearLayout.LayoutParams(
						LinearLayout.LayoutParams.MATCH_PARENT,
						LinearLayout.LayoutParams.MATCH_PARENT
				));

		setContentView(layout);

		// Setup recyclerView
		RecyclerView notesRecyclerView = new RecyclerView(this);
		notesRecyclerView.setHasFixedSize(true);

		// use a linear layout manager
		RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
		notesRecyclerView.setLayoutManager(layoutManager);

		// Adapter
		notesAdapter = new NotesAdapter();
		notesAdapter.setHasStableIds(true);
		notesRecyclerView.setAdapter(notesAdapter);

		notesRecyclerView.setLayoutParams(
				new LinearLayout.LayoutParams(
						ViewGroup.LayoutParams.MATCH_PARENT,
						ViewGroup.LayoutParams.MATCH_PARENT
				));
		// Add recycler view to layout parent
		layout.addView(notesRecyclerView);

		// Create a list of notes
		List<Note> notes = new ArrayList<>();

		notes.add(new Note(0, "Title 0", "Content 0"));
		notes.add(new Note(1, "Title 1", "Content 1"));
		notes.add(new Note(2, "Title 2", "Content 2"));
		notes.add(new Note(3, "Title 3", "Content 3"));
		notes.add(new Note(4, "Title 4", "Content 4"));
		notes.add(new Note(5, "Title 5", "Content 5"));
		notes.add(new Note(6, "Title 6", "Content 6"));
		notes.add(new Note(7, "Title 7", "Content 7"));

		// Load notes into recycler view
		notesAdapter.submitData(notes);
	}
}