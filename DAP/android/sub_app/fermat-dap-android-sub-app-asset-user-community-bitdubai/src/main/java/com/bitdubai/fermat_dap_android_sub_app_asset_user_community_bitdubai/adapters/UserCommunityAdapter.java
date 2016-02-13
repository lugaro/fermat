package com.bitdubai.fermat_dap_android_sub_app_asset_user_community_bitdubai.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import com.bitdubai.fermat_android_api.ui.adapters.FermatAdapter;
import com.bitdubai.fermat_dap_android_sub_app_asset_user_community_bitdubai.R;
import com.bitdubai.fermat_dap_android_sub_app_asset_user_community_bitdubai.holders.UserViewHolder;
import com.bitdubai.fermat_dap_android_sub_app_asset_user_community_bitdubai.interfaces.AdapterChangeListener;
import com.bitdubai.fermat_dap_android_sub_app_asset_user_community_bitdubai.models.Actor;
import com.bitdubai.fermat_dap_api.layer.all_definition.enums.DAPConnectionState;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserCommunityAdapter extends FermatAdapter<Actor, UserViewHolder> {

    private AdapterChangeListener<Actor> adapterChangeListener;

    public UserCommunityAdapter(Context context) {
        super(context);
    }

    public UserCommunityAdapter(Context context, List<Actor> dataSet) {
        super(context, dataSet);
    }

    @Override
    protected UserViewHolder createHolder(View itemView, int type) {
        return new UserViewHolder(itemView);
    }

    @Override
    protected int getCardViewResource() {
        return R.layout.row_actor;
    }

    @Override
    protected void bindHolder(final UserViewHolder holder, final Actor data, final int position) {
        try {
            holder.name.setText(String.format("%s", data.getName()));
            if (data.getCryptoAddress() != null) {
                holder.connectionState.setVisibility(View.VISIBLE);
                holder.connect.setVisibility(View.GONE);
                //holder.
                //holder.crypto.setText("CryptoAddress: YES");
            } else {
                holder.connectionState.setVisibility(View.GONE);
                holder.connect.setVisibility(View.VISIBLE);
                //holder.crypto.setText("CryptoAddress: NO");
            }

            if (data.getDapConnectionState() == DAPConnectionState.REGISTERED_ONLINE || data.getDapConnectionState() == DAPConnectionState.CONNECTED_ONLINE) {
                holder.status.setText(R.string.status_online);
                holder.status.setBackgroundColor(holder.status.getResources().getColor(R.color.background_status_online));
            }
            if (data.getDapConnectionState() == DAPConnectionState.REGISTERED_OFFLINE || data.getDapConnectionState() == DAPConnectionState.CONNECTED_OFFLINE) {
                holder.status.setText(R.string.status_offline);
                holder.status.setBackgroundColor(holder.status.getResources().getColor(R.color.background_status_offline));
            }
            if (data.getDapConnectionState() == DAPConnectionState.CONNECTING) {
                holder.status.setText(R.string.status_connecting);
            }

            holder.connect.setChecked(data.selected);
            holder.connect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dataSet.get(position).selected = !dataSet.get(position).selected;
                    notifyItemChanged(position);
                    if (adapterChangeListener != null)
                        adapterChangeListener.onDataSetChanged(dataSet);
                }
            });

            /*
            This is for clicking all the box. I want,
            for now, only the check, So when I click, I can display de user profile
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dataSet.get(position).selected = !dataSet.get(position).selected;
                    notifyItemChanged(position);
                    if (adapterChangeListener != null)
                        adapterChangeListener.onDataSetChanged(dataSet);
                }
            });*/

            byte[] profileImage = data.getProfileImage();

            //TODO: chamo esto te va a tirar error si es nula la imagen :p, el leght no lo va a poder sacar
//            if (profileImage != null && profileImage.length > 0) {
//                holder.thumbnail.setImageDrawable(new BitmapDrawable(context.getResources(),
//                        BitmapFactory.decodeByteArray(data.getProfileImage(), 0, data.getProfileImage().length)));
//            }

            if (profileImage != null) {
                if (profileImage.length > 0) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(profileImage, 0, profileImage.length);
                    holder.thumbnail.setImageBitmap(bitmap);
                } else Picasso.with(context).load(R.drawable.profile_image_standard).into(holder.thumbnail);
            } else Picasso.with(context).load(R.drawable.profile_image_standard).into(holder.thumbnail);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setAdapterChangeListener(AdapterChangeListener<Actor> adapterChangeListener) {
        this.adapterChangeListener = adapterChangeListener;
    }

    public int getSize() {
        if (dataSet != null)
            return dataSet.size();
        return 0;
    }
}
