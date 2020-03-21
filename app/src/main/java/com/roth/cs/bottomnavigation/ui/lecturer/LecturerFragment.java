package com.roth.cs.bottomnavigation.ui.lecturer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.roth.cs.bottomnavigation.LecturerModel.LecturerModel;
import com.roth.cs.bottomnavigation.LecturerAdapter.LecturerAdapter;

import com.roth.cs.bottomnavigation.R;

import java.util.ArrayList;

public class LecturerFragment extends Fragment {
    RecyclerView lecturerItem;
    ArrayList<LecturerModel> arrayList;
    LecturerAdapter lecturerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_lecturer, container, false);

        lecturerItem = rootView.findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
        for(int i=0 ; i<9 ; i++){
            LecturerModel model = new LecturerModel();
            model.setUrl("https://img.mobilelegends.com/group1/M00/00/9B/Cq2Ixl329aaAeEcaAAsWyfGP-dM608.jpg");
            model.setLecturerName("Keo Saly");
            model.setMajor("Computer Science");
            model.setJobTitle("Mobile Dev");
            arrayList.add(model);
        }
        lecturerItem.setLayoutManager(new GridLayoutManager(getContext(),3));
        lecturerAdapter = new LecturerAdapter(container.getContext(), arrayList);
        lecturerItem.setAdapter(lecturerAdapter);

        return rootView;
    }
}
