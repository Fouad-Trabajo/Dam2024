package edu.example.dam2024.app.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import edu.example.dam2024.app.presentation.hide
import edu.example.dam2024.app.presentation.visible
import edu.example.dam2024.databinding.ViewErrorBinding

class ErrorAppView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    //Los FrameLayout son como capas

    private val binding =
        ViewErrorBinding.inflate(LayoutInflater.from(context), this, true)


    init {
        hide()
    }

    fun render(errorAppUI: ErrorAppUI) {
        binding.imageError.setImageResource(errorAppUI.getImageError())
        binding.titleError.text = errorAppUI.getTitleError()
        binding.descriptionError.text = errorAppUI.getDescriptionError()
        //actionButton...
        visible()
    }


    /**
     * Necesito saber que es una Custom View y FrameLayout
     * NOTA: Es mejor ocular la viewError desde código antes que hacerlo en la interfaz view
     *      porque las view no se puede testear y depurar errores
     *
     * Clean arquitecture: Tenemos modelos para cada caso
     * - Modelos para recoger datos de api
     * - Modelos para recoger datos de db local con room
     * - Modelos para gestionar errores en la presentación
     *
     * Para cada caso se tiene el mapper para convertir cada tipo de modelo a mi modelo de datos
     * que tengo en dominio y viceversa
     */
}