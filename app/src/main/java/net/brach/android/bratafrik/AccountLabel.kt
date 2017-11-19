package net.brach.android.bratafrik

import android.view.View
import kotlinx.android.synthetic.main.item_account_label.view.*

class AccountLabel(private val label: String) : AccountItem {
    override fun bind(view: View) {
        view.label.text = label
    }

    override fun layout(): Int = R.layout.item_account_label
}