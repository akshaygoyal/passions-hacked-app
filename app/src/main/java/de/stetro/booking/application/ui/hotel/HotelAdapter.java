package de.stetro.booking.application.ui.hotel;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.stetro.booking.application.R;
import de.stetro.booking.application.data.Hotel;

class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {

    private List<Hotel> hotels = new ArrayList<>();
    private HotelPresenter presenter;
    private HotelActivity hotelActivity;

    HotelAdapter(HotelPresenter hotelPresenter, HotelActivity hotelActivity) {
        this.presenter = hotelPresenter;
        this.hotelActivity = hotelActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.hotel_list_item, parent, false);
        return new ViewHolder(itemLayoutView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(hotels.get(position), position);
    }

    @Override
    public int getItemCount() {
        return hotels.size();
    }

    void setHotels(List<Hotel> hotels) {
        this.hotels.clear();
        this.hotels.addAll(hotels);
    }

    public void setPresenter(HotelPresenter presenter) {
        this.presenter = presenter;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.hotel_name)
        TextView hotelName;

        @BindView(R.id.hotel_location)
        TextView hotelLocation;

        @BindView(R.id.hotel_rating)
        TextView hotelRating;

        @BindView(R.id.hotel_stars)
        RatingBar hotelStars;

        @BindView(R.id.hotel_image)
        ImageView hotelImage;

        private int position;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void setData(Hotel hotel, int position) {
            this.position = position;
            hotelName.setText(hotel.getName());
            hotelLocation.setText(hotel.getLocation());
            hotelRating.setText(hotel.getRating());
            hotelStars.setRating(hotel.getStars());
            Glide
                    .with(hotelActivity)
                    .load(hotel.getImageUrl())
                    .asBitmap()
                    .centerCrop()
                    .into(hotelImage);
        }

        @Override
        public void onClick(View view) {
            presenter.selectHotel(position);
        }
    }
}
