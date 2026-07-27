class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

        var A = nums1
        var B = nums2

        // Always binary search on the smaller array
        if (A.size > B.size) {
            val temp = A
            A = B
            B = temp
        }

        val m = A.size
        val n = B.size

        var left = 0
        var right = m

        while (left <= right) {

            val partitionA = (left + right) / 2
            val partitionB = (m + n + 1) / 2 - partitionA

            val maxLeftA =
                if (partitionA == 0) Int.MIN_VALUE else A[partitionA - 1]

            val minRightA =
                if (partitionA == m) Int.MAX_VALUE else A[partitionA]

            val maxLeftB =
                if (partitionB == 0) Int.MIN_VALUE else B[partitionB - 1]

            val minRightB =
                if (partitionB == n) Int.MAX_VALUE else B[partitionB]

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {

                return if ((m + n) % 2 == 0) {
                    (maxOf(maxLeftA, maxLeftB) +
                     minOf(minRightA, minRightB)) / 2.0
                } else {
                    maxOf(maxLeftA, maxLeftB).toDouble()
                }

            } else if (maxLeftA > minRightB) {
                right = partitionA - 1
            } else {
                left = partitionA + 1
            }
        }

        return 0.0
    }
}