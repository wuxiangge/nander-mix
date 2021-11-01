package com.cedar.sparsearray.josef;

/**
 * 约瑟夫环问题
 * <p>
 * //约瑟夫环问题的起源来自犹太历史学家约瑟夫和他的朋友以及39其余的犹太人，总共41人为了躲避敌人，藏在一个山洞中，
 * //39个犹太人决定宁愿死也不被敌人抓到，于是决定自杀，所有人排成一个圈，由第一个人开始报数，每当数到3，就自杀。
 * //这个游戏接着从自杀的位置开始，还是从1数到3。依次类推，约瑟夫将朋友和自己安排在了16和31的位置，最后顺利逃过了
 * //自杀这一劫，因为最后就剩他一个人了。
 *
 * @author zhangnan
 * @date 2021-04-18 19:19
 */
public class JosefCircle {


    public class Node {
        public int no;
        public Node next;

        public Node(int no, Node next) {
            this.no = no;
            this.next = next;
        }

        public Node(int no) {
            this(no, null);
        }

        public Node() {
            this(-1, null);
        }
    }


    /**
     * 一共有多少人mun 报数k淘汰
     *
     * @param num
     * @param k
     */
    public void count(int num, int k) {

        Node dummyHead = new Node();
        Node cur = dummyHead;
        for (int i = 1; i <= num; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        cur.next = dummyHead.next;

        // 成环

        Node p = dummyHead.next;

        while (p.next != p) {
            for (int i = 1; i < k - 1; i++) {
                p = p.next;
            }

            System.out.println("go out: " + p.next.no);
            p.next = p.next.next;
            p=p.next;
        }

        //最后剩下的一个结点
        System.out.println("(left:"+p.no+")");

    }

    public static void main(String[] args) {
        JosefCircle josefCircle =
                new JosefCircle();

        josefCircle.count(41,3);
    }
}
