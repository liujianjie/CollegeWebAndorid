package com.example.qq.basadpter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MainFragmentViewPagerAdapter extends FragmentPagerAdapter{

	private ArrayList<Fragment> array;
	
	public void setData(ArrayList<Fragment> arrays){
		array=arrays;
	}
	
	public MainFragmentViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {//����fragment����
		// TODO �Զ����ɵķ������
		return array.get(arg0);
	}

	@Override
	public int getCount() {//��ȡ����
		if(array!=null){
			return array.size();
		}
		return 0;
	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO �Զ����ɵķ������
		super.destroyItem(container, position, object);
	}
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO �Զ����ɵķ������
		return super.instantiateItem(container, position);
	}

}
