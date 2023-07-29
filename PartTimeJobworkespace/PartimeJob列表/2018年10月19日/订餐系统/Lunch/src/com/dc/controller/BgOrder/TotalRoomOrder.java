package com.dc.controller.BgOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.dao.Bgorder.BgROrderDAO;
import com.dc.dao.Bgorder.BgROrderDAOImpl;
import com.dc.entity.PageEntity;
import com.dc.util.StringUtil;

public class TotalRoomOrder {
	private String target;
	private String nowpage;
	private String roomid;
	private String roomnumber;
	private String roomtype;
	private String begintime;
	private String endtime;
	private Map roomMap;
	private List totalroomlist;
	private List TotalSum;
	private PageEntity page;
	/**
	 * 分页显示所有房间统计，可条件查询
	 * @return
	 */
	public String checkAndShowtotal(){
		Map map=new HashMap();
		map.put("roomnumber", roomnumber);
		map.put("roomtype", roomtype);
		map.put("begintime", begintime);
		map.put("endtime", endtime);
		roomMap=map;
		int npage=0;
		if(StringUtil.checkNotNull(nowpage)){
			npage=Integer.parseInt(nowpage);
		}else{
			npage=1;
		}
		PageEntity page0=new PageEntity();
		page0.setNowpage(npage);
		BgROrderDAO dao=new BgROrderDAOImpl();
		Map map1=dao.checkOrshowTotal(map,page0);
		if(StringUtil.checkNotNull(map1)){
			totalroomlist=(List) map1.get("Detail");
			TotalSum=(List) map1.get("Total");	
		}
		page=page0;
		this.target="/module/BgOrder/TotalRoom.jsp";
		return "success";
	}
	
	public List getTotalSum() {
		return TotalSum;
	}

	public void setTotalSum(List totalSum) {
		TotalSum = totalSum;
	}

	public List getTotalroomlist() {
		return totalroomlist;
	}

	public void setTotalroomlist(List totalroomlist) {
		this.totalroomlist = totalroomlist;
	}

	public PageEntity getPage() {
		return page;
	}

	public void setPage(PageEntity page) {
		this.page = page;
	}

	public String getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getNowpage() {
		return nowpage;
	}
	public void setNowpage(String nowpage) {
		this.nowpage = nowpage;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public Map getRoomMap() {
		return roomMap;
	}
	public void setRoomMap(Map roomMap) {
		this.roomMap = roomMap;
	}
	
}
