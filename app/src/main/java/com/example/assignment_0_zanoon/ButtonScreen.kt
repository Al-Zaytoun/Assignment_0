package com.example.assignment_0_zanoon

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

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
    var pressedCount by remember { mutableStateOf(0) }


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Row Containing name and Text heading
        Column(
            modifier = Modifier
                .fillMaxHeight(0.50f)
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Zanoon Hassan - ID: 1902007", fontSize = 20.sp, textAlign = TextAlign.Center)
            Text("CCID: zanoon", fontSize = 20.sp, textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(24.dp))

            // PLACEHOLDER TEXT
            Text("Do you like CMPUT_301?", fontSize = 20.sp, textAlign = TextAlign.Center)
        }

        // Box Containing buttons and displayed output text
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            // Section for showcasing the different buttons
            Column(
                modifier = Modifier
                    .fillMaxWidth(1.0f)
                    .fillMaxHeight(1.0f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    buttons.forEachIndexed { index, button ->
                        Button(
                            modifier = Modifier.padding(8.dp),
                            onClick = {
                                selectedButton = button
                                showOutputText = onGetOutput(button)
                                pressedCount ++
                            }, colors = ButtonDefaults.buttonColors(
                                containerColor = if (selectedButton == button) {
                                    Color.Gray
                                } else {
                                    Color.Unspecified
                                }
                            )
                        ) {
                            Text(button.text)
                        }
                    }

                }
                Text(
                    text = "Buttons pressed: $pressedCount",
                    fontSize = 18.sp
                )

                // This is the UI section for showing the output based on the button pressed
                if (showOutputText.isNotBlank()) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .border(
                                width = 2.dp,
                                color = Color.Black,
                                shape = RoundedCornerShape(8.dp)
                            )

                    ) {
                        Text(showOutputText, fontSize = 30.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                    }
                }
            }

        }
    }
}