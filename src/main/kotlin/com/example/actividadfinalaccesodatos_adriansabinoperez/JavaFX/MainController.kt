package com.example.actividadfinalaccesodatos_adriansabinoperez.JavaFX
/*
//import de.felixroske.jfxsupport.FXMLController
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.layout.VBox
import javafx.stage.Modality
import javafx.stage.Stage
import org.springframework.stereotype.Controller
import java.io.IOException
import java.net.URL

@Controller
class MainController {

    @FXML
    private lateinit var mainMenu: VBox

    @FXML
    fun mostrarSubMenuAgregar() {
        mostrarSubMenu("Agregar")
    }

    @FXML
    fun mostrarSubMenuActualizar() {
        mostrarSubMenu("Actualizar")
    }

    @FXML
    fun mostrarSubMenuEliminar() {
        mostrarSubMenu("Eliminar")
    }

    @FXML
    fun mostrarSubMenuLeer() {
        mostrarSubMenu("Leer")
    }

    private fun mostrarSubMenu(operacion: String) {
        try {
            val fxmlLoader = FXMLLoader()
            val resource: URL? = javaClass.getResource("SubmenuScene.fxml")
            fxmlLoader.location = resource

            val parent = fxmlLoader.load<Parent>()
            val stage = Stage()

            val submenuController = fxmlLoader.getController<SubmenuController>()
            submenuController.inicializar(operacion)

            stage.initModality(Modality.APPLICATION_MODAL)
            stage.title = "Submenú"
            stage.scene = Scene(parent)
            stage.showAndWait()

        } catch (e: IOException) {
            e.printStackTrace()
            // Manejo de errores
        }
    }
}
*/