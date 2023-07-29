package com.example.adpter;

import java.util.List;

import com.example.bean.PersonalBean;
import com.example.personalinformation.PersonalAlterActivity;
import com.example.personalinformation.R;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class PersonalAlterBaseAdapter3 extends BaseAdapter {
	private LayoutInflater layout;
	private List<PersonalBean> array;
	
	MyTextWatcher mytextwatcher;
	MyOnfocusChange myfouce;

	// 使用这个Adapter的context
	private PersonalAlterActivity personalalteractivity;

	public PersonalAlterBaseAdapter3(PersonalAlterActivity per) {
		layout = LayoutInflater.from(per.getBaseContext());
		personalalteractivity = per;
		mytextwatcher = new MyTextWatcher();
		myfouce = new MyOnfocusChange();
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
	public View getView(int position, View convertView, ViewGroup parent) {
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

			viewholder.title.setOnTouchListener(new MyOnTouchLis(1));
			viewholder.context.setOnTouchListener(new MyOnTouchLis(2));
			
			viewholder.title.setOnFocusChangeListener(myfouce);
//			viewholder.context.setOnFocusChangeListener(new MyOnfocusChange(2));

//			viewholder.title.addTextChangedListener(mTextWatcher);
//			viewholder.context.addTextChangedListener(mTextWatcher2);
		} else {
			view = convertView;
			viewholder = (ViewHoler) view.getTag();
		}
		viewholder.title.setTag(position);
		viewholder.context.setTag(position);
		
		viewholder.title.clearFocus();
		viewholder.context.clearFocus();
		if (index != -1 && index == position) {
			viewholder.title.requestFocus();
			index = -1;
        }
		if (index2 != -1 && index2 == position) {
			viewholder.context.requestFocus();
			index2 = -1;
        }
        viewholder.title.removeTextChangedListener(mytextwatcher); 
		PersonalBean per = array.get(position);
		viewholder.title.setText(per.getTitle());
		viewholder.context.setText(per.getContext());
		
		// 添加按钮监听
		viewholder.btalter.setOnClickListener(new MyAlterButtonLis(position));
		viewholder.btdel.setOnClickListener(new MyDelButtonLis(position));
		
		viewholder.title.addTextChangedListener(mytextwatcher); 
		return view;
	}
	class MyTextWatcher implements TextWatcher{
		public int position;
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
//			if(index != -1){
//				array.get(index).setTitle(s.toString());
//			}
		}
		
		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			array.get(position).setTitle(s.toString());
		}
	}
	
	class MyOnTouchLis implements OnTouchListener{
		int state;
		public MyOnTouchLis(int s) {
			state = s;
		}
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			if(event.getAction() == MotionEvent.ACTION_UP){
				if(state == 1){
					index = (Integer)v.getTag();
				}else if(state == 2){
					index2 = (Integer)v.getTag();
				}
			}
			return false;
		}
	}
	class MyOnfocusChange implements OnFocusChangeListener{
		
		int state;
		
		public MyOnfocusChange() {
//			state = s;
		}
		
		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			// TODO Auto-generated method stub
			if(hasFocus){
				int position = (Integer)v.getTag();
				mytextwatcher.position = position;
			}
		}
	}
	class ViewHoler {
		EditText title;
		EditText context;
		Button btalter;
		Button btdel;
	}
	
//	class MyTextWatcher implements TextWatcher {
//		int position;
//		int state;
//		
//		public MyTextWatcher(int pos, int state){
//			position = pos;
//			this.state = state;
//		};
//		@Override
//		public void afterTextChanged(Editable s) {
//			// TODO Auto-generated method stub
//			if(s != null){
//				// 改变list中的这个值, 为了让修改时根据position获取到
//				if(state == 1){
//					array.get(position).setTitle(s.toString());
//				}else if(state == 2){
//					array.get(position).setContext(s.toString());
//				}
//			}
//		}
//
//		@Override
//		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//			// TODO Auto-generated method stub
//			
//		}
//	}
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
	
	// 文本框监听
//	class MyTextWatcher implements TextWatcher {
//		private int state;//是第一个还是第二个
//		
//		private ViewHoler mHolder;
//		public MyTextWatcher(){};
//		public MyTextWatcher(ViewHoler v, int s) {
//			// TODO Auto-generated constructor stub
//			mHolder = v;
//			state = s;
//		}
//
//		@Override
//		public void afterTextChanged(Editable s) {
//			// TODO Auto-generated method stub
//			if(s != null){
//				int position = (Integer)mHolder.title.getTag();
//				// 改变list中的这个值, 为了让修改时根据position获取到
//				if(state == 1){
//					array.get(position).setTitle(s.toString());
//				}else if(state == 2){
//					array.get(position).setContext(s.toString());
//				}
//			}
//		}
//
//		@Override
//		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
//			// TODO Auto-generated method stub
//			
//		}
//	}
}
