package edu.uam.educore.model.personas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EstudianteRegularTest {

  @Test
  void calcularMatricula_retorna_tarifa_base() {
    EstudianteRegular e = new EstudianteRegular(1, "Juan", "Pérez", "j@uam.edu", "EST-001");
    assertEquals(150000.0, e.calcularMatricula(), 0.01);
  }

  @Test
  void puedeMatricular_siempre_retorna_true() {
    EstudianteRegular e = new EstudianteRegular(1, "Juan", "Pérez", "j@uam.edu", "EST-001");
    assertTrue(e.puedeMatricular());
  }

  @Test
  void getTipo_retorna_texto_correcto() {
    EstudianteRegular e = new EstudianteRegular(1, "Juan", "Pérez", "j@uam.edu", "EST-001");
    assertEquals("Estudiante Regular", e.getTipo());
  }

  @Test
  void getInfo_incluye_carnet_y_matricula() {
    EstudianteRegular e = new EstudianteRegular(1, "Juan", "Pérez", "j@uam.edu", "EST-001");
    String info = e.getInfo();
    assertTrue(info.contains("EST-001"));
    assertTrue(info.contains("150000"));
  }
}
