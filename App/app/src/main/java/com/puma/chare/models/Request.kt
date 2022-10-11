package com.puma.chare.models

data class Request (var Rq_Id: Int?, var Rq_Message: String,
               var Rq_Price: Int, var Rq_Start: String, var Rq_Destination: String
               ,var Rq_Profile: Profile, var Rq_Trip: Trip){
}