package com.lukwan.todo.ui.theme.screens.list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.lukwan.todo.R
import com.lukwan.todo.components.PriorityItem
import com.lukwan.todo.data.models.Priority
import com.lukwan.todo.ui.theme.*

@Composable
fun ListTopAppBar(
    onSearchClick: () -> Unit,
    onSortClick: (priority: Priority) -> Unit,
    onDeleteClick: () -> Unit
) {
//    DefaultListTopAppBar(
//        onSearchClick = onSearchClick,
//        onSortClick = onSortClick,
//        onDeleteClick = onDeleteClick
//    )
    SearchAppBar(text = "", onTextChange = {}, onCloseClicked = { }, onSearchClick = {})
}

@Composable
fun DefaultListTopAppBar(
    onSearchClick: () -> Unit,
    onSortClick: (priority: Priority) -> Unit,
    onDeleteClick: () -> Unit
) {
    TopAppBar(title = {
        Text(text = "Tasks", color = MaterialTheme.colors.topAppBarContentColor)
    }, backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor, actions = {
        ListAppBarActions(
            onSearchClick = onSearchClick,
            onSortClick = onSortClick,
            onDeleteClick = onDeleteClick
        )
    })
}

@Composable
fun ListAppBarActions(
    onSearchClick: () -> Unit,
    onSortClick: (priority: Priority) -> Unit,
    onDeleteClick: () -> Unit
) {
    SearchAction(onSearchClick = onSearchClick)
    SortAction(onSortClick = onSortClick)
    DeleteAllAction(onDeleteClick = onDeleteClick)
}

@Composable
fun SearchAction(
    onSearchClick: () -> Unit
) {
    IconButton(onClick = onSearchClick) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search_button_description),
            tint = MaterialTheme.colors.topAppBarContentColor,
        )
    }
}

@Composable
fun SortAction(
    onSortClick: (priority: Priority) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    IconButton(onClick = {
        expanded = true
    }) {
        Icon(
            painter = painterResource(id = R.drawable.filter_a_list),
            contentDescription = stringResource(
                id = R.string.sort_button_description

            ),
            tint = MaterialTheme.colors.topAppBarContentColor,
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(onClick = {
                expanded = false
                onSortClick(Priority.LOW)
            }) {
                PriorityItem(priority = Priority.LOW)
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onSortClick(Priority.HIGH)
            }) {
                PriorityItem(priority = Priority.HIGH)
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onSortClick(Priority.NONE)
            }) {
                PriorityItem(priority = Priority.NONE)
            }

        }
    }

}

@Composable
fun DeleteAllAction(
    onDeleteClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.vertical_menu),
            contentDescription = stringResource(
                id = R.string.delete_all_action,
            ),
            tint = MaterialTheme.colors.topAppBarContentColor,
        )

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(onClick = {
                expanded = false
                onDeleteClick()
            }) {
                Text(
                    text = stringResource(id = R.string.delete_all_action),
                    style = Typography.subtitle2,
                    modifier = Modifier.padding(start = LARGE_PADDING)
                )
            }
        }
    }
}

@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (text: String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClick: () -> Unit
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.topAppBarBackgroundColor
    ) {
        TextField(
            value = text, onValueChange = onTextChange, modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Search...",
                    color = Color.White,
                    modifier = Modifier.alpha(ContentAlpha.medium),
                )
            },
            textStyle = TextStyle(
                color = MaterialTheme.colors.topAppBarContentColor,
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = MaterialTheme.colors.topAppBarContentColor,
                        modifier = Modifier.alpha(ContentAlpha.disabled)
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = onCloseClicked) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close Icon",
                        tint = MaterialTheme.colors.topAppBarContentColor
                    )
                }
            }
        )
    }

}


@Composable
@Preview
fun SearchAppBarPreview() {
    SearchAppBar(text = "", onTextChange = {}, onCloseClicked = { /*TODO*/ }, onSearchClick = {})
}

@Composable
@Preview
fun DefaultListTopAppBarPreview() {
    DefaultListTopAppBar(onSearchClick = {}, onSortClick = {}, onDeleteClick = {})
}

