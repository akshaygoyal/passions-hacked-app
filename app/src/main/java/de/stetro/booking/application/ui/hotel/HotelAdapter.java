package de.stetro.booking.application.ui.hotel;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.stetro.booking.application.R;
import de.stetro.booking.application.data.Hotel;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {

    private List<Hotel> hotels = new ArrayList<>();
    private HotelPresenter presenter;
    private HotelActivity hotelActivity;

    public HotelAdapter() {

    }

    public HotelAdapter(HotelPresenter hotelPresenter, HotelActivity hotelActivity) {
        this.presenter = hotelPresenter;
        this.hotelActivity = hotelActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.hotel_list_item, null);
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

    public void setHotels(List<Hotel> hotels) {
        this.hotels.clear();
        this.hotels.addAll(hotels);
    }

    public void setPresenter(HotelPresenter presenter) {
        this.presenter = presenter;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.hotel_name)
        TextView hotelName;
        private int position;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void setData(Hotel hotel, int position) {
            this.position = position;
            hotelName.setText(hotel.getName());
        }

        @Override
        public void onClick(View view) {
            presenter.selectHotel(position);

        }
    }
}
