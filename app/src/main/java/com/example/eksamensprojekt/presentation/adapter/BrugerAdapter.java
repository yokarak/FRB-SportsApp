package com.example.eksamensprojekt.presentation.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;;

import com.example.eksamensprojekt.R;
import com.example.eksamensprojekt.data.model.Bruger;
import com.example.eksamensprojekt.presentation.view.BeskedActivity;

import java.util.List;

public class BrugerAdapter extends RecyclerView.Adapter<BrugerAdapter.ViewHolder> {
    /**
     * @author Anders, Sebastian og Marc
     * @version 1.2
     */

    private Context mContext;
    private List<Bruger> mBrugere;

    public BrugerAdapter(Context mContext, List<Bruger> mBrugere) {
        this.mBrugere = mBrugere;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.bruger_item, parent, false);
        return new BrugerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { // sætter fornavn på bruger_item skabalonen som implementeres i bruger fragmentet
        final Bruger bruger = mBrugere.get(position);
        holder.fornavn.setText(bruger.getFornavn());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BeskedActivity.class);
                intent.putExtra("brugerid", bruger.getId()); // gemmer brugerid'en for den bruger man klikker på som en slags extra data som sendes med hen til activitien
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBrugere.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView fornavn;
        ImageView profile_billede;

         ViewHolder(View itemView) {
            super(itemView);

            fornavn = itemView.findViewById(R.id.fornavn);
            profile_billede = itemView.findViewById(R.id.profile_billede);
        }
    }
}