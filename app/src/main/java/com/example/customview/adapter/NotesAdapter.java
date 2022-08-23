
package com.example.customview.adapter;

import android.util.Log;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customview.customs.NotesView;
import com.example.customview.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

	// no Context reference needed—can get it from a ViewGroup parameter
	private List<Note> items;

	public NotesAdapter() {
		this.items = new ArrayList<>();
	}

	@NonNull
	@Override
	public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		Log.e("NotesAdapter", "onCreateViewHolder");

		// no need for a LayoutInflater instance—
		// the custom view inflates itself
		NotesView itemView = new NotesView(parent.getContext());
		// manually set the CustomView's size
		itemView.setLayoutParams(new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT
		));
		return new NotesViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
		Log.e("NotesAdapter", String.format("onBindViewHolder(%d)", position));
		Note item = items.get(position);
		holder.bind(item);
	}

	@Override
	public int getItemCount() {
		return items.size();
	}

	@Override
	public long getItemId(int position) {
		return items.get(position).getId();
	}

	public void submitData(List<Note> notes) {
		this.items = notes;
		notifyDataSetChanged();
	}

	class NotesViewHolder extends RecyclerView.ViewHolder {

		public NotesView view;

		public NotesViewHolder(@NonNull NotesView view) {
			super(view);
			Log.e("NotesAdapter", String.format("NotesViewHolder(%d)", getAdapterPosition()));

			this.view = view;

			// on item clicked for representing item update from outside!
			this.view.setOnClickListener(view1 -> {
				// selected item
				Note item = items.get(getAdapterPosition());

				// update the content
				item.setTitle("Clicked");

				// updates all the views ?
				// calling onDraw on all the visible items
				notifyItemChanged(getAdapterPosition());

				// i can call invalidate on item and its will update like blow
				// calling onDraw on specific item
				// bind(item);
			});
		}

		public void bind(Note item) {
			view.setNote(item);
		}
	}
}