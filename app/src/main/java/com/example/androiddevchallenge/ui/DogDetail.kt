/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.model.DogRepo
import com.example.androiddevchallenge.ui.theme.purple200
import com.example.androiddevchallenge.ui.theme.purple700
import com.example.androiddevchallenge.ui.theme.teal200
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

@Composable
fun DogDetail(
    navController: NavController,
    dogId: Long
) {
    val dog = remember(dogId) { DogRepo.getDog(dogId) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Title(dog)
        DogImage(imageUrl = dog.imageUrl, dog.name, modifier = Modifier.size(220.dp))
    }
    Up(upPress = { navController.navigateUp() })
}

@Composable
private fun Header() {
    Spacer(
        modifier = Modifier
            .height(280.dp)
            .fillMaxWidth()
            .background(Brush.horizontalGradient(listOf(purple200, purple700)))
    )
}

@Composable
private fun Up(upPress: () -> Unit) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .size(36.dp)
            .background(
                color = Color.Black.copy(alpha = 0.32f),
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            tint = MaterialTheme.colors.primary,
            contentDescription = "back"
        )
    }
}

@Composable
private fun Body() {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
        Column {
            Spacer(Modifier.height(180.dp))
            Surface(Modifier.fillMaxWidth()) {
                Column {
                    Spacer(Modifier.height(115.dp))
                    Spacer(Modifier.height(128.dp))

                    Spacer(Modifier.height(16.dp))
                    Text(
                        text = "Dog Details",
                        style = MaterialTheme.typography.overline,
                        color = teal200,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "Dog",
                        style = MaterialTheme.typography.body1,
                        color = teal200,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )

                    Spacer(Modifier.height(40.dp))
                    Spacer(Modifier.height(16.dp))
                    Spacer(
                        modifier = Modifier
                            .padding(bottom = 56.dp)
                            .navigationBarsPadding(left = false, right = false)
                            .height(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun Title(dog: Dog) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .heightIn(min = 128.dp)
            .background(color = Color.Gray)
    ) {
        Spacer(Modifier.height(16.dp))
        Text(
            text = dog.name,
            style = MaterialTheme.typography.h4,
            color = purple200,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Text(
            text = dog.age,
            style = MaterialTheme.typography.subtitle2,
            fontSize = 20.sp,
            color = teal200,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Spacer(Modifier.height(8.dp))
        Divider()
    }
}
