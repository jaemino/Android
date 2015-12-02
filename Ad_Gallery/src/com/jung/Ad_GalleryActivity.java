package com.jung;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;


public class Ad_GalleryActivity extends Activity {
	ImageView selectImage;
	Gallery gallery;
	int[] images = {
			R.drawable.apple,
			R.drawable.banana,
			R.drawable.cherry,
			R.drawable.grape,
			R.drawable.kiwi,
			R.drawable.mango,
			R.drawable.melon,
			R.drawable.peach,
			R.drawable.pear,
			R.drawable.plum,
			R.drawable.strawberry			
	};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        gallery = (Gallery)findViewById(R.id.gallery1);
        selectImage = (ImageView)findViewById(R.id.select);
        gallery.setAdapter(new ImageTestAdapter(this));
        
        gallery.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				selectImage.setImageResource(images[position]);						
			}
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub				
			}
		});
        
    }
    
    class ImageTestAdapter extends BaseAdapter{

    	Context context;
    	
    	public ImageTestAdapter(Context context) {
			// TODO Auto-generated constructor stub
    		this.context = context;
		}
    	
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return images.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return images[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView image;
			if(convertView == null){
				image = new ImageView(context);
			} else{
				image = (ImageView)convertView;
			}
			
			image.setImageResource(images[position]);
			image.setScaleType(ImageView.ScaleType.CENTER_CROP);
			
			image.setLayoutParams(new Gallery.LayoutParams(100, 100));
			return image;
		}
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ad__gallery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
