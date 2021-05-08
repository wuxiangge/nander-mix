/**
 * @author zhangnan
 * @date 2021/5/8 9:49
 * <p>
 * 数组遍历
 * void traverse(int[] arr) {
 * for(int i = 0; i<arr.length;i++){
 * // 迭代访问arr[i]
 * }
 * <p>
 * 链表遍历
 * class ListNode{
 * int val;
 * ListNode next;
 * }
 * <p>
 * void traverse(ListNode head) {
 * for(ListNode p = head; p!=null; p = p.next){
 * // p.val
 * }
 * }
 * <p>
 * <p>
 * void traverse(ListNode head){
 * // 递归 head.val;
 * traverse(head.next);
 * }
 * <p>
 * 二叉树遍历
 * class TreeNode{
 * int val;
 * TreeNode left,right;
 * }
 * <p>
 * void traverse(TreeNode root) {
 * traverse(root.left)
 * traverse(root.right)
 * }
 * <p>
 * <p>
 * N叉树遍历
 * class TreeNode {
 * int val;
 * TreeNode[] children;
 * }
 * <p>
 * void traverse(TreeNode root) {
 * for (TreeNode child : root.children)
 * traverse(child);
 * }
 * <p>
 * <p>
 * <p>
 * void traverse(TreeNode root) {
 * // 前序遍历
 * traverse(root.left)
 * // 中序遍历
 * traverse(root.right)
 * // 后序遍历
 * }
 * <p>
 * <p>
 * <p>
 * 动态规划
 * 求解动态规划的核心是穷举
 * 存在重复子问题
 * 使用[dp table] 或者 [备忘录] memoization
 * 最优子结构
 * <p>
 * 状态转移方程
 * <p>
 * 初始化 base case
 * dp[0][0][...] = base
 * # 进行状态转移
 * for 状态1 in 状态1的所有取值：
 * for 状态2 in 状态2的所有取值：
 * for ...
 * dp[状态1][状态2][...] = 求最值(选择1，选择2...)
 * <p>
 * 画出递归树
 * <p>
 * 备忘录
 * int fib(int N) {
 * if (N < 1) return 0;
 * // 备忘录全初始化为 0
 * vector<int> memo(N + 1, 0);
 * // 进行带备忘录的递归
 * return helper(memo, N);
 * }
 * <p>
 * int helper(vector<int>& memo, int n) {
 * // base case
 * if (n == 1 || n == 2) return 1;
 * // 已经计算过
 * if (memo[n] != 0) return memo[n];
 * memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
 * return memo[n];
 * }
 * 备忘录解法 自顶向下
 * 动态规划 自底向上
 * <p>
 * 动态规划一般脱离递归 由循环迭代完成
 * <p>
 * dp数组迭代解法
 * <p>
 * int fib(int N) {
 * if (N < 1) return 0;
 * if (N == 1 || N == 2) return 1;
 * vector<int> dp(N + 1, 0);
 * // base case
 * dp[1] = dp[2] = 1;
 * for (int i = 3; i <= N; i++)
 * dp[i] = dp[i - 1] + dp[i - 2];
 * return dp[N];
 * }
 * <p>
 * 状态压缩
 * int fib(int n) {
 * if (n < 1) return 0;
 * if (n == 2 || n == 1)
 * return 1;
 * int prev = 1, curr = 1;
 * for (int i = 3; i <= n; i++) {
 * int sum = prev + curr;
 * prev = curr;
 * curr = sum;
 * }
 * return curr;
 * }
 * <p>
 * 1、确定 base case，这个很简单，显然目标金额 amount 为 0 时算法返回 0，因为不需要任何硬币就已经凑出目标金额了。
 * 2、确定「状态」，也就是原问题和子问题中会变化的变量。由于硬币数量无限，硬币的面额也是题目给定的，只有目标金额会不断地向 base case 靠近，所以唯一的「状态」就是目标金额 amount。
 * 3、确定「选择」，也就是导致「状态」产生变化的行为。目标金额为什么变化呢，因为你在选择硬币，你每选择一枚硬币，就相当于减少了目标金额。所以说所有硬币的面值，就是你的「选择」。
 * 4、明确 dp 函数/数组的定义。我们这里讲的是自顶向下的解法，所以会有一个递归的 dp 函数，一般来说函数的参数就是状态转移中会变化的量，也就是上面说到的「状态」；
 * 函数的返回值就是题目要求我们计算的量。就本题来说，状态只有一个，即「目标金额」，题目要求我们计算凑出目标金额所需的最少硬币数量。所以我们可以这样定义 dp 函数：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 回溯算法框架
 * DFS 本质是一种暴力穷举法
 * <p>
 * <p>
 * 1、路径：也就是已经做出的选择。
 * 2、选择列表：也就是你当前可以做的选择。
 * 3、结束条件：也就是到达决策树底层，无法再做选择的条件。
 * <p>
 * <p>
 * 框架
 * result = []
 * def backtrack(路径, 选择列表):
 * if 满足结束条件:
 * result.add(路径)
 * return
 * <p>
 * for 选择 in 选择列表:
 * 做选择
 * backtrack(路径, 选择列表)
 * 撤销选择
 * <p>
 * 解决一个回溯问题 实际上就是一个决策树的遍历过程
 * <p>
 * 决策树
 * 为啥说这是决策树呢，因为你在每个节点上其实都在做决策
 */
package labuladong;