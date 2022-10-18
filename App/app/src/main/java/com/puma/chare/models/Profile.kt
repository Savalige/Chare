package com.puma.chare.models

import java.util.Date

data class Profile (var pr_Id: Int?, var pr_Firstname: String, var pr_Lastname: String,
                    var pr_BirthDate: Date?, var pr_Img: String?, var pr_DriveDistance: Int
                    ,var pr_DriveNum: Int, var pr_RideDistance: Int, var pr_RideNum: Int,
                    var pr_Email: String, var pr_Password: String, var pr_Bio: String,
                    var pr_ProfileInterest: MutableList<Interest>?){
    constructor() : this(null,"","",null,null,
        0,0,0,0,"",
        "","",null)
}