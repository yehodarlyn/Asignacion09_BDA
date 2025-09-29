package com.mycompany.asignacion09_251632;

import com.mycompany.asignacion09_251632.dao.EmpleadoDAO;
import com.mycompany.asignacion09_251632.models.Empleado;
import com.mycompany.asignacion09_251632.models.Empleado.Estatus;

import java.time.LocalDate;

public class JPAEmpresa {

    public static void main(String[] args) {
        EmpleadoDAO dao = new EmpleadoDAO();

        // Insertar ejemplo
        Empleado e1 = new Empleado("Ana", "ana@mail.com", 15000.0,
                Estatus.ACTIVO, LocalDate.now());
        dao.insertar(e1);

        // Listar
        dao.listar().forEach(emp -> System.out.println(emp.getNombre()));

        // Aumentar salario
        dao.aumentarSalario(e1.getId(), 10.0);

        // Actualizar estatus
        e1.setEstatus(Estatus.INACTIVO);
        dao.actualizar(e1);

        // Eliminar
        dao.eliminar(e1.getId());
    }
}
