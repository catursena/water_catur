package android.catursena.com.CATURSENA_1202152171_MODUL3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

class WaterAdapter extends RecyclerView.Adapter<WaterAdapter.WaterViewHolder>  {


    //Member variables
    private GradientDrawable mGradientDrawable;
    private ArrayList<Water> mWaterData;
    private Context mContext;


    WaterAdapter(Context context, ArrayList<Water> sportsData) {
        this.mWaterData = sportsData;
        this.mContext = context;

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Make the placeholder same size as the images
        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.ades);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

    }

    @Override
    public WaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WaterViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }
    @Override
    public void onBindViewHolder(WaterViewHolder holder, int position) {

        //Get the current sport
        Water currentWater = mWaterData.get(position);

        //Bind the data to the views
        holder.bindTo(currentWater);

    }

    @Override
    public int getItemCount() {
        return mWaterData.size();
    }


    static class WaterViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //Member Variables for the holder data
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mWaterImage;
        private Context mContext;
        private Water mCurrentWater;
        private GradientDrawable mGradientDrawable;

        WaterViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mWaterImage = (ImageView)itemView.findViewById(R.id.waterImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(Water currentWater){
            //Populate the textviews with data
            mTitleText.setText(currentWater.getTitle());
            mInfoText.setText(currentWater.getInfo());

            //Get the current sport
            mCurrentWater = currentWater;



            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentWater.
                    getImageResource()).placeholder(mGradientDrawable).into(mWaterImage);
        }

        @Override
        public void onClick(View view) {

            //Set up the detail intent
            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("title", mCurrentWater.getTitle());
            detailIntent.putExtra("image_resource", mCurrentWater.getImageResource());


            //Start the detail activity
            mContext.startActivity(detailIntent);
        }
    }
}



