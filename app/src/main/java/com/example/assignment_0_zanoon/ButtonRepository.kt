package com.example.assignment_0_zanoon

// Class designed for handling the button data class directly
class ButtonRepository {
    private val _buttons = listOf(
        Button("Yes", 50),
        Button("Not really", 25),
        Button("No", 10)
    )

    val buttons: List<Button>
        get() = _buttons

    fun getText(individualButton: Button): String {
        return individualButton.text
    }


    fun getProbability(individualButton: Button): Int {
        return individualButton.probability
    }


    fun getOutput(individualButton: Button): String {
        val chosenProbability = getProbability(individualButton)
        val randomNumber = (1..chosenProbability).random()


        return if (randomNumber < chosenProbability / 2) {
            "YES"
        } else {
            "NO"
        }
    }
}
