package com.drivinggrpc.driving.tools;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class HldCache {
    private final static ConcurrentMap<Integer, HldCacheBean> cache = new ConcurrentHashMap<>();
    public final static int HLD_TIME = 3;//题目次数
    public final static int HLD_DAY = 1;//国企天数

    /**
     * @param userId
     * @return 返回的为地几次 -1为不可答题
     */
    public static int flush(int userId) {
        HldCacheBean cacheBean;
        if (cache.containsKey(userId)) {
            cacheBean = cache.get(userId);
            if (cacheBean.getRecode() != -1) {
                long currTime = System.currentTimeMillis();
                long timeC = currTime - cacheBean.getRecode();
                if ((timeC / 1000 / 60 / 60 / 24) < HLD_DAY)
                    return -1;
                else {
                    cacheBean.setTime(0);
                    cacheBean.setRecode(-1);
                }
            }
        } else {
            cacheBean = new HldCacheBean(0, -1);
        }
        cacheBean.flushTime();
        cache.put(userId, cacheBean);
        return cacheBean.getTime();
    }

    public static void put(int userId, int hldId) {
        HldCacheBean cacheBean = cache.get(userId);
        cacheBean.put(hldId, "UnAnswer");
    }
    public static void put(int userId, String answer) {
        HldCacheBean cacheBean = cache.get(userId);
        Map<Integer,String> map = cacheBean.getAnswer();
        for (Integer key :map.keySet()){
            String value = map.get(key);
            if (value.equals("UnAnswer")){
                cacheBean.put(key, answer);
            }
        }
    }

    public static void recode(int userId) {
        HldCacheBean cacheBean;
        if (cache.containsKey(userId)) {
            cacheBean = cache.get(userId);
            cacheBean.setTime(0);
            cacheBean.setRecode(System.currentTimeMillis());
        } else {
            cacheBean = new HldCacheBean(0, System.currentTimeMillis());
        }
        cache.put(userId, cacheBean);
    }

    public static Map<Integer, String> getAnswer(int userId) {
        return cache.get(userId).getAnswer();
    }

    public static void cleanAnswer(int userId) {
        cache.get(userId).clearAnswer();
    }
}
