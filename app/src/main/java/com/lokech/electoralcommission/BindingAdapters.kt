package com.lokech.electoralcommission

import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lokech.electoralcommission.data.Party
import com.lokech.electoralcommission.data.Picture
import com.lokech.electoralcommission.gallery.PictureListAdapter
import com.lokech.electoralcommission.parties.PartyListAdapter
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("imageUrl")
fun CircleImageView.bindImage(imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
//        val imgUri = imgUrl.toUri().buildUpon().build()
        Glide.with(context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.ic_broken_image)
            )
            .into(this)
    }
}


@BindingAdapter("imageUrl")
fun ImageView.bindImage(imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.ic_broken_image)
            )
            .into(this)
    }
}

@BindingAdapter("addClickAnimation")
fun View.addClickAnimation(shouldAdd: Boolean?) =
    shouldAdd?.let {
        val attrs = intArrayOf(R.attr.selectableItemBackground)
        val typedArray = context.obtainStyledAttributes(attrs)
        val backgroundResource = typedArray.getResourceId(0, 0)
        setBackgroundResource(backgroundResource)
        typedArray.recycle()
    }


@BindingAdapter("addDivider")
fun RecyclerView.addDivider(shouldAdd: Boolean?) =
    shouldAdd?.let {
        if (it) {
            val itemDec = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            itemDec.setDrawable(ContextCompat.getDrawable(context, R.drawable.divider)!!)
            addItemDecoration(itemDec)
        }
    }

@BindingAdapter("pictureList")
fun RecyclerView.bindPictureList(pictures: List<Picture>?) {
    pictures?.let {
        (adapter as PictureListAdapter).submitList(pictures)
    }
}

@BindingAdapter("partyList")
fun RecyclerView.bindPartyList(partyList: List<Party>?) {
    partyList?.let {
        (adapter as PartyListAdapter).submitList(it)
    }
}


@BindingAdapter("viewPagerList")
fun ViewPager2.bindViewPagerList(pictureList: List<String>?) {
    pictureList?.let {
        (adapter as com.lokech.electoralcommission.home.PictureListAdapter).submitList(it)
    }
}
