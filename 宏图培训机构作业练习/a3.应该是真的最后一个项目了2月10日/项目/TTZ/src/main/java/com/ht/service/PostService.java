package com.ht.service;

import java.util.List;


import com.ht.pojo.Post;

/**
 * ��λ
 * */

public interface PostService {
	//��ѯ
	public List<Post> selpostlist();
	//��λ��� ��ɾ��
	public int addpost(Post post);
	public int delpost(String id);
	//����
	public Post getpost(String id);
	//�޸�
	public int updpost(Post post);
	
}
