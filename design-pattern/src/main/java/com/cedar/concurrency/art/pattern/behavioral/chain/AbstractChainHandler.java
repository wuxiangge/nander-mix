package com.cedar.concurrency.art.pattern.behavioral.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangnan
 * @date 2020-04-17 9:11
 * @description
 */
public class AbstractChainHandler<T, R> implements IChainHandler<T, R> {

    /**
     * 用于标记事件的引用顺序
     */
    private int index = 0;

    /**
     * 用List集合来存储事件
     */
    private List<IChainHandler<T, R>> chainHandlerList = new ArrayList<>();

    /**
     * 往事件链条中添加事件
     *
     * @param iChainHandler
     * @return
     */
    public AbstractChainHandler<T, R> addChain(IChainHandler<T, R> iChainHandler) {
        chainHandlerList.add(iChainHandler);
        return this;
    }

    /**
     * 往事件链条中添加事件
     *
     * @param iChainHandler
     * @param addFlag
     * @return
     */
    public AbstractChainHandler<T, R> addChain(boolean addFlag, IChainHandler<T, R> iChainHandler) {
        if (addFlag) {
            chainHandlerList.add(iChainHandler);
        }
        return this;
    }

    /**
     * 往事件链条中添加事件
     *
     * @param mChainHandler
     * @param nChainHandler
     * @param addFlag
     * @return
     */
    public AbstractChainHandler<T, R> addChain(boolean addFlag, IChainHandler<T, R> mChainHandler, IChainHandler<T, R> nChainHandler) {
        if (addFlag) {
            chainHandlerList.add(mChainHandler);
        } else {
            chainHandlerList.add(nChainHandler);
        }
        return this;
    }


    public AbstractChainHandler<T, R> addChains(List<IChainHandler<T, R>> iChainHandlers) {
        chainHandlerList.addAll(iChainHandlers);
        return this;
    }

    @Override
    public boolean doBefore(T request, R response, AbstractChainHandler<T, R> chainHandler) {
        // nothing to do
        return true;
    }

    /**
     * 调用链
     *
     * @param request      入参
     * @param response     出参
     * @param chainHandler 调用链
     * @return r
     */
    @Override
    public void doChain(T request, R response, AbstractChainHandler<T, R> chainHandler) {
        // 处理上一个链的后置操作
        if (index > 0) {
            chainHandlerList.get(index - 1).doAfter(request, response);
        }

        if (index == chainHandlerList.size()) {
            return;
        }
        //每执行一个调用事件，index自增1
        IChainHandler<T, R> iChainHandler = chainHandlerList.get(index);
        index++;
        //根据索引值获取对应的事件对进行处理

        // 处理前置操作
        boolean flag = iChainHandler.doBefore(request, response, chainHandler);
        // 前置操作异常，则返回
        if (!flag) {
            return;
        }
        // 处理业务链
        iChainHandler.doChain(request, response, chainHandler);
    }

    @Override
    public void doAfter(T request, R response) {
        // nothing to do
    }
}
