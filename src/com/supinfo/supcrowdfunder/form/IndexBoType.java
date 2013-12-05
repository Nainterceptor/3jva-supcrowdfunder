package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.dao.StatisticDao;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Map;

/**
 * Author: Gaël Demette
 * Date: 03/12/13
 * Time: 11:50
 */
public class IndexBoType extends AbstractType {
    public Timestamp from;
    public Timestamp to;

    public Map<String, Long> chooseMethodDao() {
        Map<String, Long> stats;
        if (this.from != null && this.to != null)
            stats = StatisticDao.findGlobalStatsFromTo(this.from, this.to);
        else if (this.from != null)
            stats = StatisticDao.findGlobalStatsFrom(this.from);
        else if (this.to != null)
            stats = StatisticDao.findGlobalStatsTo(this.to);
        else
            stats = StatisticDao.findGlobalStats();
        return stats;
    }

    public void validate(HttpServletRequest request) {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        if (from != null && from.length() > 0) {
            try {
                this.from = Timestamp.valueOf(from);
            } catch (Exception e) {
                errors.put("from", "validator.bo.index.from.cast");
            }
        }
        if (to != null && to.length() > 0) {
            try {
                this.to = Timestamp.valueOf(to);

            } catch (Exception e) {
                errors.put("to", "validator.bo.index.to.cast");
            }
        }
        if (!errors.isEmpty())
            result = false;
    }
}
