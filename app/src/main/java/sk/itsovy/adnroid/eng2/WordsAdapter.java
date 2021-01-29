package sk.itsovy.adnroid.eng2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.selection.SelectionTracker;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WordsViewHolder> {


    private List<Word> cachedWords;
    private OnWordClickListener listener;
    private SelectionTracker<Long> selectionTracker;

    //todo changing here

    /*public WordsAdapter() {
        setHasStableIds(true);
    }*/
    public void setCachedWords(List<Word> cachedWords) {
        this.cachedWords = cachedWords;
        notifyDataSetChanged();   // upozornie na zmenu pre recycleview
    }

    public void setOnWordClickListener(OnWordClickListener listener) {
        this.listener = listener;
    }

    //todo changing here
   /* public void setSelectionTracker(SelectionTracker<Long> selectionTracker) {
        this.selectionTracker = selectionTracker;
    }*/



    
    @NonNull
    @Override
    public WordsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //
        // nafukovanie xml codu
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // nafukny ho 
        View itemLayout = inflater.inflate(R.layout.item_layout, parent, false);
      //  VehiclesAdapter.VehicleViewHolder holder = new VehiclesAdapter.VehicleViewHolder(itemLayout);
        WordsViewHolder holder = new WordsViewHolder(itemLayout);
        //holder.setOnPlateClickListener(listener);
        holder.setOnWordClickListener(listener);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull WordsViewHolder holder, int position) {
        holder.bind(cachedWords.get(position));

    }

    @Override
    public int getItemCount() {
        if (cachedWords == null) {
            return 0;
        }
        return cachedWords.size();
    }


    public static class WordsViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private OnWordClickListener listener;

        public WordsViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textViewPlate);
        }

        public void setOnWordClickListener(OnWordClickListener listener) {
            this.listener = listener;
        }

        public void bind(Word word) {
            textView.setText(word.getNameWord());

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnWordClick(word);
                }
            });
        }


    }

}
