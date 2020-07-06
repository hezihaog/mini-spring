package com.mooc.zbs.web.handler;

import com.mooc.zbs.beans.BeanFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 保存每个URL和Controller的映射
 */
public class MappingHandler {
    /**
     * 请求路径Uri
     */
    private String uri;
    /**
     * Controller中对应的方法
     */
    private Method method;
    /**
     * Controller类对象
     */
    private Class<?> controller;
    /**
     * 调用方法时传递的参数
     */
    private String[] args;

    public MappingHandler(String uri, Method method, Class<?> controller, String[] args) {
        this.uri = uri;
        this.method = method;
        this.controller = controller;
        this.args = args;
    }

    /**
     * 处理方法
     *
     * @param req 请求对象
     * @param res 响应对象
     * @return 是否处理了
     */
    public boolean handle(ServletRequest req, ServletResponse res) throws IllegalAccessException, InstantiationException, InvocationTargetException, IOException {
        //获取请求路径
        String requestUri = ((HttpServletRequest) req).getRequestURI();
        //不是当前的Controller处理，直接返回
        if (!requestUri.equals(uri)) {
            return false;
        }
        //是当前Controller要处理的，准备方法参数，从Request对象中获取，获取到的值给反射调用
        Object[] parameters = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            parameters[i] = req.getParameter(args[i]);
        }
        //实例化Controller
        Object ctl = BeanFactory.getBean(controller);
        Object response = method.invoke(ctl, parameters);
        res.getWriter().println(response.toString());
        return true;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Class<?> getController() {
        return controller;
    }

    public void setController(Class<?> controller) {
        this.controller = controller;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}