package de.stetro.booking.application.ui.question;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.stetro.booking.application.R;
import de.stetro.booking.application.data.Card;

class QuestionCardAdapter extends BaseAdapter {
    private List<Card> cards = new ArrayList<>();
    private Context context;

    QuestionCardAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Object getItem(int i) {
        return cards.get(i);
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
        ((TextView) v.findViewById(R.id.question_title)).setText(cards.get(i).getDesc());
        Glide
                .with(context)
                .load(cards.get(i).getImageUrl())
                .asBitmap()
                .centerCrop()
                .into(((ImageView) v.findViewById(R.id.question_image)));
        return v;
    }


    void setQuestions(List<Card> cards) {
        this.cards = cards;
        this.notifyDataSetInvalidated();
    }
}
