package com.nepaliapps.daggerandretrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolderForRecycler> {

    private List<Pojo> dataList;
    private Context context;

    public RecyclerAdapter(Context context, List<Pojo> dataList) {

        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolderForRecycler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_holder,null);

        ViewHolderForRecycler holder = new ViewHolderForRecycler(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderForRecycler holder, int position) {

        Pojo item = dataList.get(position);

        holder.textView.setText(item.getTitle());
//
//        Picasso.Builder builder = new Picasso.Builder(context);
//        builder.downloader(new OkHttp3Downloader(context));
//        builder.build().load(dataList.get(position).getThumbnailUrl())
//                .placeholder((R.drawable.ic_launcher_background))
//                .error(R.drawable.ic_launcher_background)
//                .into(holder.imageView);
//        Picasso.get().load(dataList.get(position)
//                     .getThumbnailUrl())
//                     .into(holder.imageView);


       Picasso.get().load(dataList.get(position)
                    .getThumbnailUrl())
                    .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolderForRecycler extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        public ViewHolderForRecycler(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
