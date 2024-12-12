package com.course.taskplay.ui.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.course.taskplay.ui.components.AddTaskButton
import com.course.taskplay.ui.components.TaskItem
import com.course.taskplay.ui.components.TaskPlayTopAppBar
import com.course.taskplay.ui.model.Task
import com.course.taskplay.ui.model.TaskListScreenUIState
import com.course.taskplay.ui.theme.TaskPlayTheme

@Composable
fun TaskListScreen() {
    Scaffold(
        topBar = {
            TaskPlayTopAppBar()
        }
    ) { innerPadding ->

        var uiState by remember { mutableStateOf(TaskListScreenUIState()) }

        Column(modifier = Modifier.padding(innerPadding)) {
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            ) {
                items(uiState.tasks) { task ->
                    TaskItem(
                        text = task.name,
                        checked = task.isChecked,
                    ) { checked ->
                        uiState = onChangeTaskStatus(uiState, task, checked)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                val transition =
                    updateTransition(targetState = uiState.addTaskState, label = "AddTaskTransition")

                val textFieldAlpha by transition.animateFloat(label = "TextFieldAlpha") { state ->
                    if (state) 1f else 0f
                }

                val buttonAlpha by transition.animateFloat(label = "ButtonAlpha") { state ->
                    if (state) 0f else 1f
                }

                BackHandler(enabled = uiState.addTaskState) {
                    uiState = onBack(uiState)
                }

                if (uiState.addTaskState) {
                    val focusRequester = remember { FocusRequester() }
                    var isFocused by remember { mutableStateOf(false) }

                    TextField(
                        value = uiState.task?.name.orEmpty(),
                        onValueChange = {
                            if (it.length <= 20)
                                uiState = uiState.copy(task = Task(name = it, isChecked = false))
                        },
                        label = { Text("Add Task") },
                        singleLine = true,
                        keyboardActions = KeyboardActions(
                            onDone = {
                                uiState = onDone(uiState)
                            }
                        ),
                        shape = RoundedCornerShape(16.dp),
                        colors = TextFieldDefaults.colors().copy(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester)
                            .onFocusChanged { focusState ->
                                isFocused = focusState.isFocused
                            }
                            .alpha(textFieldAlpha)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    LaunchedEffect(Unit) {
                        focusRequester.requestFocus()
                    }
                } else {
                    AddTaskButton(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .alpha(buttonAlpha)
                    ) { uiState = onClickAddTask(uiState) }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
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