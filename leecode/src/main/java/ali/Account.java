package ali;

/**
 * 以账户建立模型
 *
 * @author zhangnan
 * @className Solution
 * @date 2021/9/3
 * @description //TODO
 */
public class Account {

    private String accountId = "";

    private int balance = 1000000;

    public Account(String accountId) {
        this.accountId = accountId;
    }


    /**
     * 存钱
     *
     * @param money
     */
    public void saveMoney(int money) {
        this.balance += money;
    }

    /**
     * 取钱
     */
    public void drawMoney(int money) {
        this.balance -= money;
    }

    /**
     * 获取账户余额
     */
    public int obtainMoney() {
        return this.balance;
    }

    public String getAccountId() {
        return this.accountId;
    }

}

