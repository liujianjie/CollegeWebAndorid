package com.ht.yfbc.action;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * 流程定义管理Controller
 * @author 刘建杰
 *
 */
@Controller
@RequestMapping("activity")
public class ActivitiController {

	@Resource
	private RepositoryService repositoryService;
	
	//上传流程部署文件
	@RequestMapping("adddeploy")
	public String adddeploy(@RequestParam("deployFile") MultipartFile deployFile)throws Exception{
		System.out.println("111");
		repositoryService.createDeployment() // 创建部署
		.addZipInputStream(new ZipInputStream(deployFile.getInputStream())) // 添加zip输入流
				.name("移库操作流程") // 流程名称
				.deploy(); // 部署
		System.out.println("ok");
		return "redirect:/activity/listdeploy.do";
	}
	
	//流程管理列表
	@RequestMapping("listdeploy")
	public String listdeploy(Model model){
		List<Deployment> deploymentList=repositoryService.createDeploymentQuery() // 创建流程部署查询
				.orderByDeploymenTime().asc() // 根据部署时间降序排列
				.list();//所有流程部署
		model.addAttribute("deploymentList", deploymentList);
		return "liujianjie/deployManage";
	}
	
	//删除流程管理
	@RequestMapping("deletedeploy")
	public String deletedeploy(@RequestParam(value = "id")String id){
		repositoryService.deleteDeployment(id, true);
		return "redirect:/activity/listdeploy.do";
	}
	//流程定义列表
	@RequestMapping("listpro")
	public String listpro(Model model){
		List<ProcessDefinition> processDefinition=repositoryService.createProcessDefinitionQuery() // 创建流程流程定义查询
				.orderByProcessDefinitionId().desc() // 根据流程定义id降序排列
				.list();
		model.addAttribute("processDefinition", processDefinition);
		return "liujianjie/process";
	}
	//流程图展现
	@RequestMapping("/showView")
	public String showView(String deploymentId,String diagramResourceName,HttpServletResponse response)throws Exception{
		InputStream inputStream=repositoryService.getResourceAsStream(deploymentId, diagramResourceName);
		OutputStream out=response.getOutputStream();
		for(int b=-1;(b=inputStream.read())!=-1;){
			out.write(b);
		}
		out.close();
		inputStream.close();
		return null;
	}
		
}
