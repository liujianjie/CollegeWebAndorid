package com.example.qq.basadpter;

import java.util.List;

import org.apache.http.message.ParserCursor;

import com.example.qq.Applications;
import com.example.qq.NewFriendActivity;
import com.example.qq.R;
import com.example.qq.SelHaoYouActivity;
import com.example.qq.XiangQingFriendActivity;
import com.example.qq.bean.AndroidQqHy;
import com.example.qq.bean.AndroidQqUser;
import com.example.qq.constant.URI_IP;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//�������Ӻ��ѵĲ�ѯ�б�
public class NewFriendsBaseApdater extends BaseAdapter{

	private LayoutInflater layout;
	private Context con;
	NewFriendActivity newhyactivity;
	private AndroidQqUser qquser = Applications.getqquser();
	//�б�
	private List<AndroidQqHy> newhylist;
	
	public NewFriendsBaseApdater(Context cont) {
		this.layout=LayoutInflater.from(cont);
		this.con=con;
	}
	public void setDate(NewFriendActivity newhyactivity,List<AndroidQqHy> newhylist){
		this.newhyactivity = newhyactivity;
		this.newhylist=newhylist;
	}
	
	@Override
	public int getCount() {
		// TODO �Զ����ɵķ������
		if(newhylist!=null){
			return newhylist.size();
		}else{
			return 0;
		}
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
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		ViewHolder viewholder=null; 
		if(convertView==null){
			viewholder=new ViewHolder();
			view = layout.inflate(R.layout.activity_newfriendsitem, null);
			viewholder.newfriendsitem_iv_touxiang = (ImageView) view.findViewById(R.id.newfriendsitem_iv_touxiang);
			viewholder.newfriendsitem_tv_name = (TextView) view.findViewById(R.id.newfriendsitem_tv_name);
			viewholder.newfriendsitem_tv2_mark = (TextView) view.findViewById(R.id.newfriendsitem_tv2_mark);
			viewholder.newfriendsitem_btn_agreen = (Button) view.findViewById(R.id.newfriendsitem_btn_agreen);
			view.setTag(viewholder);
		}else{
			view = convertView;
			viewholder = (ViewHolder) view.getTag();
		}
		//����
		AndroidQqHy hyuser = newhylist.get(position);
		//��ʱ ���ں��ѱ���Ϊ ���Ѷ��� ����Ҫ��ȡ�� �������
		//ͷ��
		if(qquser.getQqZhanghao().equals(hyuser.getMyqqZhanghao())){
			Picasso.with(con).load(URI_IP.URI+"Android_Service/image/"+hyuser.getHyqqZhanghao()+"").into(viewholder.newfriendsitem_iv_touxiang);
		}else{
			Picasso.with(con).load(URI_IP.URI+"Android_Service/image/"+hyuser.getMyqqTouxiang()+"").into(viewholder.newfriendsitem_iv_touxiang);
		}
		//�ǳ�
		viewholder.newfriendsitem_tv_name.setText(hyuser.getMyqqName());
		viewholder.newfriendsitem_tv_name.setTag(position);
		viewholder.newfriendsitem_tv_name.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(newhyactivity,XiangQingFriendActivity.class);
				intent.putExtra("flag", (Integer)v.getTag());
				newhyactivity.startActivity(intent);
			}
		});
		//����ǩ��
		viewholder.newfriendsitem_tv2_mark.setText(hyuser.getMyqqMark());
		
		viewholder.newfriendsitem_btn_agreen.setTag(position);
		
		//���ͬ���� �޸�״̬ �Ȼ�Ҫ��һ��ѡ������ �� ��ע��������������ϢҲ�������ˣ�û�л�������
		viewholder.newfriendsitem_btn_agreen.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int id=(Integer)v.getTag();
				AndroidQqHy hyuser = newhylist.get(id);
				newhyactivity.agree(hyuser.getHyId(),id);
			}
		});

		
		return view;
		
	}
	public class ViewHolder{
		ImageView newfriendsitem_iv_touxiang;
		TextView newfriendsitem_tv_name;
		TextView newfriendsitem_tv2_mark;
		Button newfriendsitem_btn_agreen;
	}
}
