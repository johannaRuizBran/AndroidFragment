package com.example.android.android_me.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class MasterListFragment extends Fragment {

    OnImageClickListener mCallback;
    public interface OnImageClickListener{
        void onImageSelected(int position);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        try{
            mCallback= (OnImageClickListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+" must implement onimageclicklistener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflayer, ViewGroup container, Bundle savedInstanceState){
        View rootView= inflayer.inflate(R.layout.fragment_master_list, container, false);
        final GridView gridview= (GridView)rootView.findViewById(R.id.gridview);
        gridview.setAdapter(new MasterListAdapter(getContext(), AndroidImageAssets.getAll()));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapterView,View view,int position,long l){
                mCallback.onImageSelected(position);
            }
        });
        return rootView;
    }


}