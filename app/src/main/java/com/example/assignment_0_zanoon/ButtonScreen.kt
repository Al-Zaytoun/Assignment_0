package com.example.assignment_0_zanoon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
/*
// TODO: Currently, the repository file, seems to be fine. all thats left is that you have to make each item in the list into a button
       as well as making standard UI on each button through the un-implemented function at the bottom of this file
       and then also include the states such that when a button is pressed, the selected button is assigned to that button, and you can access
       the output via the repository method.
*/
@Composable
fun ButtonScreen(buttons: List<Button>, modifier: Modifier = Modifier, onGetOutput: (Button) -> String) {
    var showOutputText by remember { mutableStateOf("")}
    var selectedButton by remember { mutableStateOf<Button?>(null) }


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Row Containing name and Text heading
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Zanoon Hassan", fontSize = 20.sp)
            Text("CMPUT_301 - Assignment 0", fontSize = 20.sp)


        }


        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(18.dp)
                ) {
                    buttons.forEachIndexed { index, button ->
                        FilledTonalButton(
                            modifier = Modifier.padding(8.dp),
                            onClick = {
                                selectedButton = button
                                showOutputText = onGetOutput(button)

                            }
                        ) {
                            Text(button.text)
                        }
                    }
                }

                if (showOutputText.isNotBlank()) {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(showOutputText)
                    }
                }
            }

        }
        // This is the UI section for showing the output based on the button pressed

    }
}


@Composable
fun ButtonItself(IndividualButton: Button, modifier: Modifier) {
    // This is where the UI for each button will hold

}
