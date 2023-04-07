package com.example.myapplication.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    @DrawableRes val imageCategory: Int,
    @StringRes val textsCategory: Int
)
