package uz.datatalim.instagram.model

data class FeedModel(val stories:ArrayList<StoriesModel>?=null,
                     val userImage:String,
                     val userName:String,
                     val location:String,
                     val image :String) {
}