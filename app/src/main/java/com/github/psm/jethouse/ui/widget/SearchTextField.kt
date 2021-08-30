package com.github.psm.jethouse.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.psm.jethouse.R
import com.github.psm.jethouse.ui.theme.JetHouseTheme

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = ""
) {
    var textFieldValueState by remember { mutableStateOf(TextFieldValue(text = value)) }
    val textFieldValue = textFieldValueState.copy(text = value)
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(colorResource(id = R.color.clubhouse_eggshell_shade)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = {  }) {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "Search",
                tint = colorResource(id = R.color.clubhouse_eggshell_dark).copy(alpha = 0.6f)
            )
        }

        Box(
            modifier = Modifier.weight(1f)
        ) {
            if (value.isEmpty()) {
                Text(
                    text = placeholder,
                    color = colorResource(id = R.color.clubhouse_eggshell_dark).copy(alpha = 0.6f)
                )
            }
            BasicTextField(
                modifier = Modifier.fillMaxWidth(),
                value = textFieldValue,
                onValueChange = {
                    textFieldValueState = it
                    if (value != it.text) {
                        onValueChange(it.text)
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun SearchTextFieldPrev() {
    JetHouseTheme {
        SearchTextField(
            value = "",
            onValueChange = { },
            placeholder = "Placeholder"
        )
    }
}