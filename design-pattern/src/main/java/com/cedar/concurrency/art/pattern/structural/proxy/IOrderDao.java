package com.cedar.concurrency.art.pattern.structural.proxy;

/**
 * @author zhangnan
 * @date 2020-04-12 18:33
 * @description
 */
public interface IOrderDao {

    /**
     * 插入订单
     *
     * @param order
     * @return
     */
    int insert(Order order);

    /**
     *     InnoDB是一个支持行锁的存储引擎，有三种排它锁（X锁）：
     *
     *     Record Lock：行锁，单个行记录上的锁。
     *     Gap Lock：间隙锁，锁定一个范围，但不包括记录本身。GAP锁的目的，是为了防止幻读、防止间隙内有新数据插入、防止已存在的数据更新为间隙内的数据。
     *     Next-Key Lock：1+2，锁定一个范围，并且锁定记录本身。对于行的查询，都是采用该方法，主要目的是解决幻读的问题。InnoDB默认加锁方式是next-key 锁。
     *     next-key锁是mysql默认的锁，是记录锁和在此索引记录之前的gap上的锁的结合，这个锁的作用是为了防止幻读，导致主从复制的不一致。
     *
     *     比如有一个表，id列上有90,100,102。
     *
     *     当我们执行select * from order where id=100 for update 时，mysql会锁住90到102这个区间。当我们执行 select * from order where id>100 for update时，这时next-key锁就派上用场了。
     *
     *     索引扫描到了100和102这两个值，但是仅仅锁住这两个值是不够的，因为当我们在另一个会话插入id=101的时候，就有可能产生幻读了。所以mysql必须锁住[100,102)和[102,无穷大）这个范围，才能保证不会出现幻读。
     */


}
