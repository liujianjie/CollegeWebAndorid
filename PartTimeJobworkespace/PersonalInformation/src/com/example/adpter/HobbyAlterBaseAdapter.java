package com.example.adpter;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.HobbyBean;
import com.example.personalinformation.HobbyAlterActivity;
import com.example.personalinformation.R;

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

public class HobbyAlterBaseAdapter extends BaseAdapter {
	private LayoutInflater layout;
	private List<HobbyBean> array;

	// ʹ�����Adapter��context
	private HobbyAlterActivity hobbyalteractivity;
	

	public HobbyAlterBaseAdapter(HobbyAlterActivity hoby) {
		layout = LayoutInflater.from(hoby.getBaseContext());
		hobbyalteractivity = hoby;
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
	String hobbyid = "0";
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		ViewHoler viewholder = null;
		if (convertView == null) {
			view = layout.inflate(R.layout.hobby_alteritem, null);
			viewholder = new ViewHoler();
			viewholder.check = (CheckBox) view.findViewById(R.id.hobbyalter_itemradio);
			viewholder.btdel = (Button) view.findViewById(R.id.hobbyalter_itembtdel);
			view.setTag(viewholder);
		} else {
			view = convertView;
			viewholder = (ViewHoler) view.getTag();
		}
		HobbyBean stu = array.get(position);
		viewholder.check.setText(stu.getHobbyname());// int

		String checkposiid = stu.getHobbyid()+"";
		// Ĭ��ѡ���Լ�ϲ���İ��ã������ҵİ������ݱ��list�е�id�Ƿ������ id
		if(hobbyalteractivity.alterselfhobbylist.contains(checkposiid)){
			viewholder.check.setChecked(true);
		}else{
			viewholder.check.setChecked(false);// Ϊ�˸���
		}
		
		// ��Ӽ���
		// ��ѡ��
		viewholder.check.setOnClickListener(new MyCheckLis(position));
		viewholder.btdel.setOnClickListener(new MyDelButtonLis(position));
		return view;
	}
	class ViewHoler {
		CheckBox check;
		Button btdel;
	}
	// �Զ������
	// ɾ��
	class MyDelButtonLis implements OnClickListener{
		int position;
		public MyDelButtonLis(int pos) {
			// TODO Auto-generated constructor stub
			position = pos;
		}
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Log.i("check", "btdel���");
//			// ɾ��������listview
			hobbyalteractivity.HobbyNameDelete(position);// ����λ��
		}
	}
	// �����ѡ��
	class MyCheckLis implements OnClickListener{
		int position;
		public MyCheckLis(int pos) {
			// TODO Auto-generated constructor stub
			position = pos;
		}
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			HobbyBean stus = array.get(position);
			hobbyid = stus.getHobbyid()+"";
			Log.i("check", "hobbyid:"+hobbyid);
			
			CheckBox ch = (CheckBox)v;
			// �����ѡ���
			if(ch.isChecked()){
				if(!hobbyalteractivity.alterselfhobbylist.contains(hobbyid)){
					hobbyalteractivity.alterselfhobbylist.add(hobbyid);
				}	
			}else{
				if(hobbyalteractivity.alterselfhobbylist.contains(hobbyid)){
					hobbyalteractivity.alterselfhobbylist.remove(hobbyid);
					Log.i("check", "ɾ������:"+hobbyid);
				}	
			}
		}
	}
}
