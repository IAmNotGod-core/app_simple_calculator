package com.iamnotgod.calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {

    private ArrayList<Record> listRecord;
    private Context context;

    public RecordAdapter(ArrayList<Record> listRecord) {
        this.listRecord = listRecord;
    }

    @NonNull
    @Override
    public RecordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.record_list, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecordAdapter.ViewHolder holder, int position) {
        Record record = listRecord.get(position);
        holder.number1.setText(record.getNumber1());
        holder.operatorView.setText(record.getOperator());
        holder.number2.setText(record.getNumber2());
        holder.resultView.setText(record.getResult());
    }

    @Override
    public int getItemCount() {
        return listRecord.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView number1, number2, operatorView, resultView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            number1 = (TextView) itemView.findViewById(R.id.number1);
            number2 = (TextView) itemView.findViewById(R.id.number2);
            operatorView = (TextView) itemView.findViewById(R.id.operatorView);
            resultView = (TextView) itemView.findViewById(R.id.resultView);
        }
    }
}
