package com.jihan.ironwill.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jihan.ironwill.utils.toDisplayTime
import com.jihan.ironwill.utils.totalDays

@Composable
fun HomeScreen() {
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        val currentTime = rememberSaveable { 1734456247000 }

        var time by remember { mutableLongStateOf(0L) }

        LaunchedEffect(Unit) {
            while (true) {
                time = System.currentTimeMillis() - currentTime
                kotlinx.coroutines.delay(1000)
            }
        }
        val hours = (time / (1000 * 60 * 60)) % 24
        val minutes = (time / (1000 * 60)) % 60
        val seconds = (time / 1000) % 60

        Box {


            Column(
                modifier = Modifier.size(300.dp).clip(RoundedCornerShape(100))
                    .background(
                        color = Color.Black.copy(alpha = .3f)
                    ),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text("It has been", fontSize = 22.sp)

                Text(text = time.totalDays(), fontSize = 45.sp)

                Row(Modifier, horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    ColumnItem(hours, "Hours")
                    ColumnItem(minutes, "Minutes")
                    ColumnItem(seconds, "Seconds")
                }
            }

            IconButton(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(Color.Red.copy(alpha = .7f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = "Refresh",
                        tint = Color.White
                    )
                }
            }



        }


    }
}

@Composable
private fun ColumnItem(text1:Long,text2:String) {
    Column(Modifier.background(color = Color.Transparent), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("$text1", fontWeight = FontWeight.Bold)
        Text(text2)
    }
}