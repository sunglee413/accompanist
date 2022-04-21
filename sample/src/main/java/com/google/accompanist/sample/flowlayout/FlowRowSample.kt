/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.accompanist.sample.flowlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.sample.AccompanistSampleTheme
import com.google.accompanist.sample.R
import kotlin.random.Random

class FlowRowSample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AccompanistSampleTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = stringResource(R.string.flowlayout_title_row)) }
                        )
                    }
                ) { _ ->
                    val scrollState = rememberScrollState()
                    FlowRow(
                        Modifier
                            .padding(all = 20.dp)
                            .verticalScroll(scrollState)) {
                        FlowRowSampleContent()
                    }
                }
            }
        }
    }
}

@Composable
internal fun FlowRowSampleContent() {

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