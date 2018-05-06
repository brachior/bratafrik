package net.brach.android.bratafrik

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        date_current.text = "Novembre 2017"
        date_previous.text = "Octobre"

        balance_current.text = "+5000"
        online_current.text = "+5000"

        balance_previous.text = "+5000"
        online_previous.text = "+5000"

        val list = ArrayList<AccountItem>()
        list.add(AccountLabel("Livret A"))
        list.add(Account("123456789", "Angélique", Account.Data("Oct.", 5000, 5000), Account.Data("Nov.", 5000, 5000)))
        list.add(Account("012345678", "Jérôme", Account.Data("Oct.", 5000, 5000), Account.Data("Nov.", 5000, 5000)))

        list.add(AccountLabel("Compte Courant"))
        list.add(Account("123495678", "Angélique", Account.Data("Oct.", 5000, 5000), Account.Data("Nov.", 5000, 5000)))
        list.add(Account("012348567", "Jérôme", Account.Data("Oct.", 5000, 5000), Account.Data("Nov.", 5000, 5000)))
        list.add(Account("912345678", "Commun", Account.Data("Oct.", 5000, 5000), Account.Data("Nov.", 5000, 5000)))

        accounts.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        accounts.setHasFixedSize(true)
        accounts.adapter = AccountAdapter(list)
    }
}

class AccountAdapter(private val accounts: ArrayList<AccountItem>) : RecyclerView.Adapter<AccountAdapter.VH>() {

    override fun onBindViewHolder(holder: VH, position: Int) {
        when {
            holder.itemView != null -> accounts[position].bind(holder.itemView)
        }
    }

    override fun getItemCount(): Int = accounts.size

    override fun onCreateViewHolder(parent: ViewGroup, layout: Int): VH =
        VH(LayoutInflater.from(parent.context).inflate(layout, parent, false))

    override fun getItemViewType(position: Int): Int = accounts[position].layout()

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView)
}

interface AccountItem {
    fun bind(view: View)
    fun layout(): Int
}
