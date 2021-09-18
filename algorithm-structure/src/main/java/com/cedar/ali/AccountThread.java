package com.cedar.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 以账户建立模型
 *
 * @author zhangnan
 * @className Solution
 * @date 2021/9/3
 * @description //TODO
 */
public class AccountThread extends Thread {
    //存储20个账户;
    private List<Account> accList = null;

    //每个账户对应一个锁，使得一个线程仅锁当前要操作的两个账户对应的锁;
    Map<Account, ReentrantLock> accLock = null;

    Random random = new Random();
    int accOne = 0;
    int accTwo = 0;
    int money = 0;

    public AccountThread(List<Account> account, Map<Account, ReentrantLock> accLock) {
        this.accList = account;
        this.accLock = accLock;
    }

    private void acquireLocks(Lock lockA, Lock lockB) throws InterruptedException {
        while (true) {
            boolean bLockA = false;
            boolean bLockB = false;
            try {
                bLockA = lockA.tryLock();
                bLockB = lockB.tryLock();
            } finally {
                if (bLockA && bLockB)
                    return;
                else if (bLockA) {
                    lockA.unlock();
                } else if (bLockB) {
                    lockB.unlock();
                }
            }
        }
    }

    public void run() {

        for (int i = 0; i < 100; i++) {
            accOne = random.nextInt(20);
            accTwo = random.nextInt(20);

            //禁止相同账户相互转账;
            while (accOne == accTwo) {
                accTwo = random.nextInt(20);
            }
            money = random.nextInt(100);

            try {
                acquireLocks(accLock.get(accList.get(accOne)), accLock.get(accList.get(accTwo)));
                if (accList.get(accOne).obtainMoney() > money) {
                    accList.get(accOne).drawMoney(money);
                    accList.get(accTwo).saveMoney(money);
                }

            } catch (InterruptedException e) {
                // 这里应该打日志
                e.printStackTrace();
                // 重置终端
                Thread.currentThread().interrupt();
            } finally {
                accLock.get(accList.get(accOne)).unlock();
                accLock.get(accList.get(accTwo)).unlock();
            }
        }
    }


}
