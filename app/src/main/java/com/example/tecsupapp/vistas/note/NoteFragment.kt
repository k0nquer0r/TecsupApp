package com.example.tecsupapp.vistas.note

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tecsupapp.R
import com.example.tecsupapp.model.Nota
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.dialog_note.*
import kotlinx.android.synthetic.main.dialog_note.view.*
import kotlinx.android.synthetic.main.fragment_note.*
import java.time.Duration

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.log


class NoteFragment: Fragment(), NoteAdapter.ItemClickListener{

    private lateinit var noteViewModel: NoteViewModel

    lateinit var  List: List<Nota>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note, container, false)
    }

    companion object {
        fun newInstance(): NoteFragment = NoteFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        noteViewModel = run {
            ViewModelProviders.of(this).get(NoteViewModel::class.java)
        }

        fabRegisterNote.setOnClickListener {
            RegisterAndUpdateNote(null, TypeNoteOperation.REGISTER)
        }

        loadData()
        configurationTouchRecycler()
    }

    private fun loadData() {
        val adapter = NoteAdapter(this)
        recyclerNote.adapter = adapter
        recyclerNote.layoutManager = LinearLayoutManager(activity)

        noteViewModel.notes.observe(viewLifecycleOwner) { notes ->
            if (notes.isNotEmpty()){
                List = notes
                notes?.let {
                    adapter.setNotes(notes)
                }
            }
        }
    }

    private fun RegisterAndUpdateNote(nota: Nota?, type: TypeNoteOperation) {

        val mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_note, null)

        val titleAlertNota = if (type == TypeNoteOperation.REGISTER) "Registrar Nota" else "Editar Nota"

        val mBuilder = AlertDialog.Builder(context)
            .setView(mDialogView)
            .setTitle(titleAlertNota)

        val mAlertDialog = mBuilder.show()

        if(type == TypeNoteOperation.UPDATE){
            mDialogView.titleNote.setText(nota?.title)
            mDialogView.descriptionNote.setText(nota?.description)
        }

        mAlertDialog.btnRegisterNote.setOnClickListener {

            mAlertDialog.dismiss()

            val titleNote = mDialogView.titleNote.text.toString()
            val descriptionNote = mDialogView.descriptionNote.text.toString()

            val date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))


            val note = Nota(titleNote, descriptionNote, date)

            if (type ==TypeNoteOperation.REGISTER){
                noteViewModel.saveNote(note)
            }else{
                if (nota != null){
                    note.noteID = nota.noteID
                }
                noteViewModel.updateNote(note)
            }
        }

    }

    override fun onItemClick(nota: Nota) {
        RegisterAndUpdateNote(nota, TypeNoteOperation.UPDATE)
    }

    private fun configurationTouchRecycler(){

        val itemTouchHelperCallback =
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    noteViewModel.deleteNote(List[position])

                    view!!.snack("Nota eliminada correctamente")

                }

                override fun getMovementFlags(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder
                ): Int {
                    return ItemTouchHelper.Callback.makeMovementFlags(ItemTouchHelper.LEFT , ItemTouchHelper.START)
                }
            }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerNote)
    }

    fun View.snack(mensaje: String, duration: Int = Snackbar.LENGTH_LONG){
        val snackBar = Snackbar.make(this, mensaje, duration)
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(Color.RED)
        snackBar.show()
    }

}