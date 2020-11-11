package com.csdj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csdj.mapper.PaperMapper;
import com.csdj.pojo.Page;
import com.csdj.pojo.Paper;
import com.csdj.pojo.Type;
import com.csdj.service.PaperService;

@Service
public class PaperServiceImpl implements PaperService{
	@Autowired
	private PaperMapper mapper;
	
	@Override
	public List<Paper> getPaper(String title, String typeCode) {
		return mapper.getPaper(title,typeCode);
	}

	@Override
	public List<Type> getType() {
		return mapper.getType();
	}

	@Override
	public int addPaper(Paper paper) {
		return mapper.addPaper(paper);
	}

	@Override
	public Paper checkPaperByTitle(String title) {
		return mapper.checkPaperByTitle(title);
	}

	@Override
	public int deletePaperById(Integer id) {
		return mapper.deletePaperById(id);
	}

	@Override
	public Paper queryById(Integer id) {
		return mapper.queryById(id);
	}

	@Override
	public int update(Paper paper) {
		return mapper.updatePaperById(paper);
	}

	@Override
	public Page getPaperByPage(String title, String typeCode, Integer curPageNo, Integer pageSize) {
		Page page=new Page();
		page.setPageSize(pageSize);
		int totalCount=mapper.getCount(title, typeCode);
		page.setTotalCount(totalCount);
		
		//末页控制
		if (page.getTotalPage()!=0 && curPageNo>page.getTotalPage()) {
			curPageNo=page.getTotalPage();
		}
		
		page.setCurPageNo(curPageNo);
		
		int index=(curPageNo-1)*pageSize;
		List<Paper> pageList=mapper.getPaperByPage(title, typeCode, index, pageSize);
		page.setPageList(pageList);
		return page;
	}
	
	

}
