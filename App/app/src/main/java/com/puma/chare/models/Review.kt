package com.puma.chare.models

import java.util.Date

data class Review (var Re_Id: Int?, var Re_DateTime: Date,
                   var Re_Rating: Int, var Re_Text: String,
                   var Re_Rater: Profile, var Re_Rated: Profile){
}