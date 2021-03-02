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
package com.example.androiddevchallenge.model

data class Dog(
    val id: Long,
    val name: String,
    val age: String,
    val imageUrl: String
)

val dogs = listOf(
    Dog(
        id = 1L,
        name = "Dulce",
        age = "Adult",
        imageUrl = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50685534/3/?bust=1614490389&width=600"
    ),
    Dog(
        id = 2L,
        name = "JoJo",
        age = "Adult",
        imageUrl = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50609769/1/?bust=1613847383&width=600"
    ),
    Dog(
        id = 3L,
        name = "Bora",
        age = "Adult",
        imageUrl = "https://dl5zpyw5k3jeb.cloudfront.net/photos/pets/50591315/1/?bust=1613678186&width=600"
    )
)
