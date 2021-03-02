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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.model.DogRepo
import com.example.androiddevchallenge.model.dogs
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Home(navController: NavController) {
    val dogs = remember { DogRepo.getDogs() }
    DogList(dogs = dogs, onClick = { navController.navigate("Detail/$it") })
}

@Composable
private fun DogList(dogs: List<Dog>, onClick: (dogId: Long) -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Look at these lovely dogs, they are looking for a Home")
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
        ) {
            items(dogs.size) { index ->
                DogItem(dog = dogs[index], onDogClick = { onClick(dogs[index].id) })
            }
        }
    }
}

@Preview("Dog List")
@Composable
fun DogListPreview() {
    MyTheme {
        val dogs = dogs
        DogList(
            dogs = dogs,
            onClick = {}
        )
    }
}
