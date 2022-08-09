package livewall.basic.view_bind_data_bind_rv;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import livewall.basic.view_bind_data_bind_rv.databinding.RowlayoutSingleItemBinding;


public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final String TAG = MainAdapter.class.getSimpleName();

    private final Context context;
    private final LayoutInflater inflater;

    public List<VisionModel> listdata;

    public int selectedtimezone = -1;

    public RecyclerViewItemClick rvItemClickListener;

    public void setList(List<VisionModel> mainModellist) {
        this.listdata = mainModellist;
    }

    //fav

    public class LayoutOneViewHolder extends RecyclerView.ViewHolder {

        RowlayoutSingleItemBinding rowlayoutSizeSmallBinding;

        public LayoutOneViewHolder(RowlayoutSingleItemBinding rowlayoutSizeSmallBinding) {
            super(rowlayoutSizeSmallBinding.getRoot());
            this.rowlayoutSizeSmallBinding = rowlayoutSizeSmallBinding;
        }
    }


    public MainAdapter(Context c, RecyclerViewItemClick rvItemClickListener) {
        this.context = c;
        this.listdata = new ArrayList<>();
        this.inflater = LayoutInflater.from(this.context);
        this.rvItemClickListener = rvItemClickListener;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        RowlayoutSingleItemBinding v1 = RowlayoutSingleItemBinding.inflate(inflater, parent,
                false);
        viewHolder = new LayoutOneViewHolder(v1);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {

        VisionModel alldataItem = listdata.get(holder.getAdapterPosition());


        LayoutOneViewHolder layoutTwoViewHolder = (LayoutOneViewHolder) holder;

        //set model to - databinding method
        layoutTwoViewHolder.rowlayoutSizeSmallBinding.setVisionmodel(alldataItem);

        layoutTwoViewHolder.rowlayoutSizeSmallBinding.layoutCardRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedtimezone = holder.getAdapterPosition();

                if (rvItemClickListener != null) {
                    rvItemClickListener.onItemClick(alldataItem, holder.getAdapterPosition());
                }
            }
        });

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {

        return listdata.size();

    }


}
