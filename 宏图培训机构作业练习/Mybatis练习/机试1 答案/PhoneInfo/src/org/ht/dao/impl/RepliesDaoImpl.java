package org.ht.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.ht.dao.RepliesDao;
import org.ht.pojo.Replies;
import org.ht.util.MyBatisSqlSessionUtil;

public class RepliesDaoImpl implements RepliesDao{

	public int addReplies(Replies replies) {
		SqlSession session = MyBatisSqlSessionUtil.openSession();
		int count = session.insert("repliesDao.addReplies",replies);
		return count;
	}

}
