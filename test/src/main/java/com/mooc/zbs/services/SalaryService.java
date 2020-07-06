package com.mooc.zbs.services;

import com.mooc.zbs.beans.AutoWired;
import com.mooc.zbs.beans.Service;
import com.mooc.zbs.utils.SalaryHelper;

@Service
public class SalaryService {
    @AutoWired
    private SalaryHelper salaryHelper;

    /**
     * 计算工资
     *
     * @param experience 工龄
     */
    public Integer calSalary(Integer experience) {
        return salaryHelper.calSalary(experience);
    }
}