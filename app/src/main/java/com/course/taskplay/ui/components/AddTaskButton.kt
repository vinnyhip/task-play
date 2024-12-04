package com.course.taskplay.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddTaskButton(modifier: Modifier) {
    Button(
        modifier = modifier,
        onClick = { }
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = null)
        Text(text = "Add Task")
    }
}