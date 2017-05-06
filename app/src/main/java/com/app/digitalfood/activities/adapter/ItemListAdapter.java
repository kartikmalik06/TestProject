package com.app.digitalfood.activities.adapter;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.digitalfood.DataObject.ItemData;
import com.app.digitalfood.R;
import com.app.digitalfood.activities.BaseActivity;
import com.app.digitalfood.activities.view.OrderPage;
import com.app.digitalfood.database.DatabaseHandler;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beyond on 23-Feb-17.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {
    OrderPage orderPage;
    List<ItemData> menuList = new ArrayList<>();
    boolean isExpand = false;
    private Animation animationUp;
    private int expandedPosition = -1;
    DatabaseHandler db;
    private final int COUNTDOWN_RUNNING_TIME = 500;


    public ItemListAdapter(OrderPage orderPage, List<ItemData> menuList) {
        this.orderPage = orderPage;

        this.menuList = menuList;
        animationUp = AnimationUtils.loadAnimation(orderPage, R.anim.slide_up);
        db=DatabaseHandler.getInstance(orderPage);


    }

    @Override
    public ItemListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new ItemListAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ItemListAdapter.ViewHolder holder, final int position) {
        final ItemData itemData = menuList.get(position);

        Picasso.with(orderPage).load(itemData.getImageUrl()).into(holder.foodImage);
        holder.foodName.setText(itemData.getName());
        holder.foodPrice.setText("Rs. " + itemData.getPrice());
        holder.discription.setText(itemData.getDiscription());
        holder.detailLayout.setVisibility(position == expandedPosition ? View.VISIBLE : View.GONE);
        boolean isChecked=db.getItem(BaseActivity.getBranchID(),itemData.getId()).isChecked();
        holder.addToCart.setBackgroundResource(isChecked ? R.drawable.cart_icon_bg_checked
                : R.drawable.cart_icon_bg_unchecked);
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpand) {
                    holder.detailLayout.setVisibility(View.GONE);
                } else {
                   /* if (expandedPosition >= 0) {
                        int prev = expandedPosition;
                        notifyItemChanged(prev);
                    }
                    expandedPosition = holder.getAdapterPosition();
                    notifyItemChanged(expandedPosition);
                    holder.detailLayout.setVisibility(View.VISIBLE);
                    holder.detailLayout.startAnimation(animationDown);*/
                    if (expandedPosition >= 0) {
                        int prev = expandedPosition;
                        notifyItemChanged(prev);
                    }
                    expandedPosition = holder.getAdapterPosition();
                   // TransitionManager.beginDelayedTransition(listView);
                    notifyItemChanged(expandedPosition);
                }
                isExpand = !isExpand;
            }
        });
        holder.count.setText(String.valueOf(db.getItem(BaseActivity.getBranchID(),itemData.getId()).getQuantity()));

       /* if (itemData.isChecked()) {
            holder.addToCart.setBackgroundResource(R.drawable.cart_icon_bg_checked);
        } else {
            holder.addToCart.setBackgroundResource(R.drawable.cart_icon_bg_unchecked);
        }*/
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderPage.removeItem(itemData);
                holder.addToCart.setBackgroundResource(R.drawable.cart_icon_bg_unchecked);
                itemData.setQuantity(itemData.getQuantity() + 1);
                holder.count.setText(String.valueOf(itemData.getQuantity()));
            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.valueOf(holder.count.getText().toString()) >1) {
                    orderPage.removeItem(itemData);
                    holder.addToCart.setBackgroundResource(R.drawable.cart_icon_bg_unchecked);
                    itemData.setQuantity(itemData.getQuantity() - 1);
                    holder.count.setText(String.valueOf(itemData.getQuantity()));
                }
            }
        });
        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemData.isChecked()) {
                    itemData.setChecked(false);
                    orderPage.removeItem(itemData);
                    holder.addToCart.setBackgroundResource(R.drawable.cart_icon_bg_unchecked);

                } else {
                    itemData.setChecked(true);
                    orderPage.addItem(itemData, BaseActivity.getBranchID());
                    holder.addToCart.setBackgroundResource(R.drawable.cart_icon_bg_checked);

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView foodType, foodImage, plus, minus, addToCart;
        public TextView foodName, foodPrice, discription, count;
        public ConstraintLayout itemLayout, detailLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            itemLayout = (ConstraintLayout) itemView.findViewById(R.id.item_layout);
            detailLayout = (ConstraintLayout) itemView.findViewById(R.id.detail_layout);
            foodType = (ImageView) itemView.findViewById(R.id.type);
            foodImage = (ImageView) itemView.findViewById(R.id.item_image);
            plus = (ImageView) itemView.findViewById(R.id.plus);
            minus = (ImageView) itemView.findViewById(R.id.minus);
            addToCart = (ImageView) itemView.findViewById(R.id.add_to_cart);
            foodName = (TextView) itemView.findViewById(R.id.item_name);
            foodPrice = (TextView) itemView.findViewById(R.id.price);
            discription = (TextView) itemView.findViewById(R.id.discription);
            count = (TextView) itemView.findViewById(R.id.count);
        }
    }
   /* private void loadImage(final ImageView imageView, final String imageurl) {
        Log.d("image","loading....");
        new Thread(new Runnable() {

            @Override
            public void run() {
                final Bitmap bitmap;
                try {
                    bitmap = BitmapFactory.decodeStream((InputStream) new URL(imageurl).getContent());
                    imageView.post(new Runnable() {
                        public void run() {
                            if (bitmap != null) {
                                imageView.setImageBitmap(bitmap);
                            }
                        }
                    });
                } catch (Exception e) {
                    Log.d("image",e.getMessage());
                    //Toast.makeText(orderPage, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }).start();

    }*/

  /*  @Override
    public int getGroupCount() {
        return this.menuList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return menuList.get(groupPosition).getItemData().size();
    }

    @Override
    public CategoryData getGroup(int groupPosition) {

        return menuList.get(groupPosition);
    }

    @Override
    public ItemData getChild(int groupPosition, int childPosition) {
        return menuList.get(groupPosition).getItemData().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return (long) (groupPosition * 1024);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return (long) (groupPosition * 1024 + childPosition);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        final CategoryData foodGroup = getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }
        ImageView groupIndicator = (ImageView) convertView.findViewById(R.id.indicator);
        TextView listHeader = (TextView) convertView
                .findViewById(R.id.group_lable);
        listHeader.setTypeface(null, Typeface.BOLD);
        listHeader.setText(foodGroup.getName());

        return convertView;

    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        final ItemData childItem = getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group_item, null);
            holder = new ViewHolder();
            holder.itemName = (TextView) convertView.findViewById(R.id.items);
            holder.plus = (TextView) convertView.findViewById(R.id.plus);
            holder.minus = (TextView) convertView.findViewById(R.id.minus);
            holder.quantity = (TextView) convertView.findViewById(R.id.quantity);
            holder.addToCart = (ImageView) convertView.findViewById(R.id.add_cart);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            // holder.itemName.setTag(childItem.getName());
        }

        holder.itemName.setText(childItem.getName());
        holder.quantity.setText(String.valueOf(childItem.getQuantity()));
        if (getChild(groupPosition, childPosition).getChecked()) {
            holder.addToCart.setBackgroundColor(Color.YELLOW);
        } else {
            holder.addToCart.setBackgroundColor(Color.WHITE);
        }
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.valueOf(holder.quantity.getText().toString()) > 0) {
                    orderPage.removeItem(childItem);
                    holder.addToCart.setBackgroundColor(Color.WHITE);
                    childItem.setQuantity(childItem.getQuantity() - 1);
                    holder.quantity.setText(String.valueOf(childItem.getQuantity()));
                }
            }
        });

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderPage.removeItem(childItem);
                holder.addToCart.setBackgroundColor(Color.WHITE);
                childItem.setQuantity(childItem.getQuantity() + 1);
                holder.quantity.setText(String.valueOf(childItem.getQuantity()));

            }
        });


        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getChild(groupPosition, childPosition).getChecked()) {
                    orderPage.removeItem(childItem);
                    holder.addToCart.setBackgroundColor(Color.WHITE);
                    getChild(groupPosition, childPosition).setChecked(false);
                } else {

                    orderPage.addItem(childItem);
                    holder.addToCart.setBackgroundColor(Color.YELLOW);
                    getChild(groupPosition, childPosition).setChecked(true);
                }

            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


    class ViewHolder {

        public TextView itemName;
        public TextView plus, minus, quantity;
        public ImageView addToCart;
    }*/

}
