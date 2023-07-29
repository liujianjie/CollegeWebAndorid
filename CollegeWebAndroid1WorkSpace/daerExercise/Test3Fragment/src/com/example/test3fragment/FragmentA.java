package com.example.test3fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentA extends Fragment{
	TextView showtv;
	EditText ed;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_a, container, false);
		showtv = view.findViewById(R.id.a_tv);
		ed = view.findViewById(R.id.a_edit);
		Button bt = view.findViewById(R.id.a_bt);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showtv.setText(ed.getText().toString());
			}
		});
		return view;
	}
}
