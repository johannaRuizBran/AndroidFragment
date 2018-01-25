package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    private static final String TAG= "BodyPartFragment";
    private static final String IMAGE_ID_LIST= "image_ids";
    private static final String LIST_INDEX= "list_index";
    private List<Integer> mImageIds;
    private int mListIndex;


    public void setmImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setmListIndex(int mListIndex) {

        this.mListIndex = mListIndex;
    }

    public BodyPartFragment(){

    }

    //En esta seccion lo que hago es insertar la imagen que se localiza en la lista en la posicion x
    //se inserta la imagen en el fragmet_body_part la cual tiene un image view que es donde se
    //va a alojar nuestra imagen
    /*en pocas palabras la imagen que se encuentre en la lista mImageIds en la posiscion mListIndex
    * será la que se inflara en nuestro image view*/
    @Override
    public View onCreateView(LayoutInflater inflayer, ViewGroup container, Bundle savedInstanceState){
        if(savedInstanceState != null){
            mImageIds=savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex= savedInstanceState.getInt(LIST_INDEX);
        }
        View rootView= inflayer.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView= (ImageView)rootView.findViewById(R.id.body_part_imageView);

        if(mImageIds != null){
            imageView.setImageResource(mImageIds.get(mListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListIndex <mImageIds.size()-1){

                        mListIndex++;
                    }
                    else{
                        mListIndex= 0;
                    }
                    imageView.setImageResource(mImageIds.get(mListIndex));
                }
            });
        }
        else {
            Log.v(TAG,"This fragment has a null list of images");
        }
        return rootView;
    }

    //es para que cuendo rotemos la pantalla no se pierda el indice de la imagen en que quedamos
    @Override
    public void onSaveInstanceState(Bundle currentState){
        currentState.putIntegerArrayList(IMAGE_ID_LIST,(ArrayList<Integer>) mImageIds);
        currentState.putInt(LIST_INDEX, mListIndex);
    }
}