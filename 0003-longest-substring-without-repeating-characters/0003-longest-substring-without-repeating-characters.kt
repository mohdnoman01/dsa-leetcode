class Solution {
    fun lengthOfLongestSubstring(s: String): Int {

        val set = HashSet<Char>()

        var left = 0
        var maxLength = 0

        for (right in s.indices) {

            val current = s[right]

            while (set.contains(current)) {
                set.remove(s[left])
                left++
            }

            set.add(current)

            maxLength = maxOf(maxLength, right - left + 1)
        }

        return maxLength
    }
}