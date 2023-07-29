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

	// 使用这个Adapter的context
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
		// TODO 自动生成的方法存根
		if (array == null) {
			return 0;
		}
		return array.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO 自动生成的方法存根
		return 0;
	}
	// 不final的话 复用 难受
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
		// 添加按钮监听
		viewholder.btalter.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				String title = viewholder.title.getText().toString();
				String context = viewholder.context.getText().toString();
				// 根据perid修改数据库信息
				personalalteractivity.PersonalAlter(position,title, context);
				
			}
		});
		// 删除
		viewholder.btdel.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Log.i("check", "btdel点击");
				// 删除
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
