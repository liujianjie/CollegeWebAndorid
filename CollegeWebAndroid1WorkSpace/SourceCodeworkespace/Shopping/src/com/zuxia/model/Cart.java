package com.zuxia.model;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 购物车
 */
public class Cart {
	/**
	 * 保存所有GoodsInfo对象的容器对象。
	 */
	private HashMap<Integer,OrderGoodsInfo> cart;

	public Cart() {
		cart = new HashMap<Integer, OrderGoodsInfo>();
	}

	/**
	 * 返回包含所有已经订购的商品信息的容器对象。
	 * @return 当前的容器对象
	 */
	public HashMap<Integer,OrderGoodsInfo> getCart(){
		return cart;
	}

	/**
	 * 添加一种商品到购物车中，如果这种商品在购物车中已经存在， 
	 * 那就修改已有的商品的数量， 
	 * 反之，构造一个新的Item对象添加到items对象中。
	 * @param goods 新增的代表这种商品的对象
	 */
	public void addGoods(GoodsInfo goods) {
		this.addGoods(goods,1);
	}
	
	/**
	 * 添加指定数量的某商品到购物车中。
	 * 若购物车中已有该商品，则增加其订购数量，
	 * 若购物车中没有该商品，则将该商品放入购物车中
	 * @param goods 商品
	 * @param quantity 数量
	 */
	public void addGoods(GoodsInfo goods,int quantity) {
		if (goods != null) {
			OrderGoodsInfo orderGoods = null;
			if(cart.containsKey(goods.getGoodsId())){
				orderGoods = cart.get(Integer.valueOf(goods.getGoodsId()));
				orderGoods.setQuantity(orderGoods.getQuantity()
						+ quantity);
			}else{
				orderGoods = new OrderGoodsInfo();
				orderGoods.setGoodsInfo(goods);
				orderGoods.setQuantity(quantity);
				//将商品id作为key值
				cart.put(Integer.valueOf(goods.getGoodsId()),orderGoods);
			}
		}
	}

	/**
	 * 从购物车中，删除商品。
	 * @param id 所删除商品的商品编号
	 * @return 删除成功，返回true，反之返回false
	 */
	public boolean removeGoods(int id) {
		if(cart.containsKey(Integer.valueOf(id))){
			cart.remove(Integer.valueOf(id));
			return true;
		}
		return false;
	}
	
	/**
	 * 清空购物车
	 */
	public void clearCart() {
		if (this.cart != null) {
			this.cart.clear();
		}
	}
	
	/**
	 * 更改购物车中的商品数量
	 * @param id 商品编号
	 * @param quantity 数量
	 */
	public void updateQuantity(int goodsId, int quantity) {
		if(cart.containsKey(goodsId)){
			OrderGoodsInfo orderGoods = cart.get(goodsId);
			orderGoods.setQuantity(quantity);
		}
	}

	/**
	 * 计算所购所有商品的总价。
	 * @return 商品的总价
	 */
	public double getTotalPrice() {
		double sum = 0.0;
		Iterator<Integer> it = cart.keySet().iterator();
		OrderGoodsInfo orderGoods = null;
		while(it.hasNext()){
			orderGoods =  cart.get(it.next());
			sum = sum +orderGoods.getSumPrice();
		}
		return Math.round(sum * 100.0) / 100.0;
	}
}