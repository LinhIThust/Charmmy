package com.example.viewpagerinfinity.models

import android.provider.MediaStore

data class Ranking (
    var id :String,
    var thumbnail :String,
    var category: Category,
    var title : String,
    var rank :Int
)