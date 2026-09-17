package com.example.assignment_0_zanoon

// Class designed for handling the button data class directly
class ButtonRepository {
    private val _buttons = listOf(
        Button("Yeah", 50),
        Button("Kind of", 25),
        Button("Nah", 10)
    )

    val buttons: List<Button>
        get() = _buttons
    fun getProbability(individualButton: Button): Int {
        return individualButton.probability
    }

    fun getOutput(individualButton: Button): String {
        val chosenProbability = getProbability(individualButton)
        val randomNumber = (1..100).random()
        return if (randomNumber <= chosenProbability) {
            "YES"
        } else {
            "NO"
        }
    }
}
