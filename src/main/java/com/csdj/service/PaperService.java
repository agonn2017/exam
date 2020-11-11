package com.csdj.service;

import java.util.List;

import com.csdj.pojo.Page;
import com.csdj.pojo.Paper;
import com.csdj.pojo.Type;

public interface PaperService {
	/**
	 * 查询论文,如果标题和类型不为空,则根据标题和类型查询(标题支持模糊查询)
	 * @param title
	 * @param typeCode
	 * @return
	 */
	List<Paper> getPaper(String title, String typeCode);
	
	/**
	 * 分页查询
	 * @param title
	 * @param typeCode
	 * @param curPageNo
	 * @param pageSize
	 * @return
	 */
	Page getPaperByPage(String title, String typeCode,
                        Integer curPageNo, Integer pageSize);
	/**
	 * 查询所有论文类型
	 * @return
	 */
	List<Type> getType();
	/**
	 * 新增
	 * @param paper
	 * @return
	 */
	int addPaper(Paper paper);
	/**
	 * 验证论文标题是否存在
	 * @param title
	 * @return
	 */
	Paper checkPaperByTitle(String title);
	/**
	 * 根据id删除论文
	 * @param id
	 * @return
	 */
	int deletePaperById(Integer id);
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Paper queryById(Integer id);
	/**
	 * 修改
	 * @param paper
	 * @return
	 */
	int update(Paper paper);
}
