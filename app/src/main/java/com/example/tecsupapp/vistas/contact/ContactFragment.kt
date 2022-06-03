package com.example.tecsupapp.vistas.contact

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tecsupapp.R
import com.example.tecsupapp.model.Contact
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.add_contact.*
import kotlinx.android.synthetic.main.add_contact.view.*
import kotlinx.android.synthetic.main.dialog_note.*
import kotlinx.android.synthetic.main.dialog_note.view.*
import kotlinx.android.synthetic.main.fragment_contact.*
import kotlinx.android.synthetic.main.item_contac.view.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ContactFragment: Fragment(), ContactAdapter.ItemClickListener{

    private lateinit var contactViewModel: ContactViewModel

    lateinit var List: List<Contact>

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
            RegisterAndUpdateContact(null, TypeContactOperation.REGISTER)
        }

        loadData()
        configurationTouchRecycler()
    }

    private fun loadData(){
        val adapter = ContactAdapter(this)
        recyclerContact.adapter = adapter
        recyclerContact.layoutManager = LinearLayoutManager(activity)

        contactViewModel.contacts.observe(viewLifecycleOwner) {contacts ->
            if (contacts.isNotEmpty()){
                List = contacts
                contacts?.let {
                    adapter.setContact(contacts)
                }
            }
        }
    }

    private fun RegisterAndUpdateContact(contact: Contact?, type: TypeContactOperation){
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.add_contact, null)

        val titleAlertContact = if (type == TypeContactOperation.REGISTER)"Registrar contacto" else "editar contacto"

        val mBuilder = AlertDialog.Builder(context).setView(mDialogView).setTitle(titleAlertContact)

        val mAlertDialog = mBuilder.show()

        if(type == TypeContactOperation.UPDATE){
            mDialogView.textaddfullname.setText(contact?.fullname)
            mDialogView.textaddphonenumber.setText(contact?.phonenumber)
            mDialogView.textaddemail.setText(contact?.email)
            mDialogView.textaddaddress.setText(contact?.address)
        }

        mAlertDialog.btnRegisterContact.setOnClickListener{
            mAlertDialog.dismiss()
            val textaddfullname = mDialogView.textaddfullname.text.toString()
            val textaddphonenumber = mDialogView.textaddphonenumber.text.toString()
            val textaddemail = mDialogView.textaddemail.text.toString()
            val textaddaddress = mDialogView.textaddaddress.text.toString()

            val contact = Contact(textaddfullname, textaddphonenumber,textaddemail, textaddaddress)

            if (type == TypeContactOperation.REGISTER){
                contactViewModel.saveContact(contact)
            }else{
                if (contact != null){
                    contact.contactID = contact.contactID
                }
                contactViewModel.updateContac(contact)
            }
        }
    }



    override fun onItemClick(contact: Contact) {
        RegisterAndUpdateContact(contact, TypeContactOperation.UPDATE)
    }

    private fun configurationTouchRecycler(){

        val itemTouchHelperCallback =
            object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    contactViewModel.deleteContact(List[position])

                    view!!.snack("Contacto eliminado correctamente")
                }

                override fun getMovementFlags(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder
                ): Int {
                    return ItemTouchHelper.Callback.makeMovementFlags(ItemTouchHelper.LEFT, ItemTouchHelper.START)
                }
            }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerContact)
    }

    fun View.snack(mensaje: String, duration: Int = Snackbar.LENGTH_LONG){
        val snackBar = Snackbar.make(this, mensaje, duration)
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(Color.RED)
        snackBar.show()
    }
}