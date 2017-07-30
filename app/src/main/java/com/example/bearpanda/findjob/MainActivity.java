package com.example.bearpanda.findjob;

import android.support.annotation.IdRes;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.example.bearpanda.findjob.category.view.CategoryFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class MainActivity extends ActionBarActivity {
    BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBar = BottomBar.attach(this, savedInstanceState);
        bottomBar.setItems(R.menu.menu_main);
        bottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.item1){
                    CategoryFragment fragment1 = new CategoryFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment1).commit();
                }else if (menuItemId == R.id.item2){
                    ConnectFragment connectFragment = new ConnectFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, connectFragment).commit();
                }else  if (menuItemId == R.id.item3){
                    ChatFragment chatFragment = new ChatFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, chatFragment).commit();
                }else {
                    AddressFragment addressFragment = new AddressFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, addressFragment).commit();
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });

        //set color when select tap
        bottomBar.mapColorForTab(0, "#F44336");
        bottomBar.mapColorForTab(1, "#9C27B0");
        bottomBar.mapColorForTab(2, "#03A9F4");
        bottomBar.mapColorForTab(3, "#79554B");


    }
}
