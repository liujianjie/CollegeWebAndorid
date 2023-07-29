package com.ht.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.PostDao;
import com.ht.pojo.Post;
import com.ht.service.PostService;
@Service
public class PostServiceImpl implements PostService {

	@Resource
	PostDao pdao;
	
	@Override
	public List<Post> selpostlist() {
		// TODO Auto-generated method stub
		return pdao.selpostlist();
	}

	@Override
	public int addpost(Post post) {
		return pdao.addpost(post);
	}

	@Override
	public int delpost(String id) {
		return pdao.delpost(id);
	}

	@Override
	public Post getpost(String id) {
		// TODO Auto-generated method stub
		return pdao.getpost(id);
	}

	@Override
	public int updpost(Post post) {
		// TODO Auto-generated method stub
		return pdao.updpost(post);
	}

}
