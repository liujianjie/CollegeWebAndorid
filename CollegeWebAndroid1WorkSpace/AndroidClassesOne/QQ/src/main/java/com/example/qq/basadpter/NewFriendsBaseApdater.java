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

//这个是添加好友的查询列表
public class NewFriendsBaseApdater extends BaseAdapter{

	private LayoutInflater layout;
	private Context con;
	NewFriendActivity newhyactivity;
	private AndroidQqUser qquser = Applications.getqquser();
	//列表
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
		// TODO 自动生成的方法存根
		if(newhylist!=null){
			return newhylist.size();
		}else{
			return 0;
		}
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
		//个体
		AndroidQqHy hyuser = newhylist.get(position);
		//此时 我在好友表中为 好友对象 所以要获取我 这个对象
		//头像
		if(qquser.getQqZhanghao().equals(hyuser.getMyqqZhanghao())){
			Picasso.with(con).load(URI_IP.URI+"Android_Service/image/"+hyuser.getHyqqZhanghao()+"").into(viewholder.newfriendsitem_iv_touxiang);
		}else{
			Picasso.with(con).load(URI_IP.URI+"Android_Service/image/"+hyuser.getMyqqTouxiang()+"").into(viewholder.newfriendsitem_iv_touxiang);
		}
		//昵称
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
		//个性签名
		viewholder.newfriendsitem_tv2_mark.setText(hyuser.getMyqqMark());
		
		viewholder.newfriendsitem_btn_agreen.setTag(position);
		
		//点击同意了 修改状态 等还要有一个选择分组的 和 备注。。。，这条信息也不存在了，没有缓存数据
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
