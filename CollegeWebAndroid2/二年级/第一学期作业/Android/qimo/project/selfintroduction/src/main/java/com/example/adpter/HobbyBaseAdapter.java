package com.example.adpter;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.HobbyBean;
import com.example.selfintroduction.HobbyActivity;
import com.example.selfintroduction.HobbyAlterActivity;
import com.example.selfintroduction.R;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class HobbyBaseAdapter extends BaseAdapter {
	private LayoutInflater layout;
	private List<HobbyBean> array;

	// 使用这个Adapter的context
	private HobbyActivity hobbyactivity;

	public HobbyBaseAdapter(HobbyActivity hoby) {
		layout = LayoutInflater.from(hoby.getBaseContext());
		hobbyactivity = hoby;
	}

	public void SetData(List<HobbyBean> a) {
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
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		//View view = null;
		//ViewHoler viewholder = null;
		//if (convertView == null) {
			final View view = layout.inflate(R.layout.hobby_item, null);
			final ViewHoler viewholder = new ViewHoler();
			viewholder.check = (CheckBox) view.findViewById(R.id.hobby_itemradio);
			view.setTag(viewholder);
		//} else {
		//	view = convertView;
		//	viewholder = (ViewHoler) view.getTag();
		//}
		HobbyBean stu = array.get(position);
		viewholder.check.setText(stu.getHobbyname());// int
		
		String checkposiid = stu.getHobbyid()+"";
		// 默认选中自己喜欢的爱好，根据我的爱好数据表的list中的id是否有这个 id
		if(hobbyactivity.myhobbylist.contains(checkposiid)){
			viewholder.check.setChecked(true);
		}
		// 设置不可编辑
		viewholder.check.setEnabled(false);
		return view;
	}
	class ViewHoler {
		CheckBox check;
	}
	
}
