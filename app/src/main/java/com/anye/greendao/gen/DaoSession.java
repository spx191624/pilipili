package com.anye.greendao.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import nataya.pilipili.bean.GoodBean;
import nataya.pilipili.bean.History;
import nataya.pilipili.bean.User;

import com.anye.greendao.gen.GoodBeanDao;
import com.anye.greendao.gen.HistoryDao;
import com.anye.greendao.gen.UserDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig goodBeanDaoConfig;
    private final DaoConfig historyDaoConfig;
    private final DaoConfig userDaoConfig;

    private final GoodBeanDao goodBeanDao;
    private final HistoryDao historyDao;
    private final UserDao userDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        goodBeanDaoConfig = daoConfigMap.get(GoodBeanDao.class).clone();
        goodBeanDaoConfig.initIdentityScope(type);

        historyDaoConfig = daoConfigMap.get(HistoryDao.class).clone();
        historyDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        goodBeanDao = new GoodBeanDao(goodBeanDaoConfig, this);
        historyDao = new HistoryDao(historyDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);

        registerDao(GoodBean.class, goodBeanDao);
        registerDao(History.class, historyDao);
        registerDao(User.class, userDao);
    }
    
    public void clear() {
        goodBeanDaoConfig.clearIdentityScope();
        historyDaoConfig.clearIdentityScope();
        userDaoConfig.clearIdentityScope();
    }

    public GoodBeanDao getGoodBeanDao() {
        return goodBeanDao;
    }

    public HistoryDao getHistoryDao() {
        return historyDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

}
