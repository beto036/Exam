package com.example.admin.w6d2exam;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.w6d2exam.model.Result;
import com.example.admin.w6d2exam.model.ResultApi;

import java.util.ArrayList;

/**
 * Created by admin on 10/28/2016.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

    private static final String TAG = "AdapterTAG_";
    private ArrayList<Result> mArrayList;

    public UserAdapter(ArrayList<Result> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View termView = inflater.inflate(R.layout.recycler_item, parent, false);

        return new UserAdapter.ViewHolder(termView);
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        Result result = mArrayList.get(position);

        Log.d(TAG, "onBindViewHolder: " + result);

        TextView textViewName = holder.textViewName;
        textViewName.setText(result.getName().getFirst());
        holder.result = result;
        holder.position = position;
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "UserAdapterTAG_";
        public final TextView textViewName;
        public Result result;
        public int position;

        public ViewHolder(final View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.r_item_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
    }
}
