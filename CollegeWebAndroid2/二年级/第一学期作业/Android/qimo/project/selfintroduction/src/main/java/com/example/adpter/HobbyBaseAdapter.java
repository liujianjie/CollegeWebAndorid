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

	// ʹ�����Adapter��context
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
		// Ĭ��ѡ���Լ�ϲ���İ��ã������ҵİ������ݱ��list�е�id�Ƿ������ id
		if(hobbyactivity.myhobbylist.contains(checkposiid)){
			viewholder.check.setChecked(true);
		}
		// ���ò��ɱ༭
		viewholder.check.setEnabled(false);
		return view;
	}
	class ViewHoler {
		CheckBox check;
	}
	
}
