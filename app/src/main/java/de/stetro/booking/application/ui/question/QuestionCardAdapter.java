package de.stetro.booking.application.ui.question;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.stetro.booking.application.R;
import de.stetro.booking.application.data.Question;

public class QuestionCardAdapter extends BaseAdapter {
    private List<Question> questions;
    private Context context;

    public QuestionCardAdapter(List<Question> questions, Context context) {
        this.questions = questions;
        this.context = context;
    }

    @Override
    public int getCount() {
        return questions.size();
    }

    @Override
    public Object getItem(int i) {
        return questions.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.question_card, viewGroup, false);
        }
        ((TextView) v.findViewById(R.id.question_title)).setText(questions.get(i).getTitle());
        Glide
                .with(context)
                .load(questions.get(i).getUrl())
                .asBitmap()
                .centerCrop()
                .into(((ImageView) v.findViewById(R.id.question_image)));
        return v;
    }


    public void setQuestions(List<Question> questions) {
        this.questions = questions;
        this.notifyDataSetInvalidated();
    }
}
