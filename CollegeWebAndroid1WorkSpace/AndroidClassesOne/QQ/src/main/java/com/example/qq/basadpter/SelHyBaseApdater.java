package com.example.qq.basadpter;

import java.util.List;

import org.apache.http.message.ParserCursor;

import com.example.qq.Applications;
import com.example.qq.R;
import com.example.qq.SelHaoYouActivity;
import com.example.qq.bean.AndroidQqHy;
import com.example.qq.bean.AndroidQqUser;
import com.example.qq.constant.URI_IP;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//这个是添加好友的查询列表
public class SelHyBaseApdater extends BaseAdapter{

	private LayoutInflater layout;
	private List<AndroidQqUser> userlist;
	private Context con;
	AndroidQqUser qquser;
	ViewHolder viewholder= null;
	public SelHyBaseApdater(Context cont) {
		this.layout=LayoutInflater.from(cont);
		this.con=con;
	}
	public void setDate(List<AndroidQqUser> userlist){
		this.userlist=userlist;
	}
	
	@Override
	public int getCount() {
		// TODO 自动生成的方法存根
		if(userlist!=null){
			return userlist.size();
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
		if(convertView==null){
			viewholder=new ViewHolder();
			view = layout.inflate(R.layout.activity_selhaoyouitem, null);
			viewholder.selhyitem_ig1 = (ImageView) view.findViewById(R.id.selhyitem_ig1);
			viewholder.selhyitem_tv1 = (TextView) view.findViewById(R.id.selhyitem_tv1);
			viewholder.selhyitem_ig2 = (TextView) view.findViewById(R.id.selhyitem_ig2);
			viewholder.selhyitem_tv2 = (TextView) view.findViewById(R.id.selhyitem_tv2);
			view.setTag(viewholder);
		}else{
			view = convertView;
			viewholder = (ViewHolder) view.getTag();
		}
		qquser = userlist.get(position);
		//头像
		Picasso.with(con).load(URI_IP.URI+"Android_Service/image/"+qquser.getQqTouxiang()+"").placeholder(R.drawable.touxiang).into(viewholder.selhyitem_ig1);
		//昵称和账号
		viewholder.selhyitem_tv1.setText(qquser.getQqName()+"("+qquser.getQqZhanghao()+")");
		//性别
		viewholder.selhyitem_ig2.setText(qquser.getQqSex());
		//地址
		viewholder.selhyitem_tv2.setText(qquser.getQqAddress());

		return view;
		
	}
	public class ViewHolder{
		ImageView selhyitem_ig1;
		TextView selhyitem_tv1;
		TextView selhyitem_ig2;
		TextView selhyitem_tv2;
	}
}
