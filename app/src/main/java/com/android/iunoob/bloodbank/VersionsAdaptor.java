package com.android.iunoob.bloodbank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VersionsAdaptor extends RecyclerView.Adapter<VersionsAdaptor.VersionVH> {

    List<FirstQuestion> firstQuestions;

    public VersionsAdaptor(List<FirstQuestion> firstQuestions) {
        this.firstQuestions = firstQuestions;

    }

    @NonNull
    @Override
    public VersionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);

        return new VersionVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VersionVH holder, int position) {

            FirstQuestion firstQuestion = firstQuestions.get(position);
            holder.Question.setText(firstQuestion.getFirstuestion());
            holder.desc.setText(firstQuestion.getDesc());

            boolean isExpandable = firstQuestions.get(position).isExpandable();
            holder.relativeLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);



    }

    @Override
    public int getItemCount() {
        return firstQuestions.size();
    }

    public class VersionVH extends RecyclerView.ViewHolder {

        TextView Question,desc;
        LinearLayout linearLayout;
        RelativeLayout relativeLayout;


        public VersionVH(@NonNull View itemView) {
            super(itemView);

            Question = itemView.findViewById(R.id.fq);
            desc = itemView.findViewById(R.id.fd);

            linearLayout = itemView.findViewById(R.id.linear_layout);
            relativeLayout = itemView.findViewById(R.id.ex_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    FirstQuestion firstQuestion = firstQuestions.get(getAdapterPosition());
                     firstQuestion.setExpandable(!firstQuestion.isExpandable());
                     notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
