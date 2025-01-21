package com.assignment.popularityvote.feature.login.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.assignment.popularityvote.common.compose.PopularityVoteText

@Composable
fun LoginTextField(
    value: String = "",
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        textStyle = TextStyle(
            color = Color(0xFFAEAEB2)
        ),
        placeholder = {
            PopularityVoteText(
                text = "Enter your ID",
                style = TextStyle(
                    color = Color(0xFFAEAEB2)
                )
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(8.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFF242122),
            unfocusedContainerColor = Color(0xFF242122),
            focusedBorderColor = Color(0xFFDBDBDB),
            unfocusedBorderColor = Color(0xFFDBDBDB)
        ),
    )
}

@Preview
@Composable
private fun LoginTextFieldPreview() {
    val textState = remember { mutableStateOf("") }

    LoginTextField(
        value = textState.value,
        onValueChange = {
            textState.value = it
        }
    )
}