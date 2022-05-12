package com.example.option_menu_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnChonmau;
    Button btnMenu;
    ConstraintLayout manHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChonmau = (Button)findViewById(R.id.buttonChonMau);
        btnMenu = (Button) findViewById(R.id.buttonMenu);
        manHinh = (ConstraintLayout) findViewById(R.id.manHinh);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ShowMenu();
            }
        });

        //Đăng kí view cho context
        registerForContextMenu(btnChonmau);
        registerForContextMenu(btnMenu);
    }

    private void ShowMenu(){
        PopupMenu popupMenu = new PopupMenu(this, btnMenu);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.menuAdd: btnMenu.setText("Thêm");
                        break;
                    case R.id.menuDelete: btnMenu.setText("Xóa");
                        break;
                    case R.id.menuUpdate: btnMenu.setText("Sửa");
                        break;
                }

                return false;
            }
        });
        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("Chọn màu");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuDo: manHinh.setBackgroundColor(Color.RED);
                break;
            case R.id.menuVang: manHinh.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.menuXanh: manHinh.setBackgroundColor(Color.BLUE);
                break;
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.option_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_settings:
                Toast.makeText(this, "Bạn chọn Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_search:
                Toast.makeText(this, "Bạn chọn Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_share:
                Toast.makeText(this, "Bạn chọn Share", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}