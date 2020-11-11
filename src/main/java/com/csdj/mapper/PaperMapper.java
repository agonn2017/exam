package com.csdj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.csdj.pojo.Paper;
import com.csdj.pojo.Type;

public interface PaperMapper {
	/**
	 * 查询所有论文
	 * @param title
	 * @param typeCode
	 * @return
	 */
	List<Paper> getPaperByPage(@Param("title") String title,
                               @Param("typeCode") String typeCode,
                               @Param("index") Integer index,
                               @Param("pageSize") Integer pageSize);

	/**
	 * 查询论文数量
	 * @param title
	 * @param typeCode
	 * @return
	 */
	int getCount(@Param("title") String title,
                 @Param("typeCode") String typeCode);
	
	/**
	 * 查询所有论文类型
	 * @return
	 */
	List<Type> getType();

	/**
	 * 新增论文
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
	int updatePaperById(Paper paper);

	/**
	 * 不带分页的查询
	 * @param title
	 * @param typeCode
	 * @return
	 */
	List<Paper> getPaper(String title, String typeCode);
	
}
