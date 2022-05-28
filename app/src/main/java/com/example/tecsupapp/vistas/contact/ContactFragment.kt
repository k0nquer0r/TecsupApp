package com.example.tecsupapp.vistas.contact

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tecsupapp.R
import com.example.tecsupapp.model.Contact
import kotlinx.android.synthetic.main.add_contact.*
import kotlinx.android.synthetic.main.add_contact.view.*
import kotlinx.android.synthetic.main.dialog_note.*
import kotlinx.android.synthetic.main.fragment_contact.*
import kotlinx.android.synthetic.main.item_contac.view.*

class ContactFragment: Fragment() {

    private lateinit var contactViewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    companion object{
        fun newInstance(): ContactFragment = ContactFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contactViewModel = run {
            ViewModelProviders.of(this).get(ContactViewModel::class.java)
        }

        fabRegisterContact.setOnClickListener{
            registerAlertContact()
        }

        loadData()
    }

    private fun loadData(){
        val adapter = ContactAdapter()
        recyclerContact.adapter = adapter
        recyclerContact.layoutManager = LinearLayoutManager(activity)

        contactViewModel.contacts.observe(viewLifecycleOwner) {contacts ->
            if (contacts.isNotEmpty()){
                contacts?.let {
                    adapter.setContact(contacts)
                }
            }
        }
    }

    private fun registerAlertContact(){
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.add_contact, null)

        val mBuilder = AlertDialog.Builder(context)
            .setView(mDialogView)

        val mAlertDialog = mBuilder.show()

        mAlertDialog.btnRegisterContact.setOnClickListener{

            mAlertDialog.dismiss()

            val addfullname = mDialogView.textaddfullname.text.toString()

            val addphonenumber = mDialogView.textaddphonenumber.text.toString()

            val addemail = mDialogView.textaddaddress.text.toString()

            val contact = Contact(addfullname, addphonenumber, addemail )

            contactViewModel.saveContact(contact)
        }
    }
}