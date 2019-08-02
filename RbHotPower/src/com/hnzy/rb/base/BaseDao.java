package com.hnzy.rb.base;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T extends Serializable> {
	/**
	 * @author Administrator 查找信息
	 */
	public List<T> find();

	/**
	 * @author Administratorzy
	 * 级联查询
	 */
	public T findZtree(String xqName,Integer buildNO,Integer cellNO);
	/**
	 * @author Administrator 插入信息
	 */
	public void Insert( T entity);

	/**
	 * @author Administrator 删除
	 */
	public int delete(int id);

	/**
	 * @author Administrator 根据id查找信息
	 */
	public T findById(int id);

	/**
	 * @author Administrator 更新信息
	 */
	public void update(T  entity);

}
