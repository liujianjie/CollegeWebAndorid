package com.example.adpter;

import java.util.List;

import com.example.bean.PersonalBean;
import com.example.personalinformation.PersonalAlterActivity;
import com.example.personalinformation.R;

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
import android.widget.TextView;

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
	int index = -1;
	int index2 = -1;

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final PersonalBean per = array.get(position);
		View view = null;
		ViewHoler viewholder = null;
		if (convertView == null) {
			
			view = layout.inflate(R.layout.personalalter_item, null);
			viewholder = new ViewHoler();
			viewholder.title = (EditText) view.findViewById(R.id.personalalter_itemtitle);
			viewholder.context = (EditText) view.findViewById(R.id.personalalter_itemcontext);
			viewholder.btalter = (Button) view.findViewById(R.id.personalalter_itembtalter);
			viewholder.btdel = (Button) view.findViewById(R.id.personalalter_itembtdel);
			view.setTag(viewholder);
		} else {
			view = convertView;
			viewholder = (ViewHoler) view.getTag();
		}
		viewholder.title.clearFocus();
		viewholder.context.clearFocus();
		
		if(viewholder.title.getTag() instanceof TextWatcher){
			viewholder.title.removeTextChangedListener((TextWatcher)viewholder.title.getTag());
		}
		if(viewholder.context.getTag() instanceof TextWatcher){
			viewholder.context.removeTextChangedListener((TextWatcher)viewholder.context.getTag());
		}
		
		viewholder.title.setText(per.getTitle());
		viewholder.context.setText(per.getContext());
		
		// 添加按钮监听
		viewholder.btalter.setOnClickListener(new MyAlterButtonLis(position));
		viewholder.btdel.setOnClickListener(new MyDelButtonLis(position));
		
		final TextWatcher oneTitleWatcher = new SimpeTextWatcher(){
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if(s == null){
					per.setTitle("");
				}else{
					per.setTitle(String.valueOf(s));
					array.get(position).setTitle(per.getTitle());
				}
			}
		};
		final TextWatcher oneContextWatcher = new SimpeTextWatcher(){
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				if(s == null){
					per.setContext("");
				}else{
					per.setContext(String.valueOf(s));
					array.get(position).setTitle(per.getContext());
				}
			}
		};
		viewholder.title.addTextChangedListener(oneTitleWatcher);
		viewholder.title.setTag(oneTitleWatcher);
		
		viewholder.context.addTextChangedListener(oneContextWatcher);
		viewholder.context.setTag(oneContextWatcher);
		return view;
	}
	public abstract class SimpeTextWatcher implements TextWatcher{
		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			
		}
	}
	class ViewHoler {
		EditText title;
		EditText context;
		Button btalter;
		Button btdel;
	}
	
	class MyTextWatcher implements TextWatcher {
		int position;
		int state;
		
		public MyTextWatcher(int pos, int state){
			position = pos;
			this.state = state;
		};
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			if(s != null){
				// 改变list中的这个值, 为了让修改时根据position获取到
				if(state == 1){
					array.get(position).setTitle(s.toString());
				}else if(state == 2){
					array.get(position).setContext(s.toString());
				}
			}
		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			
		}
	}
	// 自定义监听
	// 删除
	class MyDelButtonLis implements OnClickListener{
		int position;
		public MyDelButtonLis(int pos) {
			// TODO Auto-generated constructor stub
			position = pos;
		}
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Log.i("check", "btdel点击");
			// 删除
			personalalteractivity.PersonalDelete(position);
		}
	}
	// 点击修改
	class MyAlterButtonLis implements OnClickListener{
		int position;
		public MyAlterButtonLis(int pos) {
			// TODO Auto-generated constructor stub
			position = pos;
		}
		@Override
		public void onClick(View v) {
			// 读取文本
			PersonalBean per = array.get(position);
//			// 根据perid修改数据库信息
			personalalteractivity.PersonalAlter(position, per.getTitle(),per.getContext());
		}
	}
}
