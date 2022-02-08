package Edit.EducacionIT20Ene2022; // Nombre del paquete al cual pertenece mi archivo

import org.testng.annotations.Test;

/**
 * Clase de ejemplo
 * en Java
 */
public class AppTest 
{
	// Variables
	String nombreCurso = "Curso de Automatización";
	
	// Métodos
    @Test
    public void imprimir()
    {
    	// Acciones que hace el método
    	System.out.println("Hola " + nombreCurso);
    }
}
