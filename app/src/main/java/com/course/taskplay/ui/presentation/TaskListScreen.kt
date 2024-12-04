package com.course.taskplay.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.course.taskplay.ui.components.AddTaskButton
import com.course.taskplay.ui.components.TaskItem
import com.course.taskplay.ui.components.TaskPlayTopAppBar
import com.course.taskplay.ui.theme.TaskPlayTheme

@Composable
fun TaskListScreen() {
    Scaffold(
        topBar = {
            TaskPlayTopAppBar()
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            LazyColumn(modifier = Modifier.padding(16.dp).weight(1f)) {
                items(20) {
                    TaskItem(text = "Task 1", checked = false) {
                        // Handle task item click
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            AddTaskButton(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                // Handle add task button click
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun TaskListPreview() {
    TaskPlayTheme {
        TaskListScreen()
    }
}