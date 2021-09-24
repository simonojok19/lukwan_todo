package com.lukwan.todo.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lukwan.todo.data.models.Priority
import com.lukwan.todo.ui.theme.PRIORITY_DROP_DOWN_HEIGHT
import com.lukwan.todo.ui.theme.PRIORITY_INDICATOR_SIZE

@Composable
fun PriorityDropDown(
    priority: Priority,
    onPrioritySelected: (priority: Priority) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val angle: Float by animateFloatAsState(targetValue = if (expanded) 180f else 0f)

    Row(modifier = Modifier
        .fillMaxWidth()
        .height(PRIORITY_DROP_DOWN_HEIGHT)
        .background(MaterialTheme.colors.background)
        .clickable { expanded = true }
        .border(
            width = 1.dp,
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled)
        )
        .padding(16.dp), verticalAlignment = Alignment.CenterVertically) {


        Canvas(
            modifier = Modifier
                .size(PRIORITY_INDICATOR_SIZE)
                .weight(1f)
        ) {
            drawCircle(color = priority.color)
        }
        Text(
            modifier = Modifier.weight(8f),
            text = priority.name,
            style = MaterialTheme.typography.subtitle2
        )
        IconButton(modifier = Modifier
            .alpha(ContentAlpha.medium)
            .rotate(angle)
            .weight(.15f), onClick = { expanded = true }) {
            Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = null)
        }

        DropdownMenu(
            modifier = Modifier.fillMaxWidth(),
            expanded = expanded,
            onDismissRequest = { expanded = false }) {
            DropdownMenuItem(onClick = {
                expanded = false
                onPrioritySelected(Priority.LOW)
            }) {
                PriorityItem(priority = Priority.LOW)
            }

            DropdownMenuItem(onClick = {
                expanded = false
                onPrioritySelected(Priority.MEDIUM)
            }) {
                PriorityItem(priority = Priority.MEDIUM)
            }

            DropdownMenuItem(onClick = {
                expanded = false
                onPrioritySelected(Priority.HIGH)
            }) {
                PriorityItem(priority = Priority.HIGH)
            }

        }

    }

}

@Preview
@Composable
fun PriorityDropDownPreview() {
    PriorityDropDown(priority = Priority.LOW, onPrioritySelected = {})
}