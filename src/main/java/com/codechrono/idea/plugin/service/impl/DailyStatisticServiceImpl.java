package com.codechrono.idea.plugin.service.impl;

import com.codechrono.idea.plugin.dao.DailyStatisticDao;
import com.codechrono.idea.plugin.dao.impl.DailyStatisticDaoImpl;
import com.codechrono.idea.plugin.entity.DailyStatistic;
import com.codechrono.idea.plugin.service.DailyStatisticService;
import com.codechrono.idea.plugin.service.DatabaseBasicService;
import com.intellij.openapi.application.ApplicationManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author LeeWyatt
 */
public class DailyStatisticServiceImpl implements DailyStatisticService {
    private final DatabaseBasicService databaseBasicService = ApplicationManager.getApplication().getService(DatabaseBasicService.class);

    private final DailyStatisticDao dailyStatisticDao = DailyStatisticDaoImpl.getInstance();

    public static DailyStatisticServiceImpl getInstance() {
        return ApplicationManager.getApplication().getService(DailyStatisticServiceImpl.class);
    }

    private DailyStatisticServiceImpl() {
    }

    @Override
    public void insert(DailyStatistic[] ary) {
        Connection conn = null;
        try {
            conn = databaseBasicService.getConnection();
            dailyStatisticDao.insert(conn, ary);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseBasicService.closeResource(conn, null, null);
        }
    }

    @Override
    public DailyStatistic insert(DailyStatistic notebook) {
        Connection conn = null;
        try {
            conn = databaseBasicService.getConnection();
            return dailyStatisticDao.insert(conn, notebook);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseBasicService.closeResource(conn, null, null);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(DailyStatistic[] ary) {

    }

    @Override
    public void update(DailyStatistic dailyStatistic) {

    }

    @Override
    public DailyStatistic findById(Integer id) {
        return null;
    }

    @Override
    public void exchangeShowOrder(Integer showOrder1, Integer showOrder2) {

    }

    @Override
    public List<DailyStatistic> queryOneDayEditRecord(Long beginTime) {
        Connection conn = null;
        try {
            conn = databaseBasicService.getConnection();
            return dailyStatisticDao.queryOneDayEditRecord(conn, beginTime);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseBasicService.closeResource(conn, null, null);
        }
        return null;
    }

    @Override
    public List<DailyStatistic> getOneDayDailyStatistic(Long beginTime,Long endTime) {
        Connection conn = null;
        try {
            conn = databaseBasicService.getConnection();
            return dailyStatisticDao.getDailyStatistic(conn, beginTime,endTime);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            databaseBasicService.closeResource(conn, null, null);
        }
        return null;
    }


}
