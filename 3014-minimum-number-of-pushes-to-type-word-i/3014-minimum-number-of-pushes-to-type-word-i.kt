class Solution {
    fun minimumPushes(word: String): Int {
        var pushes = 0

        for (i in word.indices) {
            pushes += (i / 8) + 1
        }

        return pushes
    }
}