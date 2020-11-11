package com.csdj.controller;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.csdj.pojo.Page;
import com.csdj.pojo.Paper;
import com.csdj.pojo.Type;
import com.csdj.pojo.User;
import com.csdj.service.PaperService;

@Controller
@RequestMapping("/paper")
public class PaperController {
	@Autowired
	private PaperService service;
	/**
	 * 通用的页面跳转
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String home(@PathVariable String  page) {
		return page;
	}
	/**
	 * 查询论文  不带分页
	 * @param model
	 * @return
	 */
	@RequestMapping("/getPaper")
	public String getPaper(String title,String typeCode,
				Model model) {
		if ("-1".equals(typeCode)) {
			typeCode=null;
		}
		List<Paper> list=service.getPaper(title,typeCode);
		List<Type> typeList=service.getType();
		model.addAttribute("paperList", list);
		model.addAttribute("typeList", typeList);
		model.addAttribute("title", title);
		model.addAttribute("typeCode", typeCode);
		return "paper";
	}
	
	/**
	 * 查询论文  带分页
	 * @param model
	 * @return
	 */
	@RequestMapping("/getPaperByPage")
	public String getPaperByPage(String title,String typeCode,
				Model model,Integer curPageNo) {
		int pageSize=3;
		if (curPageNo==null|| curPageNo==0) {
			curPageNo=1;
		}
		if ("-1".equals(typeCode)) {
			typeCode=null;
		}
		Page page=service.getPaperByPage(title, typeCode, curPageNo, pageSize);
		List<Type> typeList=service.getType();
		model.addAttribute("page", page);
		model.addAttribute("typeList", typeList);
		model.addAttribute("title", title);
		model.addAttribute("typeCode", typeCode);
		return "paper";
	}
	
	/**
	 * 新增页面跳转
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAdd(Model model) {
		List<Type> typeList=service.getType();
		model.addAttribute("typeList", typeList);
		return "add";
	}
	/**
	 * 添加论文
	 * @param paper
	 * @param content
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/add")
	public String saveAdd(Paper paper,MultipartFile content,HttpSession session) throws IllegalStateException, IOException {
		paper.setCreationDate(new Date());
		User user = (User) session.getAttribute("user");
		paper.setCreatedBy(user.getUserName());
		
		if (content!=null) {
			String fileName=content.getOriginalFilename();
			paper.setFileName(fileName);
			
			String path="E:\\temp\\";
			String type=fileName.substring(fileName.lastIndexOf("."));
			String newFileName=UUID.randomUUID()+type;
			File file=new File(path+newFileName);
			content.transferTo(file);
			paper.setPaperPath(newFileName);
		}
		service.addPaper(paper);
		return "redirect:getPaperByPage";
	}
	/**
	 * 验证名字是否重复
	 * @param title
	 * @return
	 */
	@RequestMapping("/checkTitleExist")
	@ResponseBody
	public String checkTitleExist(String title) {
		Paper paper=service.checkPaperByTitle(title);
		if (paper==null) {
			return "false";
		}
		else {
			return "true";
		}
	}
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(Integer id) {
		int result = service.deletePaperById(id);
		if (result>0) {
			return "true";
		}
		return "false";
	}
	
	/**
	 * 根据id查询
	 */
	@RequestMapping("/getById")
	public String getById(Integer id,Model model) {
		Paper paper = service.queryById(id);
		List<Type> typeList=service.getType();
		model.addAttribute("typeList", typeList);
		model.addAttribute("paper", paper);
		return "update";
	}
	/**
	 * 保存修改
	 * @param paper
	 * @return
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/update")
	public String update(Paper paper,HttpSession session,
				MultipartFile content) throws Exception {
		paper.setModifyDate(new Date());
		paper.setModifyBy(((User)session.getAttribute("user")).getUserName());
		if (content!=null) {
			String fileName=content.getOriginalFilename();
			if (fileName!=null && fileName.length()>0) {
				paper.setFileName(fileName);
				
				String path="E:\\temp\\";
				String type=fileName.substring(fileName.lastIndexOf("."));
				String newFileName=UUID.randomUUID()+type;
				File file=new File(path+newFileName);
				content.transferTo(file);
				paper.setPaperPath(newFileName);
			}
		}
		int result = service.update(paper);
		if (result>0) {
			return "redirect:getPaperByPage";
		}else {
			return "update";
		}
	}
}
