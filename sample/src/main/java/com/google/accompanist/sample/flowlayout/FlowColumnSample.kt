package com.google.accompanist.sample.flowlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.sample.AccompanistSampleTheme
import com.google.accompanist.sample.R
import kotlin.random.Random

class FlowColumnSample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AccompanistSampleTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = stringResource(R.string.flowlayout_title_column)) }
                        )
                    }
                ) { padding ->
                    FlowColumnSampleContent(padding)
                }
            }
        }
    }
}

@Composable
internal fun FlowColumnSampleContent(paddingValues: PaddingValues) {
    val scrollState = rememberScrollState()
    FlowColumn(modifier = Modifier.padding(paddingValues)
        .horizontalScroll(scrollState),
        mainAxisSpacing = 20.dp,
        crossAxisSpacing = 40.dp,
    ) {
        val MIN_WIDTH = 80
        val MAX_WIDTH = 300

        repeat(130) { number ->

            val randomWidth = Random(System.currentTimeMillis()).nextInt(MAX_WIDTH-MIN_WIDTH) + MIN_WIDTH

            Box(
                modifier = Modifier
                    .size(
                        width = randomWidth.dp,
                        height = 50.dp
                    )
                    .background(Color.LightGray)
                    .border(2.dp, Color.DarkGray),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = number.toString())
            }
        }
    }

}