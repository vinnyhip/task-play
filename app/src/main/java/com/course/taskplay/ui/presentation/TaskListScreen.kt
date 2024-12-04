package com.course.taskplay.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    TaskItem()
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            AddTaskButton(modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun TaskItem() {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Checkbox(
                checked = true,
                onCheckedChange = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Task 1",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

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

@Preview
@Composable
fun TaskListPreview() {
    TaskPlayTheme {
        TaskListScreen()
    }
}