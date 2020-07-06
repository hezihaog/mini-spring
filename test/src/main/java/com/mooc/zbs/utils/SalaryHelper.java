package com.mooc.zbs.utils;

import com.mooc.zbs.beans.Bean;

/**
 * 工资计算类
 */
@Bean
public class SalaryHelper {
    /**
     * 计算工资
     *
     * @param experience 工龄
     */
    public Integer calSalary(Integer experience) {
        return experience * 5000;
    }
}