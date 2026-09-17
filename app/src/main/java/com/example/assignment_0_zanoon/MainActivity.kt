package com.example.assignment_0_zanoon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment_0_zanoon.ui.theme.Assignment_0_zanoonTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment_0_zanoonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ButtonScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
