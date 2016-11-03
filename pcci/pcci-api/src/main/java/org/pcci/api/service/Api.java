package org.pcci.api.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.pujjr.common.utils.bean.BeanCopierUtils;

/**
 * Api公共
 */
public class Api {
	protected <Key, Entity, Model> Map<Key, Model> entityMapToModelMap(Map<Key, Entity> entityMap, Class<Model> modelClass) throws IllegalAccessException, InstantiationException {
		Map<Key, Model> modelMap = new LinkedHashMap<>();
		for (Key key : entityMap.keySet()) {
			Entity entity = entityMap.get(key);
			Model model = entityToModel(entity, modelClass);
			modelMap.put(key, model);
		}
		return modelMap;
	}

	protected <Entity, Model> List<Model> entityListToModelList(List<Entity> entityList, Class<Model> modelClass) throws IllegalAccessException, InstantiationException {
		List<Model> modelList = new ArrayList<>();
		for (Entity entity : entityList) {
			Model model = entityToModel(entity, modelClass);
			modelList.add(model);
		}
		return modelList;
	}

	protected <Entity, Model> Model entityToModel(Entity entity, Class<Model> modelClass) throws IllegalAccessException, InstantiationException {
		Model model = modelClass.newInstance();
		BeanCopierUtils.copy(entity, model);
		return model;
	}

}
