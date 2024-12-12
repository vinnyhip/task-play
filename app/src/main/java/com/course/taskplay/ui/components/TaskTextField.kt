package com.course.taskplay.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TaskTextField(
    value: String,
    onValueChange: (String) -> Unit,
    onDone: () -> Unit,
    focusRequester: FocusRequester,
    isFocused: (Boolean) -> Unit,
    textFieldAlpha: Float
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text("Add Task") },
        singleLine = true,
        keyboardActions = KeyboardActions(
            onDone = { onDone() }
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
            .onFocusChanged { focusState -> isFocused(focusState.isFocused) }
            .alpha(textFieldAlpha)
    )
}