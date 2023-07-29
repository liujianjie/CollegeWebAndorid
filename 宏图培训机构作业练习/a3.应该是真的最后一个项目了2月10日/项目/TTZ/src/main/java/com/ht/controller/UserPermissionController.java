package com.ht.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.ht.pojo.BackGroundUser;
import com.ht.service.BackgroundUserService;
import com.ht.service.PermissionService;
import com.ht.util.SystemContant;


/**
 * ��̨�û�Ȩ�� ���Ʋ�
 */

@Controller
@RequestMapping("userper")
public class UserPermissionController {
	
	@Resource
	BackgroundUserService backuser;
	@Resource
	PermissionService perservice;
	
	@RequestMapping("userlist")
	public String userlist(Model model,@RequestParam(value = "cpage")Integer cpage){
		Map<String,Object> map = backuser.selbackuserlist(cpage);
		
		model.addAttribute("map", map);
		return "../backgroundSystem/UserAssign.jsp";
	}
	//��ѯȨ��
	@RequestMapping("seluserpermissionlist")
	public String seluserpermissionlist(Model model,
			@RequestParam(value = "userid")String userid){
		//��ѯѡ���û�ӵ�е�Ȩ��
		List list = perservice.selectlistbybid(userid);
		model.addAttribute("userid", userid);
		model.addAttribute("userperlist", list);
		return "../backgroundSystem/UserPermission.jsp";
	}
	
	//����Ȩ��
	@ResponseBody
	@RequestMapping("saveuserpermission")
	public Map<String,Object> saveuserpermission(@RequestParam(value = "checks")String checkss,
			@RequestParam(value = "userid")String userid,HttpSession session){
		//�ж��Ƿ�Ϊ''
		Map<String,Object> map1 = new HashMap<String, Object>();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("b_id",userid);
		if(!checkss.equals("")){//��Ϊ�յĵ�ʱ��
			String checks[] = checkss.split(","); 
			
			List<Integer> yylist = perservice.selectlistbybid(userid);
			//�Ȳ���û���ӵ�е� Ȩ�� Ȼ��Աȸ�ȥ��
			List<Integer> yxlist = new ArrayList<Integer>();//����Ϊ��ѡ��list
			List<Integer> needdellist = new ArrayList<Integer>();//����Ϊ��Ҫɾ����Ȩ��
			for(int j=0;j<checks.length;j++){
				yxlist.add(Integer.parseInt(checks[j]));
			}
			
			for(int i=0;i<yylist.size();i++){
				boolean bln=false;
				Integer zhi = yylist.get(i);//���е�ֵ
				for(int j=0;j<yxlist.size();j++){
					if(zhi==yxlist.get(j)){
						bln = true;
						yxlist.remove(j);
					}
				}
				if(bln==false){
					needdellist.add(zhi);//�����Ҫɾ����Ȩ��
				}
			}
			
			//��ɾ��
			try{
				for(int i=0;i<needdellist.size();i++){
					map.put("p_list", needdellist.get(i));
					perservice.deluserpermission(map);
				}
				
				//�����
				for(int i=0;i<yxlist.size();i++){
					map.put("p_list", yxlist.get(i));
					perservice.adduserpermission(map);
				}
				map1.put("result", 1);
				//�ɹ��޸ĺ󣬿�������޸ĵ��û��ǲ��ǵ�¼�û�
				BackGroundUser back = (BackGroundUser) session.getAttribute("backuser");
				if(back.getB_id().equals(userid)){
					//���»�ȡȨ���б�
					List<Integer> list = perservice.selectlistbybid(userid);
					session.setAttribute("qxlist", list);
				}
				
			}catch(Exception e){
				map1.put("result", 0);
				e.printStackTrace();
			}
		}else{//Ϊ�գ�ֱ��ȫ��ɾ��
			try{
				perservice.deluserpermission(map);
				map1.put("result", 1);
			}catch(Exception e){
				map1.put("result", 0);
				e.printStackTrace();
			}
		}
		
		return map1;
	}

}
