package com.jramirez.soccerteamboard.extensions

import com.jramirez.soccerteamboard.R
import com.jramirez.soccerteamboard.domain.SocialMedia
import com.jramirez.soccerteamboard.domain.Team

fun Team.getSocialMedia(): List<SocialMedia> {
    val socialsMedia = mutableListOf<SocialMedia>()
    if (!facebook.isNullOrEmpty())
        socialsMedia.add(SocialMedia(R.drawable.ic_facebook, facebook))
    if (!instagram.isNullOrEmpty())
        socialsMedia.add(SocialMedia(R.drawable.ic_instagram, instagram))
    if (!twitter.isNullOrEmpty())
        socialsMedia.add(SocialMedia(R.drawable.ic_twitter, twitter))
    if (!website.isNullOrEmpty())
        socialsMedia.add(SocialMedia(R.drawable.ic_chrome, website))
    if (!youtube.isNullOrEmpty())
        socialsMedia.add(SocialMedia(R.drawable.ic_youtube, youtube))
    return socialsMedia
}