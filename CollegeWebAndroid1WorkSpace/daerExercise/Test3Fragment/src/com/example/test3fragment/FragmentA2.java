package com.example.test3fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentA2 extends Fragment{
	TextView showcountv;
	int count = 0;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_a2, container, false);
		showcountv = view.findViewById(R.id.a2_tvshowcount);
		Button bt = view.findViewById(R.id.a2_bt);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showcountv.setText(++count+"");
			}
		});
		return view;
	}
}
