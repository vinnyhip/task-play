package com.course.taskplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.course.taskplay.ui.presentation.TaskListScreen
import com.course.taskplay.ui.theme.TaskPlayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskPlayTheme {
                TaskListScreen()
            }
        }
    }
}
