package com.example.instagramclonedemo.data.mocklist

import com.example.instagramclonedemo.R
import com.example.instagramclonedemo.data.model.*
import com.example.instagramclonedemo.util.Util.getSpannableText

object MockData {

    fun getHomeStoriesList(): List<HomeStoriesModel> {
        val list: ArrayList<HomeStoriesModel> = arrayListOf()
        list.add(HomeStoriesModel(R.drawable.user_img_12, "Your Story"))
        list.add(HomeStoriesModel(R.drawable.photo_2, "karennne"))
        list.add(HomeStoriesModel(R.drawable.photo_1, "zackjohn"))
        list.add(HomeStoriesModel(R.drawable.photo_4, "kieron_d"))
        list.add(HomeStoriesModel(R.drawable.photo_3, "amanda"))
        return list
    }

    fun getHomePostsList(): List<HomePostModel> {
        val list: ArrayList<HomePostModel> = arrayListOf()
        list.add(
            HomePostModel(
                R.drawable.photo_7,
                "joshua_l",
                "Tokyo, Japan",
                R.drawable.vertical_img_5,
                "Liked: 4550",
                getSpannableText(
                    "joshua_l",
                    "The food in Japan was amazing and I want to share some photo"
                )
            )
        )
        list.add(
            HomePostModel(
                R.drawable.photo_6,
                "jose_f",
                "La Paz, Bolivia",
                R.drawable.vertical_img_6,
                "Liked: 255",
                getSpannableText(
                    "jose_f",
                    "The food in Bolivia was amazing and I want to share some photo"
                )
            )
        )
        list.add(
            HomePostModel(
                R.drawable.photo_5,
                "monica_89",
                "London, England",
                R.drawable.vertical_img_7,
                "Liked: 1201",
                getSpannableText(
                    "monica_89",
                    "The food in England was amazing and I want to share some photo"
                )
            )
        )

        return list
    }

    fun getMessagesList(): List<DirectMessagesModel> {
        val list: ArrayList<DirectMessagesModel> = arrayListOf()
        list.add(
            DirectMessagesModel(
                R.drawable.photo_1,
                "joshua_l",
                "Have a nice day, Joshua!",
                "now"
            )
        )
        list.add(
            DirectMessagesModel(
                R.drawable.photo_2,
                "karennne",
                "Have a nice day, Karen!",
                "now"
            )
        )
        list.add(
            DirectMessagesModel(
                R.drawable.photo_3,
                "martini_rond",
                "Have a nice day, Martin!",
                "15m"
            )
        )
        list.add(
            DirectMessagesModel(
                R.drawable.photo_4,
                "andrewww_",
                "Have a nice day, Andrew!",
                "20m"
            )
        )
        list.add(
            DirectMessagesModel(
                R.drawable.photo_5,
                "kiero_d",
                "Have a nice day, Kiero!",
                "1m"
            )
        )
        list.add(
            DirectMessagesModel(
                R.drawable.photo_6,
                "maxjacobson",
                "Have a nice day, Max!",
                "2h"
            )
        )
        list.add(
            DirectMessagesModel(
                R.drawable.photo_7,
                "jamie.franco",
                "Have a nice day, Jamie!",
                "2h"
            )
        )
        list.add(
            DirectMessagesModel(
                R.drawable.photo_1,
                "joshua_l",
                "Have a nice day, Joshua!",
                "now"
            )
        )
        list.add(
            DirectMessagesModel(
                R.drawable.photo_2,
                "karennne",
                "Have a nice day, Karen!",
                "now"
            )
        )
        list.add(
            DirectMessagesModel(
                R.drawable.photo_3,
                "martini_rond",
                "Have a nice day, Martin!",
                "15m"
            )
        )
        list.add(
            DirectMessagesModel(
                R.drawable.photo_4,
                "andrewww_",
                "Have a nice day, Andrew!",
                "20m"
            )
        )
        list.add(
            DirectMessagesModel(
                R.drawable.photo_5,
                "kiero_d",
                "Have a nice day, Kiero!",
                "1m"
            )
        )
        list.add(
            DirectMessagesModel(
                R.drawable.photo_6,
                "maxjacobson",
                "Have a nice day, Max!",
                "2h"
            )
        )
        list.add(
            DirectMessagesModel(
                R.drawable.photo_7,
                "jamie.franco",
                "Have a nice day, Jamie!",
                "2h"
            )
        )

        return list
    }

    fun getSearchTabsList(): List<SearchModel> {
        val list: ArrayList<SearchModel> = arrayListOf()
        list.add(SearchModel(R.drawable.ic_igtv_small, "IGTV", null))
        list.add(SearchModel(R.drawable.ic_shop, "Shop", null))
        list.add(SearchModel(null, "Style", null))
        list.add(SearchModel(null, "Sports", null))
        list.add(SearchModel(null, "Auto", null))
        return list
    }

    fun getSearchPhotosList(): List<SearchModel> {
        val list: ArrayList<SearchModel> = arrayListOf()
        list.add(SearchModel(null, null, R.drawable.vertical_img_1))
        list.add(SearchModel(null, null, R.drawable.vertical_img_2))
        list.add(SearchModel(null, null, R.drawable.vertical_img_3))
        list.add(SearchModel(null, null, R.drawable.vertical_img_4))
        list.add(SearchModel(null, null, R.drawable.vertical_img_5))
        list.add(SearchModel(null, null, R.drawable.vertical_img_6))
        list.add(SearchModel(null, null, R.drawable.vertical_img_7))
        list.add(SearchModel(null, null, R.drawable.vertical_img_8))
        list.add(SearchModel(null, null, R.drawable.vertical_img_8))
        list.add(SearchModel(null, null, R.drawable.vertical_img_8))
        list.add(SearchModel(null, null, R.drawable.vertical_img_8))
        list.add(SearchModel(null, null, R.drawable.vertical_img_8))
        list.add(SearchModel(null, null, R.drawable.vertical_img_8))
        list.add(SearchModel(null, null, R.drawable.vertical_img_8))
        list.add(SearchModel(null, null, R.drawable.vertical_img_8))
        list.add(SearchModel(null, null, R.drawable.vertical_img_8))
        list.add(SearchModel(null, null, R.drawable.vertical_img_8))
        list.add(SearchModel(null, null, R.drawable.vertical_img_8))
        return list
    }

    fun getProfileStoriesList(): List<ProfileModel> {
        val list: ArrayList<ProfileModel> = arrayListOf()
        list.add(ProfileModel(R.drawable.add_story_img_new, "New"))
        list.add(ProfileModel(R.drawable.photo_1, "Friends"))
        list.add(ProfileModel(R.drawable.photo_2, "Sport"))
        list.add(ProfileModel(R.drawable.photo_3, "Design"))
        return list
    }

    fun getProfilePhotosList(): List<ProfileModel> {
        val list: ArrayList<ProfileModel> = arrayListOf()
        list.add(ProfileModel(R.drawable.vertical_img_1, null))
        list.add(ProfileModel(R.drawable.vertical_img_2, null))
        list.add(ProfileModel(R.drawable.vertical_img_3, null))
        list.add(ProfileModel(R.drawable.vertical_img_4, null))
        list.add(ProfileModel(R.drawable.vertical_img_5, null))
        list.add(ProfileModel(R.drawable.vertical_img_6, null))
        list.add(ProfileModel(R.drawable.vertical_img_7, null))
        list.add(ProfileModel(R.drawable.vertical_img_8, null))
        list.add(ProfileModel(R.drawable.vertical_img_8, null))
        list.add(ProfileModel(R.drawable.vertical_img_8, null))
        list.add(ProfileModel(R.drawable.vertical_img_8, null))
        list.add(ProfileModel(R.drawable.vertical_img_8, null))
        list.add(ProfileModel(R.drawable.vertical_img_8, null))
        list.add(ProfileModel(R.drawable.vertical_img_8, null))
        list.add(ProfileModel(R.drawable.vertical_img_8, null))
        list.add(ProfileModel(R.drawable.vertical_img_8, null))
        list.add(ProfileModel(R.drawable.vertical_img_8, null))
        list.add(ProfileModel(R.drawable.vertical_img_8, null))
        return list
    }

    fun getLikesList(): List<LikesModel> {
        val list: ArrayList<LikesModel> = arrayListOf()
        list.add(LikesModel("New", getNewLikesNestedList()))
        list.add(LikesModel("Today", getTodayLikesNestedList()))
        list.add(LikesModel("This Week", getThisWeekLikesNestedList()))
        list.add(LikesModel("This Month", getThisMonthLikesNestedList()))

        return list
    }

    fun getNewLikesNestedList(): List<LikesNestedModel> {
        val list: ArrayList<LikesNestedModel> = arrayListOf()
        list.add(LikesNestedModel(R.drawable.photo_1, "<b>karennne</b> liked your photo. 1h", R.drawable.likes_img_1))
        return list
    }

    fun getTodayLikesNestedList(): List<LikesNestedModel> {
        val list: ArrayList<LikesNestedModel> = arrayListOf()
        list.add(LikesNestedModel(R.drawable.photo_2, "<b>kiero_d</b> liked your photo. 3h", R.drawable.likes_img_2))
        return list
    }

    fun getThisWeekLikesNestedList(): List<LikesNestedModel> {
        val list: ArrayList<LikesNestedModel> = arrayListOf()
        list.add(LikesNestedModel(R.drawable.photo_3, "<b>craig_love</b> mentioned you in a comment: exactly... 2d", R.drawable.likes_img_3))
        list.add(LikesNestedModel(R.drawable.photo_4, "<b>martini_rond</b> mentioned you in a comment: This is cool 3d", R.drawable.likes_img_4))
        list.add(LikesNestedModel(R.drawable.photo_5, "<b>maxjacobson</b> mentioned you in a comment: Oh man... 1d", R.drawable.likes_img_5))
        return list
    }

    fun getThisMonthLikesNestedList(): List<LikesNestedModel> {
        val list: ArrayList<LikesNestedModel> = arrayListOf()
        list.add(LikesNestedModel(R.drawable.photo_6, "<b>miss_potter</b> liked your photo. 1d", R.drawable.likes_img_6))
        return list
    }
}



















