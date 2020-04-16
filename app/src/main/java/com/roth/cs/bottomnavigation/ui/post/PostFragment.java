package com.roth.cs.bottomnavigation.ui.post;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.roth.cs.bottomnavigation.R;
import com.roth.cs.bottomnavigation.postAdapter.PostAdapter;
import com.roth.cs.bottomnavigation.postModel.PostModel;
import com.roth.cs.bottomnavigation.ui.lecturer.LecturerFragment;

import java.util.ArrayList;

public class PostFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<PostModel> arrayList;
    PostAdapter postAdapter;
    LinearLayout post_caption;
    ImageView btn_submit_comment;
    EditText write_comment;
    StorageReference storageReference;
    DatabaseReference databaseReference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_post, container,false);

        recyclerView = rootView.findViewById(R.id.recyclerview_post);
        arrayList = new ArrayList<PostModel>();
        post_caption = rootView.findViewById(R.id.text_post);
        btn_submit_comment=rootView.findViewById(R.id.btn_submit_comment);
        write_comment = rootView.findViewById(R.id.text_comment);


        /*for(int i=0; i<2 ; i++) {
            PostModel model = new PostModel();
            model.setProfile("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Oryctolagus_cuniculus_Rcdo.jpg/1200px-Oryctolagus_cuniculus_Rcdo.jpg");
            model.setImageURL("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Oryctolagus_cuniculus_Rcdo.jpg/1200px-Oryctolagus_cuniculus_Rcdo.jpg");
            model.setProfile_comment("https://shawglobalnews.files.wordpress.com/2019/05/rabbit1.jpg?quality=70&strip=all&w=720");
            model.setUser_name("Rabbita");
            model.setTime("Just now");
            model.setImageName("Hello");
            model.setText_comment("lol");
            arrayList.add(model);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        postAdapter = new PostAdapter(container.getContext(),arrayList);
        recyclerView.setAdapter(postAdapter);*/
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        recyclerView.setHasFixedSize(true);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();
        getData();
        post_caption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Post.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
    private void getData() {
        clearAll();
        Query query = databaseReference.child("Images");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    PostModel model = new PostModel();
                    model.setProfile(dataSnapshot1.child("imageURL").getValue().toString());
                    model.setComment(dataSnapshot1.child("imageName").getValue().toString());
                    model.setImageURL(dataSnapshot1.child("imageURL").getValue().toString());
                    model.setImageName(dataSnapshot1.child("imageName").getValue().toString());
                    model.setProfile_comment(dataSnapshot1.child("imageURL").getValue().toString());
                    arrayList.add(model);
                }
                postAdapter = new PostAdapter(getActivity(),arrayList);
                recyclerView.setAdapter(postAdapter);
                postAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void clearAll(){
        if(arrayList != null){
            arrayList.clear();
            if(postAdapter != null){
                postAdapter.notifyDataSetChanged();
            }
        }
        arrayList = new ArrayList<>();
    }
}
