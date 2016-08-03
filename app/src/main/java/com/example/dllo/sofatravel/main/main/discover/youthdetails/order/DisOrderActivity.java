package com.example.dllo.sofatravel.main.main.discover.youthdetails.order;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dllo.sofatravel.R;
import com.example.dllo.sofatravel.main.main.base.BaseActivity;
import com.example.dllo.sofatravel.main.main.discover.youthdetails.order.mineorder.MineOrderActivity;
import com.example.dllo.sofatravel.main.main.tools.MyLiteOrm;
import com.example.dllo.sofatravel.main.main.tools.alipay.Merchant;
import com.example.dllo.sofatravel.main.main.tools.alipay.OrderUtils;
import com.fuqianla.paysdk.FuQianLaPay;

/**
 * Created by dllo on 16/7/28.
 */
public class DisOrderActivity extends BaseActivity implements View.OnClickListener {
    private TextView hotelName, price;
    private Button payBtn;
    private TextView bookRooms;
    private ImageView backBtn;
    private TextView mineOrder;
    private Button orderPay;
    private ImageView picture;
    private EditText name,phoneNumber;




    @Override
    public int getLayout() {
        return R.layout.activity_dis_order;
    }

    @Override
    public void initView() {
        name = (EditText) findViewById(R.id.dis_order_name);
        phoneNumber = (EditText) findViewById(R.id.dis_order_phone);
        hotelName = (TextView) findViewById(R.id.dis_order_hotel_name);
        payBtn = (Button) findViewById(R.id.dis_order_pay);
        bookRooms = (TextView) findViewById(R.id.dis_order_book_rooms);
        price = (TextView) findViewById(R.id.dis_order_price);
        backBtn = (ImageView) findViewById(R.id.dis_order_back);
        backBtn.setOnClickListener(this);
        hotelName.setText(getIntent().getStringExtra("hotelName"));
        price.setText(getIntent().getIntExtra("price", 0) + ".00");
        mineOrder = (TextView) findViewById(R.id.dis_order_mine_order);
        mineOrder.setOnClickListener(this);
        orderPay = (Button) findViewById(R.id.dis_order_pay);
        orderPay.setOnClickListener(this);
        picture= (ImageView) findViewById(R.id.dis_order_picture);
        Glide.with(this).load(getIntent().getStringExtra("picture")).into(picture);

        bookRooms.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    price.setText(getIntent().getIntExtra("price", 0) * Integer.valueOf(bookRooms.getText().toString()) + ".00");
                }
                if (s.length() == 0){
                    price.setText(getIntent().getIntExtra("price", 0) + ".00");
                }
            }
        });

    }

    @Override
    public void initData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dis_order_back:
                finish();
                break;
            case R.id.dis_order_mine_order:
                Intent orderIntent = new Intent(this, MineOrderActivity.class);
                startActivity(orderIntent);
                break;
            case R.id.dis_order_pay:

                saveToDataBase();
                break;
        }
    }

    private void toPay() {
        FuQianLaPay pay = new FuQianLaPay.Builder(this)
                .partner(Merchant.MERCHANT_NO)//商户号
                .alipay(true)
                .orderID(OrderUtils.getOutTradeNo())//订单号
                .amount(Double.parseDouble("0.1"))//金额
                .subject("床位")//商品名称
                .body("~~~~~~")//商品交易详情
                .notifyUrl(Merchant.MERCHANT_NOTIFY_URL)
                .build();
        pay.startPay();
    }

    // 存到数据库
    private void saveToDataBase(){
        int bedNum = 0;
        if (name.getText().length() > 0 && phoneNumber.getText().length() > 0) {
            if (bookRooms.getText().length() == 0){
                bedNum =  1;
            } else {
                bedNum = Integer.valueOf(bookRooms.getText().toString());
            }
            MyLiteOrm.getSingleLiteOrm().getLiteOrm().insert(new OrderBean(hotelName.getText().toString(),
                    price.getText().toString(), bedNum, name.getText().toString(),
                    phoneNumber.getText().toString(), getIntent().getStringExtra("address")));
            toPay();
        } else {
            Toast.makeText(this, "请输入姓名和手机号码", Toast.LENGTH_SHORT).show();
        }
    }

}
