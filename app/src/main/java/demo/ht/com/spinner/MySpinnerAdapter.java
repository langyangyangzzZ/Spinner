package demo.ht.com.spinner;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MySpinnerAdapter extends BaseAdapter {
    public ArrayList<SpinnerBean> mSpinnerBean;
    public Context mContext;

    public MySpinnerAdapter(ArrayList<SpinnerBean> mSpinnerBean,Context mContext) {
        this.mSpinnerBean = mSpinnerBean;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return mSpinnerBean.size();
    }

    @Override
    public Object getItem(int position) {
        return mSpinnerBean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewholer = null;
        if (view == null) {
             viewholer = new ViewHolder();
            view= LayoutInflater.from(mContext).inflate(R.layout.spinner_item_layout, null);
            viewholer.mImageView =  view.findViewById(R.id.image);
            viewholer.mTextView = view.findViewById(R.id.tv);
            view.setTag(viewholer);
        }else{
            viewholer  = (ViewHolder) view.getTag();
        }
        viewholer.mTextView.setText(mSpinnerBean.get(position).getTitle());
       Glide.with(mContext)
        .load(mSpinnerBean.get(position).getImage())
        .apply(new RequestOptions().placeholder(R.mipmap.ic_launcher))
        .into(viewholer.mImageView);
        return view;
    }

    class ViewHolder{
        private ImageView mImageView;
        private TextView mTextView;
    }
}
