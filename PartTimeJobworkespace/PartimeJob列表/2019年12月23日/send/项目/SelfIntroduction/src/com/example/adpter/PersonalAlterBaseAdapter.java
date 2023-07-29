package com.example.adpter;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.HobbyBean;
import com.example.bean.PersonalBean;
import com.example.selfintroduction.HobbyAlterActivity;
import com.example.selfintroduction.PersonalAlterActivity;
import com.example.selfintroduction.R;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalAlterBaseAdapter extends BaseAdapter {
	private LayoutInflater layout;
	private List<PersonalBean> array;

	// ʹ�����Adapter��context
	private PersonalAlterActivity personalalteractivity;

	public PersonalAlterBaseAdapter(PersonalAlterActivity per) {
		layout = LayoutInflater.from(per.getBaseContext());
		personalalteractivity = per;
	}

	public void SetData(List<PersonalBean> a) {
		array = a;
	}

	@Override
	public int getCount() {
		// TODO �Զ����ɵķ������
		if (array == null) {
			return 0;
		}
		return array.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO �Զ����ɵķ������
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO �Զ����ɵķ������
		return 0;
	}
	// ��final�Ļ� ���� ����
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View view = null;
//		viewholder = null;
//		if (convertView == null) {
			view = layout.inflate(R.layout.personalalter_item, null);
			final ViewHoler viewholder = new ViewHoler();
			viewholder.title = (EditText) view.findViewById(R.id.personalalter_itemtitle);
			viewholder.context = (EditText) view.findViewById(R.id.personalalter_itemcontext);
			viewholder.btalter = (Button) view.findViewById(R.id.personalalter_itembtalter);
			viewholder.btdel = (Button) view.findViewById(R.id.personalalter_itembtdel);
			view.setTag(viewholder);
//		} else {
//			view = convertView;
//			viewholder = (ViewHoler) view.getTag();
//		}
		PersonalBean per = array.get(position);
		viewholder.title.setText(per.getTitle());
		viewholder.context.setText(per.getContext());
		// ��Ӱ�ť����
		viewholder.btalter.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				String title = viewholder.title.getText().toString();
				String context = viewholder.context.getText().toString();
				// ����perid�޸����ݿ���Ϣ
				personalalteractivity.PersonalAlter(position,title, context);
				
			}
		});
		// ɾ��
		viewholder.btdel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Log.i("check", "btdel���");
				// ɾ��
				personalalteractivity.PersonalDelete(position);
			}
		});
		return view;
	}
	class ViewHoler {
		EditText title;
		EditText context;
		Button btalter;
		Button btdel;
		
	}
}
