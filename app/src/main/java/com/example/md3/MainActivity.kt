package com.example.md3

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.md3.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception
import java.util.Objects


class MainActivity : AppCompatActivity(){

private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityMainBinding.inflate(layoutInflater)

     setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        //隐藏actionbar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        val supportActionBar = supportActionBar
        supportActionBar?.hide()



        var button4 : Button = findViewById(R.id.button4)
        button4.setOnClickListener{
            var REQUEST_CODE_PERMISSION_STORAGE = 100;
            var permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            try {
                permissions.forEach {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(it) != PackageManager.PERMISSION_GRANTED) {
                            requestPermissions(arrayOf(it), REQUEST_CODE_PERMISSION_STORAGE)
                        }
                    }
                }
                val publicPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()


                var file4:File =File(publicPath,"12.txt")
                var ss = file4.readText().split(",")
                var n=(0..10).random()
                Toast.makeText(this, ss[n].toString(), Toast.LENGTH_SHORT).show();

            }catch (e:Exception){
                println(e.toString())
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }

        }










        var button5 : Button = findViewById(R.id.button5)
        button5.setOnClickListener{
            var REQUEST_CODE_PERMISSION_STORAGE = 100;

            var permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE)


            try {
                permissions.forEach {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(it) != PackageManager.PERMISSION_GRANTED) {
                            requestPermissions(arrayOf(it), REQUEST_CODE_PERMISSION_STORAGE)
                        }
                    }
                }
                val publicPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString()

                var file3: File = File(publicPath, "12.txt")
                file3.writeText("\"ZFZ\",\"BZS\"")

                var file4:File =File(publicPath,"12.txt")
                var ss = file4.readText()

                Toast.makeText(this, ss, Toast.LENGTH_SHORT).show();

            }catch (e:Exception){
                println(e.toString())
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }
//            val file : String = "1.txt"
//            val data : String = "1111"
//            val fileOutputStream:FileOutputStream
//            try{
//                var datab = data.toByteArray()
//                fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
//                fileOutputStream.write(datab)
//                fileOutputStream.close()
//
//                Toast.makeText(this, "Roll", Toast.LENGTH_SHORT).show();
//
//
//            }catch (e:Exception){
//                println(e.toString())
//            }


        }

    }





}

