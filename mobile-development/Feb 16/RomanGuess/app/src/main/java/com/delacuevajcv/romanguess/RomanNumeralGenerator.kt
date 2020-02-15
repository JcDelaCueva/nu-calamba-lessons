package com.delacuevajcv.romanguess

import java.util.*

class RomanNumeralGenerator {
    val map = TreeMap(
        mapOf(
            Pair(1000, "M"),
            Pair(900, "CM"),
            Pair(500, "D"),
            Pair(400, "CD"),
            Pair(100, "C"),
            Pair(90, "XC"),
            Pair(50, "L"),
            Pair(40, "XL"),
            Pair(10, "X"),
            Pair(9, "IX"),
            Pair(5, "V"),
            Pair(4, "IV"),
            Pair(1, "I")
        )
    )

    fun convert(number: Int): String {
        val l = map.floorKey(number)

        if (number == l) {
            return map[number] ?: ""
        }

        return map[l] + convert(number - l)
    }
}
