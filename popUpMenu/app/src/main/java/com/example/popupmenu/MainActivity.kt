package com.example.popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(action)
        action.setOnClickListener {
            var popUp = PopupMenu(this,it)

            popUp.inflate(R.menu.my_menu)
                popUp.show()

            popUp.setOnMenuItemClickListener { menuItem ->
                when(menuItem.itemId)
                {
                    R.id.menu1 -> {
                        Toast.makeText(this, "option1",Toast.LENGTH_LONG).show()
                        true
                    }
                    R.id.menu2 -> {
                        Toast.makeText(this, "option2",Toast.LENGTH_LONG).show()
                        true
                    }
                    R.id.menu3 -> {
                        Toast.makeText(this, "option3",Toast.LENGTH_LONG).show()
                        true
                    }
                    else -> {
                        false
                    }
                }

            }
        }
    }

//    override fun onContextItemSelected(item: MenuItem): Boolean {
//        when(item.itemId)
//        {
//            R.id.menu1 -> {
//                Toast.makeText(this, "Menu1", Toast.LENGTH_LONG).show()
//            }
//            R.id.menu2 -> {
//                Toast.makeText(this, "Menu2", Toast.LENGTH_LONG).show()
//            }
//            R.id.menu3 -> {
//                Toast.makeText(this, "Menu3", Toast.LENGTH_LONG).show()
//            }
//        }
//
//        return super.onContextItemSelected(item)
//    }

//    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
//        super.onCreateContextMenu(menu, v, menuInfo)
//        menuInflater.inflate(R.menu.my_menu2,menu)
//    }

}
