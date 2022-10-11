package com.puma.chare.models

import java.util.Date

data class Profile (var Pr_Id: Int?, var Pr_FirstName: String, var Pr_LastName: String,
                    var Pr_BirthDate: Date, var Pr_Img: String?, var Pr_DriveDistance: Int
                    ,var Pr_DriveNum: Int, var Pr_RideDistance: Int, var Pr_RideNum: Int,
                    var Pr_Email: String, private var Pr_Password: String, var Pr_Bio: String,
                    var Pr_ProfileInterest: MutableList<Interest>?){
}