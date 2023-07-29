package com.ht.yfbc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.Cars_infoDao;
import com.ht.yfbc.dao.MoveStorageDao;
import com.ht.yfbc.dao.PutawayDao;
import com.ht.yfbc.dao.WarehouseDao;
import com.ht.yfbc.pojo.Cars_info;
import com.ht.yfbc.pojo.Goodtype;
import com.ht.yfbc.pojo.MoveStorage;
import com.ht.yfbc.pojo.Picking;
import com.ht.yfbc.pojo.Putaway;
import com.ht.yfbc.pojo.Stage;
import com.ht.yfbc.pojo.Warehouse2;
import com.ht.yfbc.pojo.putaway2;
import com.ht.yfbc.service.GoodtypeService;
import com.ht.yfbc.service.MoveStorageService;

/**
 * 移库操作(MoveStorage)
 * day 2016-1-4
 * @author 刘建杰
 *
 */
@Service
public class MoveStorageServiceImpl implements MoveStorageService{

	@Resource
	private MoveStorageDao movedao; 
	
	@Resource
	private PutawayDao putawaydao;
	
	@Resource
	private Cars_infoDao carsinfodao;
	
	@Resource
	private GoodtypeService goodservice;
	
	@Resource
	private WarehouseDao warDao;
	
	@Override
	public int addMoveStorage(MoveStorage movestorage) {
		// TODO 自动生成的方法存根
		int i = movedao.addMoveStorage(movestorage);
		if(i>0){
			//修改为不在货架中了
			putawaydao.updatePtbln(movestorage.getPtid());
		}
		return i;
	}

	@Override
	public Map<String,Object> selMoveStorage(String userid,String whid,Integer cpage) {
		// 分页
		int pagecount = 5;
		int totalcount = movedao.getMoveStorageMoCount(userid);
		int totalpage = (totalcount+pagecount-1)/pagecount;
		if(cpage>totalpage){
			cpage=totalpage;
		}
		if(cpage<=0){
			cpage=1;
		}
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("pagecount", pagecount);
		map.put("currpage", cpage);
		map.put("totalpage", totalpage);
		map.put("userid", userid);
		
		List<MoveStorage> movelist=movedao.selMoveStorage(map);
		//这个仓库的车辆列表 用来对比出移库表中的车辆名称
		List<Cars_info> carsinfoslist = carsinfodao.selCars_infobywhid(whid);
		//仓库 货物类型
		List<Goodtype> goodslist = goodservice.seltype();
		
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("currPage", cpage);
		maps.put("totalPage", totalpage);
		maps.put("pagecount", pagecount);
		maps.put("totalcount", totalcount);
		maps.put("movelist", movelist);
		maps.put("carsinfoslist", carsinfoslist);
		maps.put("goodslist", goodslist);
		
		return maps;
	}

	@Override
	public MoveStorage getOneMoveStorage(String moid) {
		return movedao.getOneMoveStorage(moid);
	}

	@Override
	public int updateMoveStorage(MoveStorage move) {
		return movedao.updateMoveStorage(move);
	}

	@Override
	public Map<String,Object> selMoveStorageByTouser(String touser) {
		
		List<MoveStorage> movelist = movedao.selMoveStorageByTouser(touser);
		
		//所有仓库的所有车辆列表 用来对比出移库表中的车辆名称
		List<Cars_info> carsinfoslist = carsinfodao.selCars_info();
		
		//仓库 货物类型
		List<Goodtype> goodslist = goodservice.seltype();
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("carsinfoslist", carsinfoslist);
		maps.put("goodslist", goodslist);
		maps.put("movelist", movelist);
		
		return maps;
	}

	@Override
	public int getMoveStorageCount(String userid) {
		// TODO 自动生成的方法存根
		return movedao.getMoveStorageCount(userid);
	}
	@Override
	public Map<String,Object> selAllMoveStorage(Integer cpage,String mowhiname, String towhiname) {
		// 分页
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("mowhiname", mowhiname);
		map.put("towhiname", towhiname);
		int pagecount = 5;
		int totalcount = movedao.getAllMoveStorageCount(map);
		int totalpage = (totalcount+pagecount-1)/pagecount;
		if(cpage>totalpage){
			cpage=totalpage;
		}
		if(cpage<=0){
			cpage=1;
		}
		map.put("pagecount", pagecount);
		map.put("currpage", cpage);
		map.put("totalpage", totalpage);
		List<MoveStorage> movelist=movedao.selAllMoveStorage(map);
		//车辆列表 
		List<Cars_info> carsinfoslist = carsinfodao.selCars_info();
		//仓库 货物类型
		List<Goodtype> goodslist = goodservice.seltype();
		List<Warehouse2> warelist = warDao.selWarehouseAll();
		
		Map<String,Object> maps = new HashMap<String,Object>();
		maps.put("currPage", cpage);
		maps.put("totalPage", totalpage);
		maps.put("pagecount", pagecount);
		maps.put("totalcount", totalcount);
		maps.put("movelist", movelist);
		maps.put("carsinfoslist", carsinfoslist);
		maps.put("goodslist", goodslist);
		maps.put("warelist", warelist);
		maps.put("mowhiname", mowhiname);
		maps.put("towhiname", towhiname);
		return maps;
	}
	
}
