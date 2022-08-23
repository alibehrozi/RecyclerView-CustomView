package com.example.customview.customs;

import static com.example.customview.utilities.ViewUtils.dpToPx;
import static com.example.customview.utilities.ViewUtils.spToPx;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.example.customview.model.Note;
import com.example.customview.utilities.RandomColors;
import com.example.customview.utilities.ViewUtils;

import java.util.Locale;

public class NotesView extends View {

	private static final String TAG = NotesView.class.getSimpleName();

	private Note note;
	private final TextPaint sTitlePaint;
	private final RandomColors randomColors;

	// override all constructors to ensure custom logic runs in all cases
	public NotesView(Context context) {
		this(context, null);
	}

	public NotesView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public NotesView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		randomColors = new RandomColors();
		sTitlePaint = new TextPaint();
		ViewUtils.addRipple(context, new TypedValue(), this);
	}

	public void setNote(Note note) {
		this.note = note;
		invalidate();
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		Log.e(TAG, String.format(Locale.US, "onLayout (%d)", note.id));
		super.onLayout(changed, left, top, right, bottom);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		Log.e(TAG, String.format(Locale.US, "onSizeChanged (%d)", note.id));
		super.onSizeChanged(w, h, oldw, oldh);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		Log.e(TAG, String.format(Locale.US, "onMeasure (%d)", note.id));
		// Ignore given specs. Will always be the same size
		heightMeasureSpec = MeasureSpec.makeMeasureSpec(
				dpToPx(60, getContext()),
				MeasureSpec.EXACTLY);

		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Log.e(TAG, String.format(Locale.US, "onDraw (%d)", note.id));

		canvas.save();
		// translate to center of the view
		canvas.translate(canvas.getWidth() / 10, canvas.getHeight() / 2);


		sTitlePaint.setAntiAlias(true);
		sTitlePaint.setColor(randomColors.getColor());
		sTitlePaint.setTextSize(spToPx(20, getContext()));

		// Draw the note title and a random color for show case that item is reDrawing
		canvas.drawText(note.title, 0, 0, sTitlePaint);
		canvas.restore();
	}
}