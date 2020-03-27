package com.roth.cs.bottomnavigation.ui.lecturer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.roth.cs.bottomnavigation.LecturerModel.LecturerModel;
import com.roth.cs.bottomnavigation.LecturerAdapter.LecturerAdapter;

import com.roth.cs.bottomnavigation.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class LecturerFragment extends Fragment {
    RecyclerView lecturerItem;
    SearchView searchView;
    ArrayList<LecturerModel> arrayList;
    LecturerAdapter lecturerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.fragment_lecturer, container, false);



        /*searchView = (SearchView) rootView.findViewById(R.id.SearchView);
        searchView.setQueryHint("Search Lecturer");*/

        lecturerItem = rootView.findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();
        /*for(int i=0 ; i<9 ; i++){
            LecturerModel model = new LecturerModel();
            model.setUrl("https://img.mobilelegends.com/group1/M00/00/9B/Cq2Ixl329aaAeEcaAAsWyfGP-dM608.jpg");
            model.setLecturerName("Keo Saly");
            model.setMajor("Computer Science");
            model.setJobTitle("Mobile Dev");
            arrayList.add(model);
        }*/
        LecturerModel model0 = new LecturerModel();
        model0.setUrl("https://img.mobilelegends.com/group1/M00/00/9B/Cq2Ixl329aaAeEcaAAsWyfGP-dM608.jpg");
        model0.setLecturerName("Keo Saly");
        model0.setMajor("Computer Science");
        model0.setJobTitle("Mobile Dev");

        LecturerModel model1 = new LecturerModel();
        model1.setUrl("https://img.mobilelegends.com/group1/M00/00/9A/Cq2Ixl3fhVaAZ3IDAA9cR9e97Z8737.jpg");
        model1.setLecturerName("Kong Kanika");
        model1.setMajor("Computer Science");
        model1.setJobTitle("OS");

        LecturerModel model2 = new LecturerModel();
        model2.setUrl("https://img.mobilelegends.com/group1/M00/00/93/Cq2Ixl2JvvmAIdwuAAggkLXHiDE391.jpg");
        model2.setLecturerName("Chan Reaksmey");
        model2.setMajor("Computer Science");
        model2.setJobTitle("Web Dev");

        LecturerModel model3 = new LecturerModel();
        model3.setUrl("https://img.mobilelegends.com/group1/M00/00/8F/Cq2Ixl1D2jqANXPVAAnUfurMNtI070.jpg");
        model3.setLecturerName("Bou Channa");
        model3.setMajor("Algorithm");
        model3.setJobTitle("C++");

        LecturerModel model4 = new LecturerModel();
        model4.setUrl("https://img.mobilelegends.com/group1/M00/00/9B/Cq2Ixl329aaAeEcaAAsWyfGP-dM608.jpg");
        model4.setLecturerName("Khem Puthea");
        model4.setMajor("Computer Science");
        model4.setJobTitle("Web Dev");

        LecturerModel model5 = new LecturerModel();
        model5.setUrl("https://img.mobilelegends.com/group1/M00/00/8F/Cq2Ixl1D2jqAZQAdAAkgdCMxNtQ328.jpg");
        model5.setLecturerName("Heng Lalin");
        model5.setMajor("Computer Science");
        model5.setJobTitle("Network Dev");

        LecturerModel model6 = new LecturerModel();
        model6.setUrl("https://img.mobilelegends.com/group1/M00/00/8B/Cq2Ixlz-JVaABX1bAAfzL4qggr0748.jpg");
        model6.setLecturerName("Chip Sokear");
        model6.setMajor("Computer Science");
        model6.setJobTitle("Database Dev");

        LecturerModel model7 = new LecturerModel();
        model7.setUrl("https://img.mobilelegends.com/group1/M00/00/8A/Cq2Ixlz-JTWAK7rpAAhGhQ-YHTo897.jpg");
        model7.setLecturerName("Try Pitou");
        model7.setMajor("Computer Science");
        model7.setJobTitle("Java Dev");

        LecturerModel model8 = new LecturerModel();
        model8.setUrl("https://img.mobilelegends.com/group1/M00/00/8B/Cq2Ixlz-JVaAce3TAAfQBOYQwD8574.jpg");
        model8.setLecturerName("Tal Tongsreng");
        model8.setMajor("Computer Science");
        model8.setJobTitle("Software engineering");


        arrayList.add(model0);
        arrayList.add(model1);
        arrayList.add(model2);
        arrayList.add(model3);
        arrayList.add(model4);
        arrayList.add(model5);
        arrayList.add(model6);
        arrayList.add(model7);
        arrayList.add(model8);


        lecturerItem.setLayoutManager(new GridLayoutManager(getContext(),3));
        lecturerAdapter = new LecturerAdapter(container.getContext(), arrayList);
        lecturerItem.setAdapter(lecturerAdapter);

        /* search */
        SearchView searchView = rootView.findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                lecturerAdapter.getFilter().filter(newText);
                return false;
            }
        });
        /* end search */

        return rootView;
    }


}
