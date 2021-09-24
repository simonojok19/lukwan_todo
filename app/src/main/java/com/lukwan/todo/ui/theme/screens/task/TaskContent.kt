package com.lukwan.todo.ui.theme.screens.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.lukwan.todo.components.PriorityDropDown
import com.lukwan.todo.data.models.Priority
import com.lukwan.todo.ui.theme.LARGE_PADDING
import com.lukwan.todo.ui.theme.MEDIUM_PADDING
import com.lukwan.todo.utils.Constants

@Composable
fun TaskContent(
    title: String,
    onTitleChange: (newTitle: String) -> Unit,
    description: String,
    onDescriptionChange: (newDescription: String) -> Unit,
    priority: Priority,
    onPrioritySelected: (priority: Priority) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .padding(all = LARGE_PADDING)
    ) {

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = onTitleChange,
            label = { Text("Title") },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )

        Divider(modifier = Modifier.height(MEDIUM_PADDING), color = MaterialTheme.colors.background)

        PriorityDropDown(priority = priority, onPrioritySelected = onPrioritySelected)

        Spacer(modifier = Modifier.height(MEDIUM_PADDING))

        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description,
            onValueChange = onDescriptionChange,
            label = {
                Text(
                    text = "Description"
                )
            })
    }

}

@Preview
@Composable
fun TextContentPreview() {
    TaskContent(
        title = "Pass Turing Interview",
        onTitleChange = {},
        description = "I need to pass turing interview so that I can get job of my own and take care of my mum",
        onDescriptionChange = {},
        priority = Priority.HIGH,
        onPrioritySelected = {}
    )
}