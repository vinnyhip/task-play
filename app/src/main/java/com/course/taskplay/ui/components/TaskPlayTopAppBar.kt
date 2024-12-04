package com.course.taskplay.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.course.taskplay.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskPlayTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.task_list),
                style = MaterialTheme.typography.titleLarge
            )
        }
    )
}

@Preview
@Composable
fun TaskPlayTopAppBarPreview() {
    TaskPlayTopAppBar()
}