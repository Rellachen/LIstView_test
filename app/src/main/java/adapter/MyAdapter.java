package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listview_test.Data;
import com.example.listview_test.R;

import java.util.LinkedList;

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private LinkedList<Data> mData;

    public MyAdapter() {};

    public MyAdapter(Context mContext, LinkedList<Data> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list, parent, false);
        }

        ImageView img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
        TextView txt_content = (TextView) convertView.findViewById(R.id.txt_content);

        img_icon.setBackgroundResource(mData.get(position).getImgId());
        txt_content.setText(mData.get(position).getContent());

        return convertView;
    }

    public void add(Data data) {
        if (mData == null) {
            mData = new LinkedList<>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }

    public void add(int position, Data data) {
        if (mData.size() >= position) {
            mData.add(position, data);
            notifyDataSetChanged();
        }
        else {
            add(data);
        }
    }

    public void remove(Data data) {
        if (mData.size() > 0) {
            mData.remove(data);
            notifyDataSetChanged();
        }
        else {
            Toast.makeText(mContext, "没有可以删除的记录啦～", Toast.LENGTH_SHORT).show();
        }
    }

    public void remove(int position) {
        if (mData.size() > position) {
            mData.remove(position);
            notifyDataSetChanged();
        }
        else {
            Toast.makeText(mContext, "没有可以删除的记录啦～", Toast.LENGTH_SHORT).show();
        }
    }
}
