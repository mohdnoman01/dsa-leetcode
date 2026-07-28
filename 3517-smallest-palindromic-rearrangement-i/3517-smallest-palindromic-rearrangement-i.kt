class Solution {
    fun smallestPalindrome(s: String): String {
        val freq = IntArray(26)

        for (ch in s) {
            freq[ch - 'a']++
        }

        val firstHalf = StringBuilder()
        var middle = ""

        for (i in 0 until 26) {
            repeat(freq[i] / 2) {
                firstHalf.append(('a'.code + i).toChar())
            }

            if (freq[i] % 2 == 1) {
                middle = ('a'.code + i).toChar().toString()
            }
        }

        val secondHalf = StringBuilder(firstHalf).reverse()

        return firstHalf.toString() + middle + secondHalf.toString()
    }
}