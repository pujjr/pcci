package com.pujjr.pcci.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public abstract class ParameterizedBaseService<T> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

}
