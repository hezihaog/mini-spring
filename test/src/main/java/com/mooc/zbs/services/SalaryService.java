package com.mooc.zbs.services;

import com.mooc.zbs.beans.Bean;

@Bean
public class SalaryService {
    /**
     * 计算工资
     *
     * @param experience 工龄
     */
    public Integer calSalary(Integer experience) {
        return experience * 5000;
    }
}