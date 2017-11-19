package net.brach.android.bratafrik

import android.view.View
import kotlinx.android.synthetic.main.item_account.view.*

class Account(private val number: String, private val name: String, private val next: Data, private val previous: Data) : AccountItem {
    override fun bind(view: View) {
        view.account_number.text = number
        view.account_name.text = name

        view.account_date_current.text = next.date
        view.account_balance_current.text = next.current.toString()
        view.account_online_current.text = next.future.toString()

        view.account_date_previous.text = previous.date
        view.account_balance_previous.text = previous.current.toString()
        view.account_online_previous.text = previous.future.toString()
    }

    override fun layout(): Int = R.layout.item_account

    class Data(val date: String, val current: Number, val future: Number)
}