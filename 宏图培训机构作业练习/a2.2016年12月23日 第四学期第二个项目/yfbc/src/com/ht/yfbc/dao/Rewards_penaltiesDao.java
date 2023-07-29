package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Rewards_penalties;

/**
 * 奖惩表service
 * Day 2017-1-6
 * @author 刘宗龙
 *
 */
public interface Rewards_penaltiesDao {
	/**
	 * 根据用户id,年，月，查询奖惩表
	 * @return List<Rewards_penalties>
	 */
	public List<Rewards_penalties> selRewards_penaltiesList(Map<String, Object> map);
	
	public void addRewards_penalties(Rewards_penalties Rewards_penalties);
	
	/**
	 * 根据不同的条件查询<br>
	 * userid：用户id<br>
	 * recordtime：记录时间
	 * @param map
	 * @return
	 */
	public int selCount(Map<String, Object> map);
	/**
	 * 分页查询<br>
	 * pageCount:每页数据条数<br>
	 * currPage:当前页码<br>
	 * userid：用户id<br>
	 * recordtime：记录时间
	 * @param map
	 * @return
	 */
	public List<Rewards_penalties> selRewards_penaltiesListPage(Map<String, Object> map);
}
