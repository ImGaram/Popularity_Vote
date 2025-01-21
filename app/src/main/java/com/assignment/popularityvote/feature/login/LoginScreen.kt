package com.assignment.popularityvote.feature.login

import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.assignment.popularityvote.R
import com.assignment.popularityvote.common.compose.PopularityVoteButton
import com.assignment.popularityvote.common.compose.TopBar
import com.assignment.popularityvote.common.font.Kantumruy
import com.assignment.popularityvote.feature.login.component.LoginTextField
import com.assignment.popularityvote.feature.util.UserId
import com.assignment.popularityvote.ui.theme.Background
import com.assignment.popularityvote.ui.theme.Primary
import com.assignment.popularityvote.ui.theme.White

@Composable
fun LoginScreen(
    navigateToMain: () -> Unit,
) {
    val idState = remember { mutableStateOf("") }
    val activity = LocalActivity.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        topBar = {
            TopBar(
                modifier = Modifier.fillMaxWidth(),
                exitEnable = true,
                onExitClick = {
                    activity?.finish()
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding())
                .fillMaxSize()
                .background(Background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.img_promote_post),
                contentDescription = "promote post image",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            LoginTextField(
                value = idState.value,
                onValueChange = {
                    idState.value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 32.dp, end = 16.dp)
            )

            PopularityVoteButton(
                onClick = {
                    UserId.setUserId(idState.value)

                    if (UserId.getInstance() != null) navigateToMain()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 24.dp, end = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary
                ),
                text = "Log in",
                textStyle = TextStyle(
                    color = White,
                    fontFamily = Kantumruy,
                    fontWeight = FontWeight.W700,
                    fontSize = 16.sp
                )
            )
        }
    }
}
