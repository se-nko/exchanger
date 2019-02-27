package android.exchanger.exchanger_android_client;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFragment extends Fragment {

    private int pageNumber;

    public static MainFragment newInstance(int page) {
        MainFragment fragment = new MainFragment();
        Bundle args=new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    static String getTitle(Context context, int position) {
        if(position == 0){
            return  "Banks list";
        }
        if(position == 1){
            return  "The best exchange";
        }
        return "undefined";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = null;

        if(pageNumber == 0){
            result = inflater.inflate(R.layout.activity_banks_list, container, false);
        }
        if(pageNumber == 1){
            result = inflater.inflate(R.layout.activity_best, container, false);
        }

        return result;
    }
}
