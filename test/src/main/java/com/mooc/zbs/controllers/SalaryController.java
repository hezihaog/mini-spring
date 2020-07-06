package com.mooc.zbs.controllers;

import com.mooc.zbs.beans.AutoWired;
import com.mooc.zbs.services.SalaryService;
import com.mooc.zbs.web.mvc.Controller;
import com.mooc.zbs.web.mvc.RequestMapping;
import com.mooc.zbs.web.mvc.RequestParam;

/**
 * 工资的控制器
 */
@Controller
public class SalaryController {
    /**
     * 依赖注入
     */
    @AutoWired
    private SalaryService salaryService;

    /**
     * 查询工资
     *
     * @param name       员工名称
     * @param experience 工龄
     */
    @RequestMapping("/getSalary")
    public Integer getSalary(@RequestParam("name") String name, @RequestParam("experience") String experience) {
        System.out.println("salaryService => " + salaryService);
        System.out.println("获取到的参数 => name=" + name + ",experience=" + experience);
        return salaryService.calSalary(Integer.parseInt(experience));
    }
}