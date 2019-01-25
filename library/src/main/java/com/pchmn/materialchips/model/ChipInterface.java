package com.pchmn.materialchips.model;


import android.graphics.drawable.Drawable;
import android.net.Uri;

public interface ChipInterface {

    Object getId();
    Uri getAvatarUri();
    Uri getDetailedUri();
    Drawable getAvatarDrawable();
    Drawable getDetailedDrawable();
    String getLabel();
    String getInfo();
    boolean canShowAvatar();
}
