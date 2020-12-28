package com.cedar.design.pattern.behavioral.chain;

/**
 * @author zhangnan
 * @date 2020-04-17 9:10
 * @description
 */
public interface IChainHandler<T, R> {

    /**
     * 处理前缀动作
     *
     * @param request
     * @param response
     * @return
     */
    boolean doBefore(T request, R response, AbstractChainHandler<T, R> chainHandler);

    /**
     * 调用链
     *
     * @param request      入参
     * @param response     出参
     * @param chainHandler 调用链
     * @return r
     */
    void doChain(T request, R response, AbstractChainHandler<T, R> chainHandler);

    /**
     * 处理后置动作
     *
     * @param request
     * @param response
     */
    void doAfter(T request, R response);
}
