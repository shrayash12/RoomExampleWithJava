package shradha.com.roomexamplewithjava.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import shradha.com.roomexamplewithjava.R;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder> {
    ArrayList<Student> studentArrayList;

    public StudentListAdapter(ArrayList<Student> students) {
        this.studentArrayList = students;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_item_list, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.tvStudentName.setText(studentArrayList.get(position).name);
        holder.tvStudentLastName.setText(String.format("%s", studentArrayList.get(position).lastName));
        holder.tvStudentAddress.setText(studentArrayList.get(position).address);
        holder.tvStudentMarks.setText(String.format("%s", studentArrayList.get(position).marks));
    }

    @Override
    public int getItemCount() {
        return studentArrayList.size();
    }

    static class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView tvStudentName;
        TextView tvStudentLastName;
        TextView tvStudentAddress;
        TextView tvStudentMarks;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            findViews();
        }

        private void findViews() {
            tvStudentName = itemView.findViewById(R.id.tvStudentName);
            tvStudentLastName = itemView.findViewById(R.id.tvStudentLastName);
            tvStudentAddress = itemView.findViewById(R.id.tvStudentAddress);
            tvStudentMarks = itemView.findViewById(R.id.tvStudentMarks);
        }
    }
}