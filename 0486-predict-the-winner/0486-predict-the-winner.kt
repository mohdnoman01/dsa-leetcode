class Solution {

    fun predictTheWinner(nums: IntArray): Boolean {
        val n = nums.size
        val memo = Array(n) { IntArray(n) { Int.MIN_VALUE } }

        fun dfs(left: Int, right: Int): Int {
            if (left == right) return nums[left]

            if (memo[left][right] != Int.MIN_VALUE) {
                return memo[left][right]
            }

            val takeLeft = nums[left] - dfs(left + 1, right)
            val takeRight = nums[right] - dfs(left, right - 1)

            memo[left][right] = maxOf(takeLeft, takeRight)
            return memo[left][right]
        }

        return dfs(0, n - 1) >= 0
    }
}