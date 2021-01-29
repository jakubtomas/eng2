package sk.itsovy.adnroid.eng2;

import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.widget.RecyclerView;

public class VehiclesLookup extends ItemDetailsLookup<Long> {

    private RecyclerView recyclerView;

    public VehiclesLookup(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Nullable
    @Override
    public ItemDetails<Long> getItemDetails(@NonNull MotionEvent event) {
        View view = recyclerView.findChildViewUnder(event.getX(), event.getY());
        if (view == null) {
            return null;
        }
        RecyclerView.ViewHolder viewHolder = recyclerView.getChildViewHolder(view);
        return new VehicleItemDetails(viewHolder);
    }

    private static class VehicleItemDetails extends ItemDetails<Long> {

        private RecyclerView.ViewHolder viewHolder;

        public VehicleItemDetails(RecyclerView.ViewHolder viewHolder) {
            this.viewHolder = viewHolder;
        }

        @Override
        public int getPosition() {
            return viewHolder.getAdapterPosition();
        }

        @Nullable
        @Override
        public Long getSelectionKey() {
            return viewHolder.getItemId();
        }
    }
}
