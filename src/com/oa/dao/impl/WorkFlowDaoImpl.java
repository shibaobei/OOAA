package com.oa.dao.impl;

import com.oa.dao.WorkFlowDao;
import com.oa.entity.Form;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017-10-25.
 */
@Repository("workFlowDao")
public class WorkFlowDaoImpl extends BaseDaoImpl<Form> implements WorkFlowDao<Form>{
}
